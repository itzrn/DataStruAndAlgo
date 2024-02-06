package DSAJAVA.Tree.BinaryTree;

public class Stack<T>{
    static class Node<N>{
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;

    public void add(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void remove(){
        if (head==null)
            return;

        head=head.next;
    }

    public boolean isStackEmpty(){
        return head==null;
    }

    public T peek(){
        return head.data;
    }
}