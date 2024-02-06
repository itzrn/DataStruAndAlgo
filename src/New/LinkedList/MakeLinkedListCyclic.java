package src.New.LinkedList;

public class MakeLinkedListCyclic<T> {
    public void makeCycle(Node<T> head,int index){
        Node<T> temp = null;
        while (head.next!=null){
            if (index==0)
                temp=head;
            else
                index--;
            head=head.next;
        }

        head.next=temp;
    }
}
