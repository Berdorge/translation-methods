module Tree
  ( Tree (..)

  , treeLeaf
  ) where

data Tree a = Tree {
  treeNode     :: a,
  treeChildren :: [Tree a]
} deriving (Eq, Show)

treeLeaf :: a -> Tree a
treeLeaf a = Tree a []
