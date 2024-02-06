package DSAJAVA.Tree.BinaryTree;

public class Queue<T>{
    private static class Node<N>{//First In First Out
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;

    public void enQueue(T data){
        Node<T> newNode=new Node<>(data);
        if(head==null){
            head=newNode;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    public void deQueue(){
        head=head.next;
    }

    public T peekFront(){
        return head.data;
    }

    public boolean isQueueEmpty(){
        return head==null;
    }
}