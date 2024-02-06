package src.New.LinkedList;

public class LinkTwoLinkedList<T> {

    public void linkTwoLinkedList(LinkedList<T> list1, LinkedList<T> list2, int index){ //connecting list1 at any index of list2
        Node<T> currentNode1 = list1.head;
        while (currentNode1.next!=null){
            currentNode1=currentNode1.next;
        }
        Node<T> currentNode2 = list2.head;
        while (index!=0){
            currentNode2=currentNode2.next;
            index--;
        }
        currentNode1.next=currentNode2;
    }

//    public static void main(String[] args) {
//        LinkTwoLinkedList<Integer> linkedList=new LinkTwoLinkedList<>();
//        LinkedList<Integer> linkedList1=new LinkedList<>();
//        linkedList1.add(1);
//        linkedList1.add(2);
//        linkedList1.add(3);
//        linkedList1.add(4);
//        linkedList1.print();
//        LinkedList<Integer> linkedList2=new LinkedList<>();
//        linkedList2.add(9);
//        linkedList2.add(8);
//        linkedList2.add(7);
//        linkedList2.add(6);
//        linkedList2.add(5);
//        linkedList2.print();
//        linkedList.linkTwoLinkedList(linkedList1,linkedList2,2);
//        linkedList1.print();
//        linkedList2.print();
//
//    }
}
