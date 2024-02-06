package DSAJAVA.Queue;

import java.util.EmptyStackException;

public class ArrayCircularQueue {
    int[] array;
    int length;
    int front = -1;
    int rear  = -1;

    ArrayCircularQueue(){
        array=new int[100];
        length=100;
    }

    ArrayCircularQueue(int length){
        array=new int[length];
        this.length=length;
    }

    public boolean isFull(){
        return (rear+1)%length==front;
    }

    public boolean isEmpty(){
        return front==-1 && rear==-1;
    }

    public void enQueue(int data){//Big O(1)
        if (isFull())
            throw new IndexOutOfBoundsException();

        if (front==-1){
            front=0;
        }
        rear=(rear+1)%length;
        array[rear]=data;
    }

    public int deQueue(){//Big O(1)
        if (isEmpty())
            throw new EmptyStackException();

        int pop=array[front];
        if (rear==front)
            rear=front=-1;
        else
            front=(front+1)%length;

        return pop;
    }

    public int peek(){//Big O(1)
        if (isEmpty())
            throw new EmptyStackException();

        return array[front];
    }

    public void print(){
        int f=front;
        System.out.print("Front-->");
        while (f!=rear){
            System.out.print(array[f]+" ");
            f=(f+1)%length;
        }
        System.out.println(array[f]+"<--Rear");
    }
}
