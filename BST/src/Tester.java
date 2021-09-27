import java.util.ArrayList;

public class Tester {
    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<>(10, new BinaryNode<>(5, new BinaryNode<>(2, null, null),new BinaryNode<>(7, null, null)), new BinaryNode<>(14, null, null));
        //BinaryNode<Integer> root = new BinaryNode<>(8, new BinaryNode<>(3, new BinaryNode<>(1, null, null),new BinaryNode<>(6, new BinaryNode<Integer>(4, null, null), new BinaryNode<Integer>(7,null, null))), new BinaryNode<>(10, null, new BinaryNode<Integer>(14, new BinaryNode<Integer>(13, null, null), null)));
        BinaryTree<Integer> bob = new BinaryTree<>(root);
        ArrayList<Integer> out = new ArrayList<Integer>();
        bob.postorder(out);
        ArrayList<Integer> shouldEqual = new ArrayList<Integer>();
        shouldEqual.add(10);
        shouldEqual.add(5);
        shouldEqual.add(2);
        shouldEqual.add(7);
        shouldEqual.add(14);

        ArrayList<Integer> preorder = new ArrayList<Integer>();
        preorder.add(8);
        preorder.add(3);
        preorder.add(1);
        preorder.add(6);
        preorder.add(4);
        preorder.add(7);
        preorder.add(10);
        preorder.add(14);
        preorder.add(13);


        for(int i=0; i!=out.size(); ++i){
            System.out.print(out.get(i) + " ");
        }
        System.out.println("\nanswer:");
        for(int i=0; i!=preorder.size(); ++i){
            System.out.print(preorder.get(i) + " ");
        }
    }
}
