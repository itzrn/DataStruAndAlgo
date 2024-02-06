package DSAJAVA.Stack;

import java.util.EmptyStackException;

public class MyStack<T> {//Last In First Out
    static class Node<N>{
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    MyStack(){
        this.length=0;
    }
    MyStack(int length){
        this.length=length;
    }

    Node<T> head;
    int length;

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void push(T data){//Big O(1)
        if (getLength()>0 && size()==getLength())
            throw new StackOverflowError();

        Node<T> newNode=new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }

        //pushing the data
        newNode.next=head;
        head=newNode;
    }

    public T pop(){//Big O(1)
        if (isEmpty())
            throw new EmptyStackException();
        T top= head.data;

        //removing the last push
        head=head.next;

        return top;
    }

    public int size(){
        int length=0;
        Node<T> currentNode=head;

        while (currentNode!=null){
            length++;
            currentNode=currentNode.next;
        }

        return length;
    }

    public T peek(int position){//Big O(position)
        //top is the first position
        if ((getLength()>0 && position>getLength())||position>size())
            throw new StackOverflowError();

        Node<T> currentNode=head;
        for (int i=1;i<position;i++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    public void print(){
        if (isEmpty())
            throw new EmptyStackException();

        Node<T> currentNode=head;
        System.out.print("Top---> ");
        while (currentNode!=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        System.out.println("<---Bottom");
    }

    public T getTop(){
        if (isEmpty())
            throw new EmptyStackException();
        return head.data;
    }

    public T getBottom(){
        if (isEmpty())
            throw new EmptyStackException();

        Node<T> currentNode=head;
        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }

        return currentNode.data;
    }

    public void pushAtBottom(T data){//recursive method to push element at bottom
        // here Address of every data is getting change, means node is not getting
        // change but data of particular node is getting change
        if (isEmpty()){
            push(data);
            return;
        }
        T top=pop();
        pushAtBottom(data);
        push(top);
    }

    public void reverse(MyStack<T> list){// recursive method to reverse the stack
        // here address of particular data isi getting change
        if (isEmpty())
            return;
        T top= list.pop();
        reverse(list);
        pushAtBottom(top);
    }

    public Node<T> reverseRecursive(Node<T> head){// here node get reverse
        if (head==null||head.next==null)
            return head;
        Node<T> newNode = reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }

    public void reverse(){
        head=reverseRecursive(head);
    }
}
