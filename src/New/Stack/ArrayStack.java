package DSAJAVA.Stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayStack {//this is not generic, this is only for integer
    int top;
    int capacity;
    int[] array;

    ArrayStack(){
        top=-1;
        this.capacity=100;
        array=new int[this.capacity];
    }

    ArrayStack(int capacity){
        top=-1;
        this.capacity=capacity;
        array=new int[this.capacity];
    }

    public boolean isEmpty(){// Big O(1)
        return top == -1;
    }

    public boolean isFull(){// Big O(1)
        return top == this.capacity-1;
    }

    public void push(int data){//first in have small index
        // Big O(1)
        if (isFull())
            throw new IndexOutOfBoundsException();

        array[top+1]=data;
        top++;
    }

    public void pop(){// Big O(1)
        if (isEmpty())
            throw new EmptyStackException();

        top--;
    }

    public void display(){// Big O(top+1)
        if (top == -1)
            throw new NoSuchElementException();
        System.out.print("["+array[top]);
        for (int i=top-1;i>=0;i--){
            System.out.print(" "+array[i]);
        }
        System.out.println("]");
    }

    public int peek(int index){//first push have 0 index ---> means, first push have small index
        // Big O(1)
        if (index>top)
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    public int peekAccordingToPosition(int position){// Big O(1)
        if (position<=0 || position>top+1)
            throw new IndexOutOfBoundsException();

        return array[top-position+1];
    }

    public int stackBottom(){// Big O(1)
        if (top==-1)
            throw new NoSuchFieldError();

        return array[0];
    }

    public int stackTop(){// Big O(1)
        if (top==-1)
            throw new NoSuchFieldError();

        return array[top];
    }
}