package src.Tree.BinarySearchTree;

public class BSTNode {
    BSTNode left;
    int data;
    BSTNode right;

    BSTNode(int data){
        this.data = data;
        right = null;
        left = null;
    }
}
