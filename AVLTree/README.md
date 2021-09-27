# Assignment: BSTs with Height + isAVL

This assignment is a stepping stone towards implementing balanced
binary trees using the AVL approach.

Change the class `BinarySearchTree` to add the following two methods.

    int height();
    boolean isAVL();
    
The `height` method should return the height of the tree (that is, that
length of the longest path from the root to a leaf node).
The `height` method must have O(1) time complexity. This can be accomplished
by adding a field named `height` to the `Node` class that stores the height
of the node. For testing purposes, we need this `height` field to be public.
See the textbook for the definition of the height on a node in a tree
and note that a leaf node has height $0$.
You will need to modify other methods to update the `height` field
when the tree changes.

The `isAVL` method should return true or false depending on whether
the tree is an AVL tree. 
The `isAVL` method should have O(n) time complexity.

## Testing

Write three JUnit tests for each of `height` and `isAVL` and put them
in `BinarySearchTreeTest.java`.

## Submission

Submit your `BinarySearchTree.java` and `BinarySearchTreeTest.java`
files to the autograder, project `AVLTreePreLec`:

[https://autograder.sice.indiana.edu/web/project/70](https://autograder.sice.indiana.edu/web/project/70)