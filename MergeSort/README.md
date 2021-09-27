
Implement the Merge Sort algorithm using the `Iterator` and
`Comparable` interfaces.  That is, define a public `MergeSort` class
in `MergeSort.java` with the following method:

    public static <E extends Comparable<? super E>>
    void sort(Iterator<E> begin, Iterator<E> end);

The `begin` and `end` iterators represent the half-open range
`[begin,end)` of a sequence. After the call to `sort`, the range
`[begin,end)` should contain the same elements as before, but sorted
from low to high according to the `Comparable` ordering.
The iterators `begin` and `end` should not be mutated, but of course
you can clone them and mutate the clones.

The Merge Sort algorithm relies on the Merge algorithm, which you should
implement with the following method:

    public static <E extends Comparable<? super E>>
    Iterator<E> merge(Iterator<E> begin1, Iterator<E> end1,
	                  Iterator<E> begin2, Iterator<E> end2,
	                  Iterator<E> result);

Prior to the call to `merge`, the input ranges `[begin1,end1)` and
`[begin2,end2)` must be sorted.  Let n be the number of elements in
the first range and m be the number of elements in the second range.
The elements from both ranges are written to the range
`[result,result.advance(n+m))` in such a way that the result is in
sorted order.  Returns an iterator for the position
`result.advance(n+m)`.  All of the iterator parameters (`begin1`,
`end1`, etc.) should not be mutated, but of course you can clone them
and mutate the clones.

The following auxiliary methods may be helpful.

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
