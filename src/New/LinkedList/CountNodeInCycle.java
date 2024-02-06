package src.New.LinkedList;

public class CountNodeInCycle<T> {
    int size;
    int size1;
    public int count(Node<T> head){
        if (size1-size>0)
            return -(size1-size)+1;
        size++;
        size1=count(head.next);

        return size;
    }
}
