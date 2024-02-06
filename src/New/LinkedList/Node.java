package src.New.LinkedList;

public class Node<N> {
    N data;
    Node<N> next;

    Node(N data){
        this.data=data;
        next=null;
    }
}
