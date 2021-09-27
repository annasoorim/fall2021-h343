import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class StudentTest {

    @Test
    public void test() throws Exception {
	// student implements
        //create a BST
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(1);
        list.add(5);
        list.add(7);

        BinaryTree<Integer> tree = new BinaryTree<Integer>(list);
        BinaryTree.Node a = tree.new Node(10, null, null, null);
        BinaryTree.Node b = tree.new Node(15, null, null, null);

        a.parent = b;

        assertEquals(b.first().data, 10);





        //test each branch in the BST
        //test out the functions that I wrote

        //test out empty tree
        //BinaryTree<Integer> emptyTree = new BinaryTree<Integer>();
        //ArrayList<Integer> emptyList = new ArrayList<>();
        //Node bob = new Node(null, null, null, null);
        //assertEquals((emptyTree, emptyList);
        //test small tree

        //test bigger tree
    }

}
