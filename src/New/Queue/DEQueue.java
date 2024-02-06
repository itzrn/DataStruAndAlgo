package DSAJAVA.Queue;

public class DEQueue<T> {
    static class Node<N>{
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;

    public void enQueueFront(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void enQueueRear(T data){
        Node<T> newNode=new Node<>(data);
        Node<T> currentNode=head;

        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    public T deQueueFront(){
        T front= head.data;
        head=head.next;
        return front;
    }

    public T deQueueRear(){
        Node<T> currentNode=head;

        while (currentNode.next.next!=null){
            currentNode=currentNode.next;
        }
        T rear=currentNode.next.data;
        currentNode.next=null;
        return rear;
    }

    public void print(){
        System.out.print("[");
        Node<T> currentNode=head;
        while (currentNode.next!=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        System.out.print(currentNode.data+"]");
    }
}
