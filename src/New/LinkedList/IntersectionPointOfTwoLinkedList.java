package src.New.LinkedList;

public class IntersectionPointOfTwoLinkedList<T> {
    public Node<T> intersectionPoint(LinkedList<T> list1, LinkedList<T> list2) throws NullPointerException{
        Node<T> head1 = list1.head;
        Node<T> head2 = list2.head;
        Node<T> temp = head2;

        while (head1!=null){
            while (head2!=null){

                if (head1 == head2)
                    return head1;

                head2=head2.next;
            }
            head2=temp;
            head1=head1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkTwoLinkedList<Integer> linkTwoLinkedList=new LinkTwoLinkedList<>();
        LinkedList<Integer> list1=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(9);
        list2.add(8);
        list2.add(7);
        list2.add(6);
        list2.add(10);
        list2.add(11);

        linkTwoLinkedList.linkTwoLinkedList(list1,list2,5);

        IntersectionPointOfTwoLinkedList<Integer> integerIntersectionPointOfTwoLinkedList=new IntersectionPointOfTwoLinkedList<>();
        try{
            System.out.println(integerIntersectionPointOfTwoLinkedList.intersectionPoint(list1,list2).data);
        }catch (Exception e){
            System.out.println("No common Point!");
        }
    }
}
