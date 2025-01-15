{-# LANGUAGE LambdaCase #-}

import Lexer (Token (..), lexeme, token)
import qualified Parser
import Test.Tasty
import Test.Tasty.HUnit
import Tree (Tree (..))
import Types (ParsingError (..), runParser)

main :: IO ()
main = defaultMain $ testGroup "tests" [
  testGroup "lexer tests" [
    testGroup "single tokens" [
      testCase "var token" $ extractToken "var" `isParsedTo` TokenVar

      , testCase "name token" $ extractToken "x" `isParsedTo` (TokenName "x")

      , testCase "colon token" $ extractToken ":" `isParsedTo` TokenColon

      , testCase "array token" $ extractToken "Array" `isParsedTo` TokenArray

      , testCase "langle token" $ extractToken "<" `isParsedTo` TokenLangle

      , testCase "rangle token" $ extractToken ">" `isParsedTo` TokenRangle

      , testCase "semicolon token" $ extractToken ";" `isParsedTo` TokenSemicolon
    ]

    , testGroup "sophisticated names" [
      testCase "multiletter name" $ extractToken "xyz" `isParsedTo` (TokenName "xyz")

      , testCase "name beginning with var" $
        extractToken "variable" `isParsedTo` (TokenName "variable")

      , testCase "name beginning with Array" $
        extractToken "Arrayname" `isParsedTo` (TokenName "Arrayname")

      , testCase "name containing var" $
        extractToken "somevariable" `isParsedTo` (TokenName "somevariable")

      , testCase "name ending with var" $
        extractToken "somevar" `isParsedTo` (TokenName "somevar")

      , testCase "name can't start with numeric char" $
        extractToken "1var" `isErrorAtPos` 0

      , testCase "name can contain numeric chars after the first char" $
        extractToken "x1234567890" `isParsedTo` (TokenName "x1234567890")

      , testCase "cases of letters in a name can be mixed" $
        extractToken "hElLoW0RlD" `isParsedTo` (TokenName "hElLoW0RlD")
    ]

    , testGroup "Token sequences tests" [
      testCase "expected grammar" $ extractTokens "var x: Array<Int>;" `isParsedTo` [
        TokenVar,
        TokenName "x",
        TokenColon,
        TokenArray,
        TokenLangle,
        TokenName "Int",
        TokenRangle,
        TokenSemicolon,
        TokenEnd
      ]

      , testCase "non-mandatory spaces are ignored" $
        extractTokens "  var  x  :  Array  <  Array  <  Int  >  >  ;  " `isParsedTo` [
          TokenVar,
          TokenName "x",
          TokenColon,
          TokenArray,
          TokenLangle,
          TokenArray,
          TokenLangle,
          TokenName "Int",
          TokenRangle,
          TokenRangle,
          TokenSemicolon,
          TokenEnd
        ]
    ]

    , testCase "Unrecognised character results in error" $
      extractTokens "var." `isErrorAtPos` 3
  ]

  , testGroup "parser tests" [
    testCase "production rule D -> var name: Array<T>;" $
      Parser.parse "var x: Array<Int>;" `isParsedTo` Tree "D" [
        Tree "var" [],
        Tree "x" [],
        Tree ":" [],
        Tree "Array" [],
        Tree "<" [],
        Tree "T" [Tree "Int" []],
        Tree ">" [],
        Tree ";" []
      ]

    , testCase "production rule T -> name" $
      parseT "Int" `isParsedTo` Tree "T" [
        Tree "Int" []
      ]

    , testCase "production rule T -> Array<T>" $
      parseT "Array<Int>" `isParsedTo` Tree "T" [
        Tree "Array" [],
        Tree "<" [],
        Tree "T" [Tree "Int" []],
        Tree ">" []
      ]

    , testCase "nested arrays" $
      Parser.parse "var x: Array<Array<Int>>;" `isParsedTo` Tree "D" [
        Tree "var" [],
        Tree "x" [],
        Tree ":" [],
        Tree "Array" [],
        Tree "<" [],
        Tree "T" [
          Tree "Array" [],
          Tree "<" [],
          Tree "T" [Tree "Int" []],
          Tree ">" []
        ],
        Tree ">" [],
        Tree ";" []
      ]

    , testGroup "missed token errors" [
      testCase "no var token" $
        Parser.parse "x: Array<Int>;" `isErrorAtPos` 1

      , testCase "no name token" $
        Parser.parse "var: Array<Int>;" `isErrorAtPos` 4

      , testCase "no colon token" $
        Parser.parse "var x Array<Int>;" `isErrorAtPos` 11

      , testCase "no array token" $
        Parser.parse "var x: <Int>;" `isErrorAtPos` 8

      , testCase "no langle token" $
        Parser.parse "var x: Array Int>;" `isErrorAtPos` 16

      , testCase "no T inside angled brackets" $
        Parser.parse "var x: Array<>;" `isErrorAtPos` 14

      , testCase "no rangle token" $
        Parser.parse "var x: Array<Int;" `isErrorAtPos` 17

      , testCase "no semicolon token" $
        Parser.parse "var x: Array<Int>" `isErrorAtPos` 17
    ]

    , testCase "eof expected after semicolon" $
      Parser.parse "var x: Array<Int>; var y: Array<Long>;" `isErrorAtPos` 22
  ]
  ]

extractToken :: String -> Either ParsingError Token
extractToken = fst . runParser (lexeme token)

extractTokens :: String -> Either ParsingError [Token]
extractTokens = fst . runParser extraction
  where extraction = lexeme token >>= \case
          TokenEnd -> return [TokenEnd]
          otherToken -> (otherToken :) <$> extraction

parseT :: String -> Either ParsingError (Tree String)
parseT = fst . runParser Parser.parseT

isErrorAtPos :: Either ParsingError a -> Int -> Assertion
isErrorAtPos (Left (ErrorAtPos p _)) pos = p @?= pos
isErrorAtPos (Right _) _ = assertFailure "Expected error, but parsing was successful"

isParsedTo :: (Eq a, Show a) => Either ParsingError a -> a -> Assertion
isParsedTo (Left e) _  = assertFailure $ "Expected successful parsing, but got error " ++ show e
isParsedTo (Right x) y = x @?= y
