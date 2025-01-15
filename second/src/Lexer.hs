module Lexer
  ( Token (..)

  , token
  , lexeme
  ) where

import Control.Applicative (Alternative (many, (<|>)))
import Data.Char (isAlpha, isAlphaNum, isSpace)
import Data.Functor (($>), (<&>))
import Types (StringParser, eof, notFollowedBy, satisfy, try)

data Token = TokenVar
  | TokenName String
  | TokenColon
  | TokenArray
  | TokenLangle
  | TokenRangle
  | TokenSemicolon
  | TokenEnd
  deriving (Eq, Show)

token :: StringParser Token
token = try (string "var" *> notFollowedBy (satisfy isAlphaNum) $> TokenVar)
    <|> try (string "Array" *> notFollowedBy (satisfy isAlphaNum) $> TokenArray)
    <|> (((:) <$> satisfy isAlpha <*> many (satisfy isAlphaNum)) <&> TokenName)
    <|> (char ':' $> TokenColon)
    <|> (char '<' $> TokenLangle)
    <|> (char '>' $> TokenRangle)
    <|> (char ';' $> TokenSemicolon)
    <|> (eof $> TokenEnd)

lexeme :: StringParser a -> StringParser a
lexeme = (spaces *>)

char :: Char -> StringParser Char
char c = satisfy (== c)

string :: String -> StringParser String
string = mapM char

spaces :: StringParser String
spaces = many space

space :: StringParser Char
space = satisfy isSpace
