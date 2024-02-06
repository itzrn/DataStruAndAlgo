package src.New.LinkedList;

import java.util.NoSuchElementException;
public class LinkedListUser {

    public static class Node {
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }

    Node head;

    public void addFirst(String data){//it will add at the first of the collection
        Node newNode= new Node(data);
        if (head==null){
            head=newNode;
            //just after this newNode automatically get collect in garbage collection,
            // which automatically get destroy by JVM
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void add(String data){//it will add at the last of the collection
        Node newNode= new Node(data);
        if (head==null){
            head=newNode;
            return;
        }
        Node currentNode=head;
        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    public int size(){//it will find the total number of elements in the collection
        int length=0;

        Node currentNode=head;
        while (currentNode!=null){
            currentNode=currentNode.next;
            length++;
        }
        return length;
    }

    public String get(int index){//it will give the element of the particular given index
        Node currentNode=head;


        for (int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    public int getIndexOff(String string){//it will give the index of that particular element
        int i=0;
        Node currentNode=head;

        if (head==null)
            return -1;

        while (currentNode!=null){
            if (currentNode.data.equals(string))
                break;
            currentNode=currentNode.next;
            i++;
        }
        if (i==size())
            throw new NoSuchElementException();
        return i;
    }

    public String removeFirst(){//it will remove the first element of the collection
        Node t=head;
        head=head.next;
        return t.data;
    }

    public void removeLast(){//it will remove the last element of the collection
        Node currentNode=head;
        for (int i=0;i<size()-2;i++){
            currentNode=currentNode.next;
        }
        currentNode.next=null;
    }

    public String removeAt(int index){
        Node currentNode=head;

        for (int i=0;i<index-2;i++){
            currentNode=currentNode.next;
        }
        currentNode.next=currentNode.next.next;
        return currentNode.next.data;
    }

    public void add(int index,String string){//it will add a particular element at the given particular index.
        Node newNode=new Node(string);
        Node currentNode=head;
        Node nextNode;

        if (head==null)
            return;

        for (int i=0;i<index-2;i++){
            currentNode=currentNode.next;
        }
        nextNode=currentNode.next;
        currentNode.next=newNode;
        newNode.next=nextNode;
    }
}
