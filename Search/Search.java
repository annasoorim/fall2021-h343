public class Search {
    public static int find_first_true(boolean[] A, int begin, int end) {
        for (int index = begin; index < end; index++) {
            //System.out.println(A[index]);
            if (A[index] == true) {
                return index;
            }
        }
        return end;
    }
    /*    public static int find_first_true(boolean[] A, int begin, int end) {
        int index=begin;
        for (; index < end && A[index]==false; index++) {
            //System.out.println(A[index]);
        }
        return index;
    }*/

    public static int find_first_equal(int[] A, int x) {
        boolean[] ABool = new boolean[A.length];
        for (int index = 0; index < A.length; index++) {
            if (A[index] == x) {
                ABool[index] = true;
            } else {
                ABool[index] = false;
            }
        }
        int returnIndex = find_first_true(ABool, 0, ABool.length);
        return returnIndex;
    }

    public static int find_first_true_sorted(boolean[] A, int begin, int end) {
        int middle = (begin + end) / 2;
        if (begin == end) {
            return middle;
        }
        else {
            if (A[middle] == false) {
                begin = middle + 1;
                return find_first_true_sorted(A, begin, end);
            } else if (A[middle] == true) {
                end = middle;
                return find_first_true_sorted(A, begin, end);
            }
        }
        return middle;
    }
}


        //int index = 0;
//        while(middle<end && middle>=begin) {
//            if (A[middle] == false) {
//                if(A.length == 1){
//                    return middle+ 1;
//                }
//                begin=middle+1;
//                middle=(begin+end)/2;
//            }
//            else if (A[middle] == true) {
//                if(A.length>1 && A[middle-1]==false){
//                    return middle;
//                }
//                if(A.length==1){
//                    return middle;
//                }
//                end=middle;
//                middle=(begin+end)/2;
//            }
//        }
//        return middle;


