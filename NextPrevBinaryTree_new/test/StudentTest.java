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

        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        BinaryTree.Node leftleft = tree.new Node(6, null, null, null);
        BinaryTree.Node leftright = tree.new Node(13, null, null, null);
        BinaryTree.Node left = tree.new Node(10, leftleft,  leftright, null);
        leftleft.parent = left;
        leftright.parent = left;
        BinaryTree.Node right = tree.new Node(20, null, null, null);
        BinaryTree.Node root = tree.new Node(15, left, right, null);
        //                      15
        //                      /\
        //                  10      20
        //                  /\      /\
        //                6   13

        //assertEquals(10,b.left);
        left.parent = root;
        right.parent = root;
        assertEquals(20, (int)root.right.data);
        //assertEquals(10, root.parent);
        //checking FIRST()
        assertEquals((int)root.first().data, (int)leftleft.data);

        //checking LAST()
        assertEquals((int)root.last().data, 20);

        //checking NEXTANCESTOR()
        assertEquals((int)leftright.nextAncestor().data, 15);

        //checking LASTANCERSTOR()
        assertEquals((int)leftright.prevAncestor().data, 10);

        //checking NEXT()
        assertEquals((int)leftleft.next().data,10);
        assertEquals(leftleft.previous(),null);

        assertEquals((int)left.next().data,13);
        assertEquals((int)left.previous().data,6);




        assertEquals(right.next(), null);
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
