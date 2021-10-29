import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class StudentTest {

    BiPredicate<Integer,Integer> lessEq = (Integer x, Integer y) -> x <= y;

    //returns a heap with an initialized child array
    private BinomialHeap<Integer> genHeap(int rootVal, int[] childrenRootVals){
        BinomialHeap<Integer> H = new BinomialHeap<>(rootVal, 0, null, lessEq);

        PList<BinomialHeap<Integer>> headHeap = null;
        for (int val : childrenRootVals) {
            BinomialHeap<Integer> newHeap = new BinomialHeap<>(val, 0, null, lessEq);
            headHeap = PList.addFront(newHeap, headHeap);
        }
        H.children = headHeap;
        return H;
    }

    @Test
    public void test() throws Exception {
        pushOne();
        pushFour();
        extractMinOne();
        extractMinThree();
        isHeapEmpty();
        smallMerge();
        testQueue();
        isHeap();
        heightTest();
        randomQueue();
        randomMerge();
        linkDiffHeights();
    }

    @Test
    public void pushOne() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>(lessEq);
        H.push(1);
        assertTrue(H.isHeap());
        assertTrue(PList.getFirst(H.forest).height == 0);

    }

    @Test
    public void pushFour() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>(lessEq);
        H.push(1);
        H.push(2);
        H.push(3);
        H.push(4);
        assertTrue(H.isHeap());
        assertTrue(PList.getFirst(H.forest).height == 2);
        assertEquals(4, H.forest.data.key);
    }

    @Test
    public void extractMinOne() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>(lessEq);
        H.push(1);
        assertEquals(H.pop(), new Integer(1));
    }

    @Test
    public void extractMinThree() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>(lessEq);
        H.push(1);
        H.push(2);
        H.push(3);
        assertEquals(3, H.pop().intValue());
        assertEquals(2, H.pop().intValue());
        assertEquals(1, H.pop().intValue());
    }

    @Test
    public void isHeapEmpty() throws Exception {
        BinomialQueue<Integer> H = new BinomialQueue<>(lessEq);
        assertTrue(H.isHeap());
        assertTrue(H.isEmpty());
    }

    @Test
    public void smallMerge() throws Exception {
        BinomialQueue<Integer> H0 = new BinomialQueue<>(lessEq),
                H1 = new BinomialQueue<>(lessEq);

        H0.push(1);
        H1.push(2);

        BinomialQueue<Integer> H2 = new BinomialQueue<>(lessEq);

        H2.forest = H2.merge(H0.forest, H1.forest);

        assertTrue(H2.isHeap());
        assertEquals(2, H2.pop().intValue());
        assertEquals(1, H2.pop().intValue());

        H0.push(1);
        H0.push(2);

        H1.push(1);
        H1.push(2);

        H2.forest = H2.merge(H0.forest, H1.forest);
        assertEquals(1, H2.forest.data.height);
        H2.push(10);
        assertEquals(0, H2.forest.data.height);
    }

    //this does not pass any test cases
    @Test
    public void isHeap() throws Exception{
        BinomialHeap<Integer> Heap1 = new BinomialHeap<>(10, 0, null, lessEq);//key: 10, height 0
        assertTrue(Heap1.isHeap());
        BinomialHeap<Integer> Heap2 = new  BinomialHeap<>(5, 0, null, lessEq);
        BinomialHeap<Integer> Heap3 = Heap1.link(Heap2);
        assertTrue(Heap3.isHeap());
        BinomialHeap<Integer> Heap4 = new BinomialHeap<>(15, 0, null, lessEq);
        BinomialHeap<Integer> Heap5 = new BinomialHeap<>(3, 0, null, lessEq);
        BinomialHeap<Integer> Heap6 = Heap4.link(Heap5);
        Heap3 = Heap3.link(Heap6);
        assertTrue(Heap3.isHeap());


        //key: 10, height 0
        BinomialHeap<Integer> Heap8 = new  BinomialHeap<>(15, 0, null, lessEq);
        PList<BinomialHeap<Integer>> Heap9 = new PList<>(Heap8, null);
        BinomialHeap<Integer> Heap7= new BinomialHeap<>(10, 0, Heap9, lessEq);
        assertFalse(Heap7.isHeap());
    }

    //test insert on null binomial heap
    @Test
    public void testQueue() throws Exception{
//        BinomialQueue<Integer> J = new BinomialQueue<>(lessEq);
//        BinomialHeap<Integer> heap1 = new BinomialHeap<>(10, 0, null, lessEq);
//        J.forest = BinomialQueue.insert(heap1, J);
        BinomialQueue<Integer> H4 = new BinomialQueue<>(lessEq),
                H5 = new BinomialQueue<>(lessEq);
        assertTrue(H5.isEmpty());
        assertTrue(H4.isEmpty());
        H4.push(1);
        H4.push(5);
        H4.push(10);
        H4.push(6);
        assertEquals(new Integer(2), H4.forest.data.height);
        //H5.push(2);

        H5.push(3);

        BinomialQueue<Integer> H6 = new BinomialQueue<>(lessEq);
        H6.forest = H6.merge(H4.forest, H5.forest);

        assertTrue(H6.isHeap());
        assertEquals(10, H6.pop().intValue());
        assertEquals(6, H6.pop().intValue());
        assertEquals(new Integer(0), H6.forest.data.height);
        assertFalse(H6.isEmpty());
        H6.push(100);
        assertEquals(new Integer(2), H6.forest.data.height);
        assertEquals(new Integer(100), H6.pop().intValue());
        assertEquals(5, H6.pop().intValue());
        assertEquals(3, H6.pop().intValue());
        assertEquals(1, H6.pop().intValue());
        assertThrows(Exception.class, () -> {H6.pop().intValue();});
        //assertEquals(1, H6.pop().intValue());
    }

    @Test
    public void heightTest() throws Exception{
        BinomialQueue<Integer> resultQueue = new BinomialQueue<>(lessEq);
        BinomialQueue<Integer> queue1 = new BinomialQueue<>(lessEq); //height1
        queue1.push(10);
        queue1.push(15);

        BinomialQueue<Integer> queue2 = new BinomialQueue<>(lessEq);//height 2
        queue2.push(11);
        queue2.push(13);
        queue2.push(1);
        queue2.push(14);
        queue2.toString();

        BinomialQueue<Integer> queue3 = new BinomialQueue<>(lessEq);//height 3
        queue3.push(1);
        queue3.push(2);
        queue3.push(3);
        queue3.push(4);
        queue3.push(5);
        queue3.push(6);
        queue3.push(7);
        queue3.push(8);

        resultQueue.forest = resultQueue.insert(queue3.forest.data, queue1.forest);
        //resultQueue.forest = resultQueue.insert(queue2.forest.data, queue1.forest);
        PList<BinomialHeap<Integer>> list = resultQueue.forest;
        while(list!=null && list.next!=null){
            assertTrue(list.data.height < list.next.data.height);
            list = list.next;
        }

        resultQueue.forest = resultQueue.insert(queue2.forest.data,resultQueue.forest);
        while(list!=null && list.next!=null){
            assertTrue(list.data.height < list.next.data.height);
            list = list.next;
        }
        assertEquals(1, resultQueue.forest.data.height);
        assertEquals(2, resultQueue.forest.next.data.height);
        assertEquals(3, resultQueue.forest.next.next.data.height);

    }

    //use random java class and generate random numbers and push into the queue
    //start popping, stick into an array and sort it
    @Test
    public void randomQueue() throws Exception{
        int random;
        int n =30;
        int checkarr[] = new int[n];
        BinomialQueue<Integer> Q = new BinomialQueue<>(lessEq);
        for(int i=0; i<n; ++i){
            random = (int) (Math.random()*100);
            checkarr[i]=random;
            Q.push(random);
        }
        Arrays.sort(checkarr);
        for(int i=n-1; i==0; --i){
            assertEquals(checkarr[i],Q.pop().intValue());
        }
    }

    @Test
    public void randomMerge() throws Exception{
        int random;
        int n1=30;
        int n2=10;
        int arr[] = new int[n1+n2];
        BinomialQueue<Integer> Q1 = new BinomialQueue<>(lessEq);
        BinomialQueue<Integer> Q2 = new BinomialQueue<>(lessEq);
        BinomialQueue<Integer> Q3 = new BinomialQueue<>(lessEq);
        for(int i=0; i<n1; ++i){
            random = (int) (Math.random()*100);
            arr[i]=random;
            Q1.push(random);
        }
        for(int i=0; i<n2; ++i){
            random = (int) (Math.random()*100);
            arr[i+n1]=random;
            Q2.push(random);
        }
        Arrays.sort(arr);
        Q3.forest = Q3.merge(Q1.forest, Q2.forest);
        for(int i=n1+n2-1; i==0; --i){
            assertEquals(arr[i],Q3.pop().intValue());
        }
    }

    @Test
    public void linkDiffHeights() throws Exception{
        BinomialHeap<Integer> Heap1 = new BinomialHeap<>(10, 0, null, lessEq);//key: 10, height 0
        BinomialHeap<Integer> Heap2 = new  BinomialHeap<>(5, 0, null, lessEq);
        BinomialHeap<Integer> Heap3 = Heap1.link(Heap2);
        BinomialHeap<Integer> Heap4 = new BinomialHeap<>(1, 0, null, lessEq);

        assertThrows(Exception.class, () -> {Heap4.link(Heap3);});
    }
}
