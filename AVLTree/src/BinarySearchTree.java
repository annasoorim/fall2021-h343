import java.util.ArrayList;
import java.util.function.BiPredicate;

public class BinarySearchTree<T> {
    protected Node<T> root;
    protected int numNodes;
    protected BiPredicate<T, T> lessThan;

    public BinarySearchTree(BiPredicate<T, T> lt) {
        root = null;
        numNodes = 0;
        lessThan = lt;
    }

    public BinarySearchTree(ArrayList<T> L) {
        root = build_inorder(L, 0, L.size());
        numNodes = L.size();
    }

    protected Node<T> build_inorder(ArrayList<T> A, int begin, int end) {
        if (begin == end) {
            return null;
        } else if (begin + 1 == end) {
            return new Node<T>(A.get(begin), null, null);
        } else {
            int mid = begin + ((end - begin) / 2);
            Node<T> n = new Node<T>(A.get(mid), null, null);
            Node<T> left = build_inorder(A, begin, mid);
            Node<T> right = build_inorder(A, mid + 1, end);
            n.left = left;
            n.updateHeight(n);
            n.right = right;
            n.updateHeight(n);
            return n;
        }
    }

    public boolean contains(T k) {
        return search_helper(root, k) != null;
    }

    public Node<T> search(T k) {
        return search_helper(root, k);
    }

    public void insert(T key) {
        if (root == null) {
            root = new Node<T>(key, null, null);
            numNodes = 1;
        } else {
            if (root.insert(key, lessThan))
                ++numNodes;
        }
    }

    public void remove(T key) {
        root = remove_helper(root, key);
    }

    /**
     * TODO
     */
    public int height() {
        // student implements
        if(root==null){
            return -1;
        }
        else
            return root.height;
        //return 0;
        //return the height of the root node
    }

    /**
     * TODO
     */
    //FIX THIS
    public boolean isAVL() {
        // student implements
        if(root==null)
            return true;
        else {
            return root.isAVL();
        }
    }

    public int size() {
        return numNodes;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public String toString() {
        return tree_to_string(root);
    }

    // Helper Functions

    private String tree_to_string(Node<T> n) {
        if (n != null)
            return n.toString();
        else
            return "";
    }

    private Node<T> search_helper(Node<T> n, T key) {
        if (n == null) {
            return null;
        } else if (lessThan.test(key, n.data)) {
            return search_helper(n.left, key);
        } else if (lessThan.test(n.data, key)) {
            return search_helper(n.right, key);
        } else {
            return n;
        }
    }

    private Node<T> delete_first(Node<T> n) {
        if (n.left == null) {
            return n.right;
        } else {
            n.left = delete_first(n.left);
            //Do I add this here?
            n.updateHeight(n);
            return n;
        }
    }

    private Node<T> first(Node<T> n) {
        if (n.left == null) return n;
        else return first(n.left);
    }

    private Node<T> remove_helper(Node<T> n, T key) {
        if (n == null) {
            return null;
        } else if (lessThan.test(key, n.data)) { // remove node in left subtree
            n.left = remove_helper(n.left, key);
            n.updateHeight(n); //?
            return n;
        } else if (lessThan.test(n.data, key)) { // remove node in right subtree
            n.right = remove_helper(n.right, key);
            n.updateHeight(n); //?
            return n;
        } else { // remove this node
            --numNodes;
            if (n.left == null) {
                return n.right;
            } else if (n.right == null) {
                return n.left;
            } else { // two children, replace this with min of right subtree
                Node<T> min = first(n.right);
                n.data = min.data;
                n.right = delete_first(n.right);
                n.updateHeight(n); //??? i think i updated it within delete first?
                return n;
            }
        }
    }

}
