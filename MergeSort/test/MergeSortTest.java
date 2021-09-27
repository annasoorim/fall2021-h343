import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeSortTest {

    @Test
    public void twoMergeSortArray() {
        int n = 2;
        Integer[] A_orig = {42, 41};
        Integer[] A_sorted = A_orig.clone();
        Arrays.sort(A_sorted);
        Integer[] A = A_orig.clone();
        ArrayIterator<Integer> begin = new ArrayIterator<>(A, 0);
        ArrayIterator<Integer> end = new ArrayIterator<>(A, A.length);
        MergeSort.sort(begin, end);
        assertTrue(Arrays.equals(A_sorted, A));
    }

}
