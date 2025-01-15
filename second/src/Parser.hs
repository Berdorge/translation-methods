{-# LANGUAGE LambdaCase #-}

module Parser
  ( parse
  , parseD
  , parseT
  ) where

import Control.Applicative
import Control.Monad
import Lexer
import Tree
import Types

parse :: String -> Either ParsingError (Tree String)
parse = fst . runParser parseD

parseD :: StringParser (Tree String)
parseD = do
  specificToken TokenVar
  name <- nextName
  specificToken TokenColon
  specificToken TokenArray
  specificToken TokenLangle
  typeTree <- parseT
  specificToken TokenRangle
  specificToken TokenSemicolon
  specificToken TokenEnd
  return $ Tree "D" [
    treeLeaf "var",
    treeLeaf name,
    treeLeaf ":",
    treeLeaf "Array",
    treeLeaf "<",
    typeTree,
    treeLeaf ">",
    treeLeaf ";"
    ]

parseT :: StringParser (Tree String)
parseT = parseTArray <|> parseTArbitrary

parseTArray :: StringParser (Tree String)
parseTArray = do
  try $ specificToken TokenArray
  specificToken TokenLangle
  typeTree <- parseT
  specificToken TokenRangle
  return $ Tree "T" [
    treeLeaf "Array",
    treeLeaf "<",
    typeTree,
    treeLeaf ">"
    ]

parseTArbitrary :: StringParser (Tree String)
parseTArbitrary = do
  name <- nextName
  return $ Tree "T" [treeLeaf name]

specificToken :: Token -> StringParser ()
specificToken t = nextToken >>= \x -> unless (x == t) (errorUnexpected x)
  where errorUnexpected x = parserError ("Expected " ++ show t ++ ", got " ++ show x)

nextName :: StringParser String
nextName = nextToken >>= \case
  (TokenName s) -> return s
  other -> parserError ("Expected name token, got " ++ show other)

nextToken :: StringParser Token
nextToken = lexeme token
