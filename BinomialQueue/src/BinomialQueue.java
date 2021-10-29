import java.util.function.BiPredicate;

class BinomialHeap<K> {
    K key;
    int height;
    PList<BinomialHeap<K>> children;
    BiPredicate<K, K> lessEq;

    BinomialHeap(K k, int h, PList<BinomialHeap<K>> kids, BiPredicate<K, K> le) {
        this.key = k;
        this.height = h;
        this.children = kids;
        this.lessEq = le;
    }

    /*
     * @precondition this.height == other.height
     */
    BinomialHeap<K> link(BinomialHeap<K> other) {
        if (this.height != other.height)
            throw new UnsupportedOperationException("attempt to link trees of different height");
        if (lessEq.test(other.key, this.key)) {
            PList<BinomialHeap<K>> kids = PList.addFront(other, this.children);
            return new BinomialHeap<>(this.key, this.height + 1, kids, lessEq);
        } else {
            PList<BinomialHeap<K>> kids = PList.addFront(this, other.children);
            return new BinomialHeap<>(other.key, other.height + 1, kids, lessEq);
        }
    }

    /**
     * TODO
     * <p>
     * The isHeap method checks whether or not the subtree of this node
     * satisfies the heap property.
     */
    boolean isHeap() {
        //if children are null, return true
        if(this.children==null){ //no kids means it's a leaf which is trivially true
            return true;
        }
        //clone the children
        PList<BinomialHeap<K>> children = this.children;
        //while loop, it's not null, call is heap on hte children and make sure that the data is larger than the findmax of the children
        while(children!=null){
            if(PList.getFirst(children).isHeap() && lessEq.test(PList.getFirst(children).key, this.key)){
                children = PList.getNext(children);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String ret = "(" + key.toString();
        if (children != null)
            ret = ret + " " + children.toString();
        return ret + ")";
    }
}

public class BinomialQueue<K> {
    PList<BinomialHeap<K>> forest;
    BiPredicate<K, K> lessEq;

    public BinomialQueue(BiPredicate<K, K> le) {
        forest = null;
        lessEq = le;
    }

    public void push(K key) {
        BinomialHeap<K> heap = new BinomialHeap<>(key, 0, null, lessEq);
        this.forest = insert(heap, this.forest);
    }

    public K pop() {
        BinomialHeap<K> max = PList.find_max(this.forest, (h1,h2) -> this.lessEq.test(h1.key, h2.key));
        this.forest = PList.remove(max, this.forest);
        PList<BinomialHeap<K>> kids = PList.reverse(max.children, null);
        this.forest = merge(this.forest, kids);
        return max.key;
    }

    public boolean isEmpty() {
        return forest == null;
    }

    /**
     * The isHeap method returns whether or not the Binomial Queue (a forest of Binomial Trees)
     * satisfies the heap property.
     */
    public boolean isHeap() {
        //go through the forest, check to make sure each heap is a heap
        //copy the forest, and do current= forest.getNext();
        PList<BinomialHeap<K>> current = this.forest;
        while(current!=null) {
            if (!current.data.isHeap()) {
                return false;
            } else {
                current = current.next;
            }
        }
        return true;
    }

    public String toString() {
        if (this.forest == null)
            return "";
        else
            return this.forest.toString();
    }

    /**********************************
     * Helper functions
     */
//    static <K> void merge(PList<BinomialHeap<K>> bob){
//
//    }

    /**
     * TODO
     * The insert method is analogous to binary addition. That is,
     * it inserts the node n into the list ns to produce a new list
     * that is still sorted by height.
     *
     * @param n   The node to insert.
     * @param ns  The binomial forest into which to insert, ordered by height.
     * @param <K> The type of the keys.
     * @return A new binomial forest that includes the new node.
     */
    static <K> PList<BinomialHeap<K>>
    insert(BinomialHeap<K> n, PList<BinomialHeap<K>> ns) {
        if (ns == null) {
            return PList.addFront(n, ns);
        } else {
            if (n.height < ns.data.height) {
                return PList.addFront(n, ns);
            } else if (n.height == ns.data.height) {
                return insert(n.link(ns.data), ns.next);
            } else {
                return PList.addFront(ns.data, insert(n, ns.next));
            }
        }
    }
//        if(n.height < copyForest.data.height){
//            return PList.addFront(n, copyForest);
//        }
//        else if(copyForest.data.height == n.height){
//            //merge() ? or link()?
//        }
//            PList<BinomialHeap<K>> storeList = new PList<BinomialHeap<K>>(current.data, null);
//            PList<BinomialHeap<K>> outList = new PList<>(null, null);
//            while(current!=null) {
//                if(n.height< current.data.height){
//                    PList.addFront(n, current);
//                    break; //added so you can break out of the loop
//                }
//                if(n.height > current.data.height) {
//                    storeList.addFront(current.data, storeList);
//                    current = current.next;
//                }
//                else if (n.height == current.data.height) {
//                    //link method?
//                    current.data = current.data.link(n);
//                    n = current.data; //resetting n so that it keeps checking to make sure there are no more duplicates
//                    current = current.next;
//                }
//            }
//            PList.reverse(storeList, outList);
            //merge the two lists
        //go through each height of binomial heap in forest, is n's height < than first, can just add
        //if n's height== link:
        //if n's height> ns; can do iterative or recursively: store what you've traversed and then reverse i

    /**
     * TODO
     * The merge method is analogous to the merge part of merge sort. That is,
     * it takes two lists that are sorted (by height) and returns a new list that
     * contains the elements of both lists, and the new list is sorted by height.
     *
     * @param ns1
     * @param ns2
     * @return A list that is sorted and contains all and only the elements in ns1 and ns2.
     */
    static <K> PList<BinomialHeap<K>>
    merge(PList<BinomialHeap<K>> ns1, PList<BinomialHeap<K>> ns2) {
        //loop through ns2 and insert each binomial heap into ns1
        while(ns2!=null){
            ns1= insert(ns2.data, ns1);
            ns2 = ns2.next;
        }
        return ns1;
    }
    
}

