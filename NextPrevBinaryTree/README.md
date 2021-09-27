# Lab: Binary Trees with Inorder Iterators

This lab is a stepping stone for the Segment Intersection Project.

The lab is to finish a `BinaryTree` class that implements the
`Sequence` and `ReverseSequence`
interfaces. These interfaces are defined in terms of iterators, `Iterator`
and `ReverseIterator`. Traversing according to the `Sequence`
should provide an *inorder* traversal. Traversing according to the
`ReverseSequence` should provide a backwards inorder traversal.

The first step is to implement `next` and `previous` methods in the
`BinaryNode` class.  We recommend that you start by implementing the
following helper functions in the `BinaryNode` class, which come in
handy when trying to move forwards or backwards within the binary
tree.

    public BinaryNode<T> first();

Returns the first node in the current subtree according to an inorder traversal.
        
    public BinaryNode<T> last();

Returns the last node in the current subtree according to an inorder traversal.

    public BinaryNode<T> nextAncestor();

Returns the first ancestor that is next with respect to an inorder traversal
or null if there is none. We recommend that you use the `parent` field that has
been added to the `BinaryNode` class for this purpose.

    public BinaryNode<T> prevAncestor();

Returns the first ancestor that is previous with respect to
and inorder traversal or null if there is none. Again, you'll need
to use the `parent` field to walk up the tree.

Once the above helper functions are complete, it is straightforward to
implement methods that return the next and previous nodes according
to an inorder traversal.

    public BinaryNode<T> next();
    public BinaryNode<T> previous();

The idea for `next()` is that if the current node has a right child, then
the `first()` of that child's subtree is the next node.
If the current node does not have a right child (if it is null),
then the next node is it's `nextAncestor()`.

The idea for `previous()` is the mirror image of the idea for `next()`.

You can now move on to finish the implementation of the `BinIter` class
by filling in the `get`, `retreat`, `advance`, `equals`, and `clone` methods.
These methods are 1-liners.

Test your work by creating a `StudentTest.java` file with one method
named `test`.

    @Test
    public void test() throws Exception {
        ...
    }

This method should thoroughly test the `BinaryTree` class.  The
autograder will apply your tests to buggy implementations of the
`BinaryTree` class. You receive 1 point for each bug detected.  The
autograder will also apply your tests to a correct implementation of
the `BinaryTree` class to ensure that your tests do not signal errors
when then should not.


## Submission

Submit your `BinaryTree.java` and `StudentaTest.java` files to
the NextPrevBinaryTree project on the autograder:

[https://autograder.sice.indiana.edu/web/project/329](https://autograder.sice.indiana.edu/web/project/329)
