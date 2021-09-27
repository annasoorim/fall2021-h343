import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;
import java.util.function.BiPredicate;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> T;
    HashSet<Integer> H;
    int[] A = { 5, 2, 4, 1, 5, 9, 8 }, A_sorted = { 1, 2, 4, 5, 8, 9 };
    BiPredicate<Integer,Integer> pred = (Integer x, Integer y) -> x.compareTo(y) < 0;

    @BeforeEach
    public void setUp() throws Exception {
        T = new BinarySearchTree<>(pred);
        H = new HashSet<Integer>();
    }

    @Test
    public void find() throws Exception {
        for (int i = 0; i != A.length; ++i) {
            T.insert(A[i]);
            H.add(A[i]);
        }
        for (Integer k : H) assertTrue(T.contains(k));
        for (int k : A_sorted) assertTrue(T.contains(k));
    }

    @Test
    public void isAVL() throws Exception {
        BinarySearchTree<Integer> T = new BinarySearchTree<>(pred);
        assertTrue(T.isAVL());
        T.insert(53);
        assertTrue(T.isAVL());
        T.insert(42);
        assertTrue(T.isAVL());
        T.insert(21);
        assertFalse(T.isAVL());
    }

}
