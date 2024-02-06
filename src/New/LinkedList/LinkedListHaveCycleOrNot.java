package src.New.LinkedList;

public class LinkedListHaveCycleOrNot<T> {
    public boolean hasCycle(Node<T> head){
        Node<T> turtle =head;
        Node<T> heir =head;

        do {
            turtle=turtle.next;
            heir=heir.next.next;
            if (turtle==heir){
                return true;
            }
        }while (heir!=null && heir.next!=null);

        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        MakeLinkedListCyclic<Integer> makeLinkedListCyclic=new MakeLinkedListCyclic<>();
        LinkedListHaveCycleOrNot<Integer> linkedListHaveCycleOrNot=new LinkedListHaveCycleOrNot<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        makeLinkedListCyclic.makeCycle(list.head,3);
        System.out.println(linkedListHaveCycleOrNot.hasCycle(list.head));
    }
}
