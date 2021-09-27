import java.util.HashSet;
import java.util.function.BiPredicate;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> T;
        //HashSet<Integer> H;
        int[] A = {5, 2, 4, 1, 5, 9, 8}, A_sorted = {1, 2, 4, 5, 8, 9};
        BiPredicate<Integer, Integer> pred = (Integer x, Integer y) -> x.compareTo(y) < 0;
        T = new BinarySearchTree<>(pred);
        //H = new HashSet<Integer>();

        for (int i = 0; i != A.length; ++i) {
            T.insert(A[i]);
            System.out.println(T.toString());
            //H.add(A[i])
        }
        T.remove(A[A.length-1]);
        T.remove(A[3]);
        //T.remove(A[2]);
        System.out.println(T.toString());
        //System.out.println(T.toString());
        //System.out.println(T.root.height);
        System.out.println(T.height());

        //test out building tree with in_order


    }
}
