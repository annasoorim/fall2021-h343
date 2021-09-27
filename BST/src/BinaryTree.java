import java.util.ArrayList;

class BinaryNode<T> {
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T d, BinaryNode<T> l, BinaryNode<T> r) {
        data = d; left = l; right = r;
    }

    public void preorder(ArrayList<T> out) {
        // student implements
        //preorder = me, left, right
        /*if(left==null && right==null){
            out.add(data);
            return;
        }
        if(left!=null && right!=null){
            out.add(data);
        }
        //System.out.print(this.data + " ");
        left.preorder(out);
        //out.add(data);
        right.preorder(out);
        //out.add(data);*/
        out.add(data);//adding root aka me
        preorderMethod(out, left);
        preorderMethod(out, right);
        //first add the data to the out
        //then call the method with the left
        //call method with right
    }

    public void preorderMethod(ArrayList<T> out, BinaryNode<T> currentNode){
        //check if it's null, then stop
        if(currentNode==null){
            return;
        }
        else{
            out.add(currentNode.data); //add data
            preorderMethod(out, currentNode.left); //repeat for left subtree then right
            preorderMethod(out, currentNode.right);
        }
    }

    public void inorder(ArrayList<T> out) {
        // student implements
        //left root right
        inorderMethod(out, left);
        out.add(data);
        inorderMethod(out, right);


    }
    public void inorderMethod(ArrayList<T> out, BinaryNode<T> currentNode){
        if(currentNode==null){
            return;
        }
        else{
            inorderMethod(out, currentNode.left);
            out.add(currentNode.data);
            inorderMethod(out, currentNode.right);
        }
    }

    public void postorder(ArrayList<T> out) {
        // student implements
        // left, right, me
        postorderMethod(out, left);
        postorderMethod(out, right);
        out.add(data);
    }
    public void postorderMethod(ArrayList<T> out, BinaryNode<T> currentNode){
        if(currentNode==null){
            return;
        }
        else{
            postorderMethod(out, currentNode.left);
            postorderMethod(out, currentNode.right);
            out.add(currentNode.data);
        }
    }
}

public class BinaryTree<T> {
    private BinaryNode<T> root;

    public BinaryTree() { root = null; }
    public BinaryTree(BinaryNode<T> r) { root = r; }

    public void preorder(ArrayList<T> f) { root.preorder(f); }
    public void inorder(ArrayList<T> f) { root.inorder(f); }
    public void postorder(ArrayList<T> f) { root.postorder(f); }

}
