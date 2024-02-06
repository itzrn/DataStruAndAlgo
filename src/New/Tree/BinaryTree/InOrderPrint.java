package DSAJAVA.Tree.BinaryTree;

public class InOrderPrint<T> extends LevelOrderTreeBuild<T> {

    public void printRecursive(Node<T> root){//InOrder Traversal
        if (root==null)
            return;

        printRecursive(root.left);
        System.out.println(root.data);
        printRecursive(root.right);
    }

    public static void main(String[] args) {
        InOrderPrint<Integer> inOrderPrint=new InOrderPrint<>();
        inOrderPrint.push(1);
        inOrderPrint.push(2);
        inOrderPrint.push(3);
        inOrderPrint.push(4);
        inOrderPrint.push(5);
        inOrderPrint.push(6);
        inOrderPrint.push(7);
        inOrderPrint.push(8);
        inOrderPrint.push(9);
        inOrderPrint.push(10);
        inOrderPrint.printRecursive(inOrderPrint.root);
    }
}
