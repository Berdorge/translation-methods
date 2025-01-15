{-# LANGUAGE DerivingStrategies         #-}
{-# LANGUAGE FlexibleContexts           #-}
{-# LANGUAGE GeneralizedNewtypeDeriving #-}
{-# LANGUAGE LambdaCase                 #-}
{-# LANGUAGE TypeFamilies               #-}

module Types
  ( Stream (..)
  , ParsingError (..)
  , Parser (..)
  , StringParser

  , satisfy
  , try
  , notFollowedBy
  , eof
  , parserError
  , runParser
  ) where

import Control.Applicative (Alternative (empty, (<|>)))
import Control.Monad (MonadPlus)
import Control.Monad.Trans.Class (lift)
import Control.Monad.Trans.Except (ExceptT (ExceptT), catchE, runExceptT, throwE, tryE, withExceptT)
import Control.Monad.Trans.State (State, get, put, runState)
import Data.Bifunctor (second)
import Data.Functor (($>))
import Data.Kind (Type)

class Stream s where
  type StreamToken s :: Type

  takeFromStream :: s -> Maybe (StreamToken s, s)

data ParsingError = ErrorAtPos Int String
  deriving (Eq, Show)

newtype Parser s a = Parser (ExceptT ParsingError (State (ParserState s)) a)
  deriving newtype (Functor, Applicative, Monad)

type StringParser = Parser String

satisfy :: (Stream s, Show (StreamToken s)) => (StreamToken s -> Bool) -> Parser s (StreamToken s)
satisfy predicate = getParserState >>= checkNextToken . takeFromState
  where checkNextToken = \case
          Nothing -> parserError "Unexpected end of input"
          Just (token, updatedState) | predicate token -> setParserState updatedState $> token
          Just (token, _) -> parserError ("Unexpected " ++ show token)

try :: Parser s a -> Parser s a
try (Parser p) = getParserState >>= \s ->
  Parser $ catchE p $ \case
    (ErrorAtPos _ description) -> lift (put s) *>
      throwE (ErrorAtPos (parserStatePos s) description)

notFollowedBy :: Parser s a -> Parser s ()
notFollowedBy (Parser p) = getParserState >>= \s ->
  Parser (tryE p) >>= \case
    (Left _) -> setParserState s
    (Right _) -> parserError "Unexpected suffix"

eof :: (Stream s) => Parser s ()
eof = getParserState >>= checkEof . takeFromState
  where
    checkEof Nothing  = return ()
    checkEof (Just _) = parserError "Expected end of input"

parserError :: String -> Parser s a
parserError errorDescription = getParserState >>= constructError . parserStatePos
  where constructError pos = Parser $ throwE $ ErrorAtPos pos errorDescription

runParser :: Parser s a -> s -> (Either ParsingError a, s)
runParser (Parser p) stream = let
  initialState = ParserState stream 0
  in second parserStateStream $ runState (runExceptT p) initialState

data ParserState s = ParserState {
  parserStateStream :: s,
  parserStatePos    :: Int
}

getParserState :: Parser s (ParserState s)
getParserState = Parser $ lift get

setParserState :: ParserState s -> Parser s ()
setParserState = Parser . lift . put

takeFromState :: Stream s => ParserState s -> Maybe (StreamToken s, ParserState s)
takeFromState s = second advanceState <$> takeFromStream (parserStateStream s)
  where advanceState updatedStream = ParserState updatedStream (parserStatePos s + 1)

instance Alternative (Parser s) where
  empty = parserError "No parsing rules specified"

  (Parser p) <|> (Parser q) = getParserState >>= \s ->
    Parser $ catchE p $ \case
      (ErrorAtPos pos _) | pos == parserStatePos s -> q
      other@(ErrorAtPos _ _) -> throwE other

instance MonadPlus (Parser s)

instance Stream [t] where
  type StreamToken [t] = t

  takeFromStream []       = Nothing
  takeFromStream (t : ts) = Just (t, ts)
