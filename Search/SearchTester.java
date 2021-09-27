public class SearchTester {
    public static void main(String[] args) {
        Search tester= new Search();
        boolean[] A = new boolean[]{false, false, false, true, false};
        int result = tester.find_first_true(A, 0, 4);
        System.out.println(result);
        int[] B = new int[]{32, 11, 4, 5, 99, 5, 32, 75};
        int resultTwo = tester.find_first_equal(B, 0);
        System.out.println(resultTwo);
        boolean[] C= new boolean[]{false, false, false, false, true, true, true};
        int resultThree = tester.find_first_true_sorted(C, 4, C.length);
        System.out.println(resultThree);
    }
}

