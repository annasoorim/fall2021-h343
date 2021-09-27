import java.util.Arrays;


public class Tester {

    public static void main(String[] args) {
        int n = 2;
        Integer[] A_orig = {39, 41, 43, 50};
        Integer[] A_sorted = A_orig.clone();
        Arrays.sort(A_sorted);
        Integer[] A = A_orig.clone();
        ArrayIterator<Integer> begin = new ArrayIterator<>(A, 0); //Iterator(0) = 42
        ArrayIterator<Integer> end = new ArrayIterator<>(A, A.length); //Iterator(2) = 41
        Integer[] B_orig = {39};
        Integer[] B = B_orig.clone();
        ArrayIterator<Integer> begin1 = new ArrayIterator<>(B, 0); //Iterator(0) = 42
        ArrayIterator<Integer> end1 = new ArrayIterator<>(B, B.length); //Iterator(2) = 41
        Integer[] array = {null, null, null, null, null, null};
        //ArrayIterator<Integer> result = new ArrayIterator<Integer>(array, 0);
        //MergeSort.merge(begin, end, begin1, end1, result);
//        System.out.println(result.get());
//        result.advance();
//        System.out.println(result.get());
//        result.advance();
//        System.out.println(result.get());
//        result.advance();
//        System.out.println(result.get());
//        result.advance();
//        System.out.println(result.get());
//        result.advance();
//        System.out.println(result.get());
//        result.advance();
        //System.out.println(begin + " " + begin.get());
        //System.out.println(end);
        MergeSort.sort(begin, end);

    }
}
