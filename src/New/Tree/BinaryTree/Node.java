package DSAJAVA.Tree.BinaryTree;

public class Node<N>{
    N data;
    Node<N> left;
    Node<N> right;

    Node(N data){
        this.data=data;
        left=null;
        right=null;
    }
}
