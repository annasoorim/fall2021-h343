import java.util.ArrayList;
import java.util.function.Predicate;

public class MergeSort{

    /*
      Returns the number of elements in the half-open range [begin, end).
      Time complexity: O(n)
     */
    public static <E>
    int distance(Iterator<E> begin, Iterator<E> end) {
        int n = 0;
        for (Iterator<E> i = begin.clone(); !i.equals(end); i.advance()) {
            ++n;
        }
        return n;
    }

    /*
     Copies the elements in the range [begin,end) into the range [result, result.advance(n))
     where n = distance(begin, end).
     Returns an iterator for the position result.advance(n).
     Time complexity: O(n)
     */
    public static <E>
    Iterator<E> copy(Iterator<E> begin, Iterator<E> end, Iterator<E> result) {
        Iterator<E> out = result.clone();
        for (Iterator<E> i = begin.clone(); !i.equals(end); i.advance()) {
            out.set(i.get());
            out.advance();
        }
        return out;
    }

    /*
      Create an array of the specified size, with all the elements initialized to `null`.
     */
    public static <E>
    ArrayList<E> make_array(int size) {
        ArrayList<E> array = new ArrayList<>(size);
        for (int i = 0; i != size; ++i) {
            array.add(null);
        }
        return array;
    }
    /*
     Precondition: the input ranges [begin1,end1) and [begin2,end2) are sorted.
     Let n be the number of elements in the first range and m be the number of 
     elements in the second range.
     The elements from both ranges are written to the range [result, result.advance(n+m)) 
     in such a way that the result is in sorted order according to `Comparable`.
     Returns an iterator for the position result.advance(n+m).
     */
    public static <E extends Comparable<? super E>>
    Iterator<E> merge(Iterator<E> begin1, Iterator<E> end1,
                      Iterator<E> begin2, Iterator<E> end2,
                      Iterator<E> result) {
        // TODO
        //begin1 TO end1
        //begin2 TO end2    STOPS BEFORE IT REACHES END1 AND END2
        Iterator<E> left = begin1.clone(), right = begin2.clone();
        Iterator returnResult = result.clone();
        while (!left.equals(end1) && !right.equals(end2)) {
            if (left.get().compareTo(right.get()) <= 0) {
                //negative means left is less than right
                returnResult.set(left.get());
                //System.out.println(left.get());
                left.advance();
            } else {
                returnResult.set(right.get());
                //System.out.println(right.get());
                right.advance();
            }
            returnResult.advance();
        }
        //copying any leftover elements from either the left or right side
        while(!left.equals(end1)){
            returnResult.set(left.get());
            //System.out.println("leftover left" + left.get());
            left.advance();
            returnResult.advance();
        }
        while(!right.equals(end2)){
            returnResult.set(right.get());
            //System.out.println("leftover right" + right.get());
            right.advance();
            returnResult.advance();
        }
        //System.out.println()
        return returnResult;
        /*
        have an iterator begin1 and iterator begin2 that you clone;
        compare begin1 to begin2
        if begin1 is smaller, result.set(begin1)
        begin1.advance
        compare again until lists are done
        */
    }
    /*
    The `begin` and `end` iterators represent the half-open range
    `[begin,end)` of a sequence. After the call to `sort`, the range
    `[begin,end)` contains the same elements as before, but sorted
    from low to high according to the `Comparable` ordering.
     */
    public static <E extends Comparable<? super E>>
    void sort(Iterator<E> begin, Iterator<E> end) {
        // TODO
        int length = distance(begin, end);
        //Iterator<E> rand = begin.clone();
        ArrayList<E> arrayResult = make_array(length);
        ArrayListIterator<E> result = new ArrayListIterator<E>(arrayResult, 0);
        if(length>1){
            Iterator<E> begin1 = begin.clone();
            Iterator<E> end1 = begin.clone();
            Iterator<E> begin2 = begin.clone();
            Iterator<E> end2 = end.clone();
            int middle = length/2;
            end1.advance(middle);
            begin2.advance(middle);
            sort(begin1, end1);
            sort(begin2, end2);
            Iterator<E> endResult = merge(begin1, end1, begin2, end2, result);
            copy(result, endResult, begin);
        }
        //copy the array

        /*System.out.println("1: " + begin.toString() + "\t\t2: " + end.toString());
        Iterator<E> begin1= begin.clone();
        Iterator<E> end2= end.clone();
        int d = distance(begin, end);
        ArrayList<E> arrayRand = make_array(d);
        ArrayListIterator<E> result = new ArrayListIterator<E>(arrayRand, 0);
        if(d>1){ //if it's length 1, it's already sorted
            //find middle
            Iterator<E> end1 = begin.clone();
            Iterator<E> begin2 = begin.clone();
            int middle=distance(begin1, end2)/2;
            end1.advance(middle);
            begin2.advance(middle+1);
            //System.out.println("Distance: "+ d + "  Middle: " + middle + " Iterator begin1 end1 " + begin1 + " "+ end1 +"\nIterator begin2 end2 "+ begin2 + " " + end2);
            sort(begin1, end1);
            System.out.println("finished sort 1");
            //System.out.println(begin2);
            sort(begin2, end2);
            System.out.println("Finished sort 2");
            merge(begin1, end1, begin2, end2, result);
            System.out.println("finished merge");
        }*/
        //calculate the middle and then set
        /*
        check if the length is 1; return original array
        Make it recursive
        Base case, there's only one element; merge the two sides
         */
        //how do iterators at the end work?
        /*
        for(int i=0; i<d; ++i){
            System.out.println(begin.get());
            begin.advance();
        }*/
    }
}
