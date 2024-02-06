package src.New.LinkedList;

public class LinkedList<T> {
    Node<T> head;

    public void addFist(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null) {
            head = newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void add(T data){
        Node<T> newNode=new Node<>(data);
        if (head==null){
            head=newNode;
            return;
        }

        Node<T> currentNode = head;

        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    public void print(){
        Node<T> currentNode=head;

        System.out.print("[");
        while (currentNode.next!=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        System.out.print(currentNode.data+"]\n");
    }

    public T remove() {
        Node<T> currentNode = head;
        while (currentNode.next.next!=null){
            currentNode=currentNode.next;
        }
        T removedData=currentNode.next.data;
        currentNode.next=null;

        return removedData;
    }

    public T remove(int index){
        T removedData;
        if (index==0){
            removedData= head.data;
            head=head.next;
            return removedData;
        }
        Node<T> currentNode=head;
        while (index!=1){
            currentNode=currentNode.next;
            index--;
        }
        currentNode.next=currentNode.next.next;
        removedData = currentNode.data;
        return removedData;
    }

    public int size(){
        int length=0;

        Node<T> currentNode=head;
        while (currentNode!=null){
            currentNode=currentNode.next;
            length++;
        }
        return length;
    }


    public T get(int Index){
        if (Index>=size())
            throw new IndexOutOfBoundsException();
        else if (head==null)
            throw new NullPointerException();

        Node<T> currentNode=head;

        for (int i=0;i<Index;i++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    public T removeFirst(){
        Node<T> firstElement=head;
        head=head.next;
        return firstElement.data;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.print();

        linkedList.remove(4);
        linkedList.print();

    }
}
