package src.Tree.BinaryTree.TreeWithGeneric;


public class T13_PostOrderPrint<T> extends T04_LevelOrderTreeBuilt<T> {

    public void printRecursive(T01_Node<T> root){//Post Order Traversal
        if (root==null)
            return;

        printRecursive(root.left);
        printRecursive(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        T13_PostOrderPrint<Integer> postOrderPrint=new T13_PostOrderPrint<>();
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
