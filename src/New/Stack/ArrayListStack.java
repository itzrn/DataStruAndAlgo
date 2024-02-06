package DSAJAVA.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> {//this uses inbuilt ArrayList
    ArrayList<T> list;
    ArrayListStack(){
        list=new ArrayList<>();
    }

    ArrayListStack(int initialCapacity){
        list=new ArrayList<>(initialCapacity);
    }

    public boolean isEmpty(){
        return list.size()==0;
    }

    public void push(T data){
        list.add(data);
    }

    public T pop(){
        if (isEmpty())
            throw new EmptyStackException();

        T top = list.get(list.size()-1);
        list.remove(list.size()-1);

        return top;
    }

    public T peek(int index){
        if (isEmpty())
            throw new EmptyStackException();
        else if (index>= list.size())
            throw new IndexOutOfBoundsException();

        return list.get(index-1);
    }

    public T getTop(){
        return list.get(list.size()-1);
    }

    public T getBottom(){
        return list.get(0);
    }

    public void print(){
        if (isEmpty())
            throw new EmptyStackException();

        System.out.print("Bottom--->");
        for (int i=0;i< list.size()-1;i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(list.get(list.size()-1)+"<--- Top");
    }
}
