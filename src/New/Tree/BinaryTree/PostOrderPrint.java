package DSAJAVA.Tree.BinaryTree;

public class PostOrderPrint<T> extends LevelOrderTreeBuild<T> {

    public void printRecursive(Node<T> root){//Post Order Traversal
        if (root==null)
            return;

        printRecursive(root.left);
        printRecursive(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        PostOrderPrint<Integer> postOrderPrint=new PostOrderPrint<>();
        postOrderPrint.push(1);
        postOrderPrint.push(2);
        postOrderPrint.push(3);
        postOrderPrint.push(4);
        postOrderPrint.push(5);
        postOrderPrint.push(6);
        postOrderPrint.push(7);
        postOrderPrint.printRecursive(postOrderPrint.root);
    }
}
