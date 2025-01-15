module Main (main) where

import Data.Foldable (foldl')
import Data.Graph.Inductive.Graph (DynGraph, Node, empty, insEdge, insNode, order)
import Data.Graph.Inductive.PatriciaTree (Gr)
import Data.GraphViz (graphToDot, quickParams)
import Data.GraphViz.Types (printDotGraph)
import Data.Maybe (listToMaybe)
import qualified Data.Text.Lazy as Text
import Parser (parse)
import System.Environment (getArgs)
import Tree
import Types

main :: IO ()
main = do
  parsedTrees <- fmap parse . listToMaybe <$> getArgs
  case parsedTrees of
    Nothing           -> putStrLn "Expected 1 argument: the string to parse"
    Just (Left err)   -> prettyPrintError err
    Just (Right tree) -> writeTreeToDot tree

prettyPrintError :: ParsingError -> IO ()
prettyPrintError (ErrorAtPos pos desc) = putStrLn $
  "Parse error at pos " ++ show pos ++ ": " ++ desc

writeTreeToDot :: Tree String -> IO ()
writeTreeToDot tree = let
  graph = treeToGraph tree Nothing (empty :: Gr String String)
  dot = graphToDot quickParams graph
  in writeFile "tree.dot" (Text.unpack $ printDotGraph dot)

treeToGraph :: (DynGraph gr) => Tree String -> Maybe Node -> gr String String -> gr String String
treeToGraph (Tree name children) parent graph = let
  node = order graph
  insertEdge = case parent of
    Nothing -> id
    Just p  -> insEdge (p, node, "")
  graphWithNode = (insertEdge . insNode (node, name)) graph
  in foldl' (\g child -> treeToGraph child (Just node) g) graphWithNode children
