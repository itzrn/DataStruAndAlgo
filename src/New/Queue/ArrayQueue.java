package DSAJAVA.Queue;

import java.util.EmptyStackException;

public class ArrayQueue {//this is particularly for int values
    int[] array;
    int length;
    int rear=-1;

    ArrayQueue(){
        array=new int[100];
        length=100;
    }

    ArrayQueue(int length){
        array=new int[length];
        this.length=length;
    }

    public boolean isEmpty(){//Big O(1)
        return rear==-1;
    }

    public boolean isFull(){//Big O(1)
        return rear==length-1;
    }

    public void enQueue(int data){//Big O(1)
        if (isFull())
            throw new IndexOutOfBoundsException();

        rear++;
        array[rear]=data;
    }

    public int deQueue(){//Big O(n)
        if (isEmpty())
            throw new EmptyStackException();

        int pop=array[0];

        for (int i=0;i<rear;i++){
            array[i]=array[i+1];
        }
        rear--;

        return pop;
    }

    public int peek(){
        if (isEmpty())
            throw new EmptyStackException();

        return array[0];
    }

    public void print(){
        System.out.print("Front--> ");
        for (int i=0;i<=rear;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("<--Rear");
    }
}
