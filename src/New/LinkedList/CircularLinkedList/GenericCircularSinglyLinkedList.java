package DSAJAVA.LinkedList.CircularLinkedList;

public class GenericCircularSinglyLinkedList<T> {//Singly circular Linked List

    /**
     * All Functions
     * addFirst(T data), add(T data), addLast(T data), print(),
     */
    static  class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;

    public void addFirst(T data){
        Node<T> newNode=new Node<>(data);

        if (head==null){
            head=newNode;
            head.next=head;
            return;
        }
        Node<T> currentNode=head;

        do {
            currentNode=currentNode.next;
        }while (currentNode.next!=head);

        currentNode.next=newNode;
        newNode.next=head;
        head=newNode;
    }

    public void add(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null){
            head=newNode;
            head.next=head;
            return;
        }
        Node<T> currentNode=head;
        do {
            currentNode=currentNode.next;
        }while (currentNode.next!=head);
        currentNode.next=newNode;
        newNode.next=head;
    }

    public void addLast(T data){
        add(data);
    }

    public  void print(){
        Node<T> currentNode=head;
        System.out.print("[");
        do {
            if (currentNode.next==head)
                System.out.print(currentNode.data);
            else {
                System.out.print(currentNode.data+" ");
                currentNode=currentNode.next;
            }
        }while (currentNode.next!=head);
        if (currentNode==head)
            System.out.println("]");
        else
            System.out.println(currentNode.data+"]");
    }

    public int size(){//it returns -1 when there is no element in List
        int size=0;

        if (head==null)
            return -1;

        Node<T> currentNode=head;
        do {
            size++;
            currentNode=currentNode.next;
        }while (currentNode!=head);

        return size;
    }

    public T get(int index){
        Node<T> currentNode = head;
        if (head==null)
            throw new NullPointerException("Error! ---> LinkedList Not Created");
        else if (index>=size())
            throw new IndexOutOfBoundsException("Error! ---> LinkedList wont contain any element at index ---> "+index);

        while (index>0){
            currentNode=currentNode.next;
            index--;
        }

        return currentNode.data;
    }

    public int getIndexOff(T data){//it returns -1 when it has no such element in the list
        if (head==null)
            throw new NullPointerException();
        T temp;
        Node<T> currentNode=head;
        int index=0;
        do{// getting error at 999 ---> as data. why so??
            temp= currentNode.data;
            if (temp==data){
                return index;
            }
            index++;
            currentNode=currentNode.next;
        }while (currentNode!=head);

        return -1;
    }

    public void remove(int index){
        if (head==null || index<0 || index>=size())
            throw new NullPointerException();
        else if (head.next==head) {
            head = null;
            return;
        }
        if (index==0){
            Node<T> newCurrentNode=head;
            while (newCurrentNode.next!=head){
                newCurrentNode=newCurrentNode.next;
            }
            head=head.next;
            newCurrentNode.next=head;
            return;
        }
        index--;
        Node<T> currentNode = head;
        while (index>0){
            index--;
            currentNode=currentNode.next;
        }
        currentNode.next=currentNode.next.next;
    }

    public static void main(String[] args) {
        GenericCircularSinglyLinkedList<Integer> genericCircularLinkedList=new GenericCircularSinglyLinkedList<>();
        genericCircularLinkedList.add(83);
        genericCircularLinkedList.add(2);
        genericCircularLinkedList.add(3);
        genericCircularLinkedList.add(4);
        genericCircularLinkedList.add(99999);
        genericCircularLinkedList.add(6);
        genericCircularLinkedList.add(7);
        genericCircularLinkedList.print();
        System.out.println(genericCircularLinkedList.size());
        genericCircularLinkedList.addFirst(90);
        genericCircularLinkedList.add(78778);
        genericCircularLinkedList.add(45);
        genericCircularLinkedList.add(888);
        genericCircularLinkedList.print();
        System.out.println(genericCircularLinkedList.size());
        System.out.println(genericCircularLinkedList.get(0));
        System.out.println(genericCircularLinkedList.size());
        genericCircularLinkedList.remove(0);
        genericCircularLinkedList.print();
        System.out.println(genericCircularLinkedList.getIndexOff(45));
    }
}