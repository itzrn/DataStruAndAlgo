package DSAJAVA.Queue.CTCI;
/*
Design a Queue using two stack.
 */
public class QueueUsingTwoStack<T> {
    static class Node<N>{
        N data;
        Node<N> next;

        Node(N data){
            this.data=data;
            this.next=null;
        }
    }

    Node<T> s1Head;
    Node<T> s2Head;

    public boolean isEmpty(){
        return s1Head==null;
    }

    public void push(T data){
        Node<T> temp;
        while (s1Head!=null){
            temp=s1Head;
            s1Head=s1Head.next;
            if (s2Head==null){
                s2Head=temp;
                s2Head.next=null;
            }else {
                temp.next=s2Head;
                s2Head=temp;
            }
        }

        s1Head= new Node<>(data);

        while (s2Head!=null){
            temp=s2Head;
            s2Head=s2Head.next;

            temp.next=s1Head;
            s1Head=temp;
        }
    }

    public T pop(){
        T pop= s1Head.data;
        s1Head=s1Head.next;
        return pop;
    }

    public void print(){
        Node<T> currentNode=s1Head;
        System.out.print("Front--> ");
        while (currentNode.next!=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        System.out.println(currentNode.data+" <--Rear");
    }
}
