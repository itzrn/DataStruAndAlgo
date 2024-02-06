package DSAJAVA.Queue;

import java.util.EmptyStackException;

public class LinkedListQueue<T extends Number> {
    static class Node<N>{
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty(){
        return head==null && tail == null;// or juts return head == null;
    }

    public void enQueue(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=tail.next;
    }

    public T deQueue(){
        if (head==null)
            throw new EmptyStackException();

        T pop= head.data;
        if (head==tail)
            tail=null;
        head=head.next;
        return pop;
    }

}
