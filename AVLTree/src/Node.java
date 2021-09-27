import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Math.abs;

import java.util.function.BiPredicate;

public class Node<T> {
    public T data;
    public Node<T> left, right;
    public int height;

    public Node(T k, Node<T> l, Node<T> r) {
        data = k;
        left = l;
        right = r;
        height = 0; //default height of all leaves are 0
    }

    // Returns the height of node n.
    protected static <T> int get_height(Node<T> n) {
        if (n == null) return -1;
        else return n.height;
    }

    //update height class, children already have a height, get the height of the two children and getMax and add i
    public void updateHeight(Node<T> n){
        n.height= max(get_height(n.left), get_height(n.right))+1;
    }

    // Inserts k into the subtree of this node if there is not already
    // a node whose data equals k.
    // Maintains the Binary Search Tree property.
    // Returns true is k was inserted (and not already in the subtree)
    // and returns false otherwise.
    public boolean insert(T k, BiPredicate<T, T> lessThan) {
        boolean inserted;
        if (lessThan.test(k, data)) {
            if (left == null) {
                left = new Node<T>(k, null, null);
                updateHeight(this);
                inserted = true;
            }
            else {
                inserted = left.insert(k, lessThan);
                updateHeight(this);
            }
        } else if (lessThan.test(data, k)) {
            if (right == null) {
                right = new Node<T>(k, null, null);
                updateHeight(this);
                inserted = true;
            }
            else {
                inserted = right.insert(k, lessThan);
                updateHeight(this);
            }
        } else {
            // k is already in the tree, so no need to insert.
            inserted = false;
        }
        return inserted;
    }

    // Is the subtree of this node an AVL tree?
    public boolean isAVL() {
	//student implements
        //check the height of the left subtree and right subtree; if the difference is greater than 1, it is NOT an AVL
        if(data==null){
            return true;
        }
        else {
            int heightLeft = get_height(left);
            int heightRight = get_height(right);
            if (Math.abs(heightLeft - heightRight) <= 1) {
                return true;
            } else
                return false;
        }
    }

    public String toString() {
        return String.format("(%s %s [%d] %s)",
                left == null ? "" : left.toString(),
                data.toString(),
                height,
                right == null ? "" : right.toString());
    }
}
