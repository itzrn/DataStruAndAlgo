package src.New.LinkedList;

import java.util.NoSuchElementException;

public class GenericLinkedList<T> {
    /**
     * All Function
     * addFirst(T data), add(T data), size(), get(int Index),getIndexOf(T data), removeFirst(), removeLast(),
     * add(int index,T data), remove(), remove(int index), print(), deleteRepeatedElement(), deleteRepeatedElementUsingMethod()
     * selectionSor(), selectionSortOfStringOnBasisOfLength(GenericLinkedList<string> genericLinkedList),
     * getNodeOfIndex(int index), bubbleSort(), linearSearch(T data),
     * binarySearchOfNumber(number data,GenericLinkedList<number> genericLinkedList,int min, int max)
     * reverseUsingExtraSpace(), reverse(), recursiveMethodToReverse(Node<T> head), reverseRecursive()
     * getSubGenericLinkedList(int startIncluded, int endExcluded),deleteNthNodeFromEnd(int nFromLast)
     * toFindMiddleTermUsingHareTurtle(), hasCycle(), makeCycle(int index), addInCycle(T data)
     * printCycle(), sizeIfCycle(), removeCycle()
     */
    static class Node<N>{
        N data;
        GenericLinkedList<N> list;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> head;

    public void addFirst(T data){
        Node<T> newNode=new Node<>(data);

        if (head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void add(T data){
        if (hasCycle()){
            addInCycle(data);
            return;
        }
        Node<T> newNode= new Node<>(data);

        if (head==null){
            head=newNode;
            return;
        }
        Node<T> currentNode=head;

        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    public int size(){
        if (hasCycle()){
            return sizeIfCycle();
        }
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

    public int getIndexOf(T data){
        int index=0;

        if (head==null)
            throw new NullPointerException();

        Node<T> currentNode=head;

        while (currentNode!=null){
            if (currentNode.data==data){
                break;
            }
            currentNode=currentNode.next;
            index++;
        }
        if (index==size())
            throw new NoSuchElementException();
        return index;
    }

    public T removeFirst(){
        Node<T> firstElement=head;
        head=head.next;
        return firstElement.data;
    }

    public void removeLast(){
        Node<T> currentNode=head;

        while (currentNode.next.next!=null)
            currentNode=currentNode.next;

        currentNode.next=null;
    }

    public void add(int index, T data){
//        if (hasCycle()){//if any cycle present in the LinkedList
//            addInCycle(data);
//            return;
//        }
        Node<T> newNode=new Node<>(data);
        Node<T> currentNode=head;
        Node<T> nextNode;
        if (index==0){
            addFirst(data);
            return;
        }
        for (int i=0;i<index-1;i++){
            currentNode=currentNode.next;
        }
        nextNode=currentNode.next;
        currentNode.next=newNode;
        newNode.next=nextNode;
    }

    public void remove(){
        removeLast();
    }

    public T remove(int index){
        Node<T> currentNode=head;
        Node<T> deletedNode;
        if (index==0){
            return removeFirst();
        }

        for (int i=0;i<index-1;i++){
            currentNode=currentNode.next;
        }
        deletedNode=currentNode.next;
        currentNode.next=currentNode.next.next;
        return deletedNode.data;
    }

    public void removeNodeWithGivenData(T data){
        Node<T> previousNode=this.head;
        Node<T> currentNode=previousNode.next;
        if (previousNode.data==data) {
            removeFirst();
            return;
        }

        while (currentNode!=null){
            if (currentNode.data==data){
                previousNode.next=previousNode.next.next;
            }
            currentNode=currentNode.next;
            previousNode=previousNode.next;
        }
    }

    public void print(){
        if (hasCycle()){// if singly linkedList have cycle in it
            printCycle();
            return;
        }
        Node<T> currentNode=head;
        System.out.print("GenericLinkedList ---> [");
        while (currentNode.next!=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        System.out.print(currentNode.data);
        System.out.println("]");
    }

    public void print(Node<T> head){// this function is just to print from any middle term
        Node<T> currentNode=head;
        System.out.print("|");
        while (currentNode!=null){
            System.out.print(currentNode.data+"|");
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    public void deleteRepeatedElement(){//CTCI Question
        Node<T> currentNode=head;
        Node<T> nextNode;

        while (currentNode!=null){
            nextNode=currentNode;
            while (nextNode.next!=null){
                if (currentNode.data== nextNode.next.data)
                    nextNode.next=nextNode.next.next;
                else
                    nextNode=nextNode.next;
            }
            currentNode=currentNode.next;
        }
    }

    public void deleteRepeatedElementUsingMethod(){
        int n=size();

        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (get(i)==get(j)) {
                    remove(j);
                    n=size();
                }
            }
        }
    }

    public <number extends Number> void selectionSortOnBasisOfData(GenericLinkedList<number> genericLinkedList){
        Node<number>currentNode=genericLinkedList.head;
        Node<number>nextNode;
        number temp;

        while (currentNode!=null){
            nextNode=currentNode;
            while (nextNode.next!=null){
                if (currentNode.data.doubleValue()>nextNode.next.data.doubleValue()){
                    temp= currentNode.data;
                    currentNode.data=nextNode.next.data;
                    nextNode.next.data=temp;
                }
                nextNode=nextNode.next;
            }
            currentNode=currentNode.next;
        }
    }

    public <string extends String> void selectionSortOfStringOnBasisOfLength(GenericLinkedList<string> genericLinkedList){
        Node<string> currentNode=genericLinkedList.head;
        Node<string> nextNode;
        string temp;

        while (currentNode!=null){
            nextNode=currentNode.next;
            while (nextNode!=null){
                if (currentNode.data.length()>nextNode.data.length()){
                    temp= currentNode.data;
                    currentNode.data=nextNode.data;
                    nextNode.data=temp;
                }
                nextNode=nextNode.next;
            }
            currentNode=currentNode.next;
        }
    }

    public Node<T> getNodeOfIndex(int index){
        Node<T> currentNode=head;
        for (int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        return currentNode;
    }


    public <number extends Number> void  bubbleSort(GenericLinkedList<number> genericLinkedList){
        number temp;
        int a=1;
        for (int i=0;i<genericLinkedList.size();i++){
            for (int j=0;j<genericLinkedList.size()-a;j++){
                temp=genericLinkedList.getNodeOfIndex(j).data;
                if (genericLinkedList.getNodeOfIndex(j).data.doubleValue()>genericLinkedList.getNodeOfIndex(j+1).data.doubleValue()){
                    genericLinkedList.getNodeOfIndex(j).data=genericLinkedList.getNodeOfIndex(j+1).data;
                    genericLinkedList.getNodeOfIndex(j+1).data=temp;
                }
            }
            a++;
        }
    }

    public boolean linearSearch(T data){
        for (int i=0;i<size();i++){
            if (data.equals(getNodeOfIndex(i).data)) {
                return true;
            }
        }
        return false;
    }

    public <number extends Number> int binarySearchOfNumber(number data,GenericLinkedList<number> genericLinkedList,int min, int max){
        int mid=(min+max)/2;
        if (min>mid)
            return -1;
        else if (genericLinkedList.getNodeOfIndex(mid).data.doubleValue()== data.doubleValue())
            return mid;
        else if (genericLinkedList.getNodeOfIndex(mid).data.doubleValue()> data.doubleValue())
            return binarySearchOfNumber(data, genericLinkedList,min,mid-1);
        else if (genericLinkedList.getNodeOfIndex(mid).data.doubleValue()< data.doubleValue())
            return binarySearchOfNumber(data,genericLinkedList,mid+1,max);
        else
            return -1;
    }

    public void reverseUsingExtraSpace(){//Here it is Space Complexity
        Node<T> newNode;
        Node<T> currentNode=head;
        head=null;
        while (currentNode!=null){
            newNode=new Node<>(currentNode.data);
            if (head!=null){
                newNode.next=head;
            }
            head=newNode;
            currentNode=currentNode.next;
        }
    }

    public Node<T> reverseOfList(Node<T> head){
        if (head==null || head.next==null)
            return head;

        Node<T> previousNode=head;
        Node<T> currentNode=head.next;
        Node<T> nextNode;

        while (currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=previousNode;

            //update
            previousNode=currentNode;
            currentNode=nextNode;
        }
        head.next=null;
        head=previousNode;

        return head;
    }

    public void reverse(){
        head=reverseOfList(head);
    }

    public boolean isPalindrome(){
        int n=size()/2;
        if (head==null || head.next==null)
            return true;

        Node<T> currentNode=head;
        while (n!=0){
            currentNode=currentNode.next;
            n--;
        }
        Node<T> newHead=reverseOfList(currentNode);
        Node<T> oldHead=head;
        while (newHead!=null){
            if (newHead.data!=oldHead.data)
                return false;
            newHead=newHead.next;
            oldHead=oldHead.next;
        }
        return true;
    }

    public Node<T> recursiveMethodToReverse(Node<T> head){
        if (head==null || head.next==null)
            return head;

        Node<T> newHead=recursiveMethodToReverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public void reverseRecursive(){
        head=recursiveMethodToReverse(head);
    }

    public GenericLinkedList<T> getSubGenericLinkedList(int startIncluded, int endExcluded){
        GenericLinkedList<T> genericLinkedList=new GenericLinkedList<>();

        for (int i=startIncluded;i<endExcluded;i++){
            genericLinkedList.add(get(i));
        }

        return genericLinkedList;
    }

    public void deleteNthNodeFromEnd(int nFromLast){
        Node<T> currentNode = head;
        int n=size()-nFromLast-1;

        if (n<-1 || nFromLast <=0)
            throw new NullPointerException();

        if (n==-1){
            head=head.next;
            return;
        }

        while (n!=0){
            currentNode=currentNode.next;
            n=n-1;
        }
        currentNode.next=currentNode.next.next;
    }

    public Node<T> toFindMiddleTermUsingHareTurtle(){
        if(head==null||head.next==null||head.next.next==null)
            throw new NoSuchFieldError();

        Node<T> hare=head;
        Node<T> turtle=head;

        while (hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
        }
        return turtle;
    }

    public boolean hasCycle(){
        if (head==null)
            return false;

        Node<T> hare = head;
        Node<T> turtle = head;

        while (hare!=null && hare.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
            if (turtle==hare)
                return true;
        }
        return false;
    }

    Node<T> cyclicHead;
    public void makeCycle(int index){
        if (head==null)
            throw new NullPointerException();
        if (index>=size())
            throw new IndexOutOfBoundsException();

        int i=0;

        Node<T> currentNode=head;
        while (currentNode.next!=null){
            if (i==index)
                cyclicHead=currentNode;
            i++;
            currentNode=currentNode.next;
        }
        if (cyclicHead==null)
            cyclicHead=currentNode;
        currentNode.next=cyclicHead;
    }

    public void addInCycle(T data){//if any cycle present in the LinkedList, it used to add a node to that cycle
        Node<T> newNode=new Node<>(data);
        Node<T> currentNode=cyclicHead;

        if (cyclicHead.next==cyclicHead){
            cyclicHead.next=newNode;
            newNode.next=cyclicHead;
            return;
        }

        while (currentNode.next!=cyclicHead){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
        newNode.next=cyclicHead;
    }

    public void printCycle(){//if any cycle present in the LinkedList
        int i =0;
        Node<T> currentNode=head;
        System.out.print("|");
        while (true){
            if (currentNode==cyclicHead) {
                i++;
                if (i==2)
                    break;
            }
            System.out.print(currentNode.data+"|");
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    public int sizeIfCycle(){//if any cycle present in the LinkedList
        int i =0;
        int length=0;
        Node<T> currentNode=head;
        while (true){
            if (currentNode==cyclicHead) {
                i++;
                if (i==2)
                    break;
            }
            length++;
            currentNode=currentNode.next;
        }
        System.out.print("This LinkedList Have cycle ---> ");
        return length;
    }

    public void removeCycle(){//this is even valid for circular LinkedList
        Node<T> hare = head;
        Node<T> turtle = head;

        do {
            hare = hare.next.next;
            turtle = turtle.next;
        } while (hare != turtle);

        hare = head;
        if (hare==turtle){
            while (hare.next!=turtle){
                hare=hare.next;
            }
            hare.next=null;
            return;
        }
        while (hare.next != turtle.next) {
            hare = hare.next;
            turtle = turtle.next;
        }

        turtle.next = null;
    }

    public void sumOfList(long a,long b){
        int carry=0;
        int sum;
        GenericLinkedList<Integer> genericLinkedList01=new GenericLinkedList<>();
        GenericLinkedList<Integer> genericLinkedList02=new GenericLinkedList<>();
        GenericLinkedList<Integer> sumList=new GenericLinkedList<>();
        while (a>0 || b>0){
            genericLinkedList01.add((int) a%10);
            genericLinkedList02.add((int) b%10);
            a=a/10;
            b=b/10;
        }
        Node<Integer> currentNode01 = genericLinkedList01.head;
        Node<Integer> currentNode02 = genericLinkedList02.head;

        while (currentNode01!=null){
            sum=currentNode01.data+ currentNode02.data+carry;
            if (sum>9){
                sumList.add(sum-10);
                carry=1;
            }else {
                sumList.add(sum);
                carry=0;
            }
            currentNode01=currentNode01.next;
            currentNode02=currentNode02.next;
        }
        if (carry==1)
            sumList.add(1);
        sumList.reverse();
        currentNode01=sumList.head;
        while (currentNode01!=null){
            System.out.print(currentNode01.data);
            currentNode01=currentNode01.next;
        }
    }

    public void deleteMiddleNode(){//In even Number of List it will delete second middle term
        if(head==null||head.next==null||head.next.next==null)
            throw new NoSuchFieldError();

        Node<T> hare=head.next;
        Node<T> turtle=head;

        while (hare.next!=null&&hare.next.next!=null){
            turtle=turtle.next;
            hare=hare.next.next;
        }
        turtle.next=turtle.next.next;
    }

    public void intersection(GenericLinkedList<T> l1,GenericLinkedList<T> l2){
        Node<T> head1=l1.head;
        Node<T> head2=l2.head;
        Node<T> temp=head2;
        GenericLinkedList<T> intersection=new GenericLinkedList<>();

        while (head1!=null){
            while (head2!=null){
                if (head1.data==head2.data)
                    intersection.add(head2.data);
                head2=head2.next;
            }
            head2=temp;
            head1=head1.next;
        }
        intersection.print();
    }

    public void makeTwoLinkedListIntersect(GenericLinkedList<T> list1,GenericLinkedList<T> list2, int index){
        Node<T> currentNode01=list1.head;
        Node<T> currentNode02=list2.head;
        while (currentNode02.next!=null)
            currentNode02=currentNode02.next;
        while (index!=0){
            currentNode01=currentNode01.next;
            index--;
        }
        currentNode02.next=currentNode01;
    }

//    public boolean checkTwoListsIntersection(GenericLinkedList<T> list1,GenericLinkedList<T> list2){
//
//    }
    public static void main(String[] args) {
        GenericLinkedList<Integer> genericLinkedList=new GenericLinkedList<>();
        GenericLinkedList<Integer> genericLinkedList1=new GenericLinkedList<>();
        genericLinkedList.add(1);
        genericLinkedList.add(2);
        genericLinkedList.add(3);
        genericLinkedList.add(4);
        genericLinkedList.add(5);
        genericLinkedList.add(6);
        genericLinkedList.add(7);
        genericLinkedList.add(8);
        genericLinkedList.add(9);
        genericLinkedList.add(10);
        genericLinkedList.add(11);
        genericLinkedList1.add(23);
        genericLinkedList1.add(2);
        genericLinkedList1.add(3);
        genericLinkedList1.add(24);
        genericLinkedList1.add(7);
        genericLinkedList1.add(89);
        genericLinkedList1.add(80);
        genericLinkedList1.add(8);
        genericLinkedList1.add(456);
        genericLinkedList1.add(96);
        genericLinkedList.makeTwoLinkedListIntersect(genericLinkedList1,genericLinkedList,4);
        genericLinkedList.print();
        genericLinkedList1.print();
//        genericLinkedList.intersection(genericLinkedList1,genericLinkedList);
//        genericLinkedList.makeCycle(6);
//        genericLinkedList.add(67);
//        genericLinkedList.print();

//        genericLinkedList.deleteMiddleNode();
//        genericLinkedList.print();
//        System.out.println(genericLinkedList.size());
//        genericLinkedList.removeCycle();
//        genericLinkedList.print();
//        System.out.println(genericLinkedList.size());
//        genericLinkedList.sumOfList(3456,789787);
    }
}