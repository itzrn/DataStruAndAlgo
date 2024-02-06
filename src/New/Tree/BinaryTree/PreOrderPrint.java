package DSAJAVA.Tree.BinaryTree;

public class PreOrderPrint<T> extends LevelOrderPrint<T> {

    public void printRecursive(Node<T> root){//PreOrder Traversal
        if (root==null)
            return;
        System.out.println(root.data);
        printRecursive(root.left);
        printRecursive(root.right);
    }

    public static void main(String[] args) {
        PreOrderPrint<Integer> preOrderPrint=new PreOrderPrint<>();
        preOrderPrint.push(1);
        preOrderPrint.push(2);
        preOrderPrint.push(3);
        preOrderPrint.push(4);
        preOrderPrint.push(5);
        preOrderPrint.push(6);
        preOrderPrint.push(7);
        preOrderPrint.push(8);
        preOrderPrint.printRecursive(preOrderPrint.root);
    }
}
