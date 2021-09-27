import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTest {

    @Test
    public void bstTest() {
        /*BinaryNode<Integer> rootNode = new BinaryNode<Integer>(8, new BinaryNode<>(3, null, null), new BinaryNode<Integer>(10, null, null));
        rootNode.left.left = new BinaryNode<Integer>(1, null, null);
        rootNode.left.right = new BinaryNode<Integer>(6, new BinaryNode<Integer>(4,null,null), new BinaryNode<Integer>(7, null, null));
        rootNode.right.right= new BinaryNode<Integer>(14, new BinaryNode<Integer>(13, null,null), null);
*/
        BinaryNode<Integer> root = new BinaryNode<>(10, new BinaryNode<>(5, new BinaryNode<>(2, null, null),new BinaryNode<>(7, null, null)), new BinaryNode<>(14, null, null));

        BinaryTree<Integer> bob = new BinaryTree<>(root);
        ArrayList<Integer> out = new ArrayList<Integer>();
        bob.preorder(out);
        ArrayList<Integer> shouldEqual = new ArrayList<Integer>();
        shouldEqual.add(10);
        shouldEqual.add(5);
        shouldEqual.add(2);
        shouldEqual.add(7);
        shouldEqual.add(14);

        //assertTrue(ArrayList.equals(out, shouldEqual));
        //assertTrue(Arrays.equals(A_sorted, A));
    }

}
