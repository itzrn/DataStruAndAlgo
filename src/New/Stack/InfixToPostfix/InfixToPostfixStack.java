package DSAJAVA.Stack.InfixToPostfix;

import java.util.EmptyStackException;

public class InfixToPostfixStack {
    static class Node{
        char operator;
        int precedence;
        Node next;
        Node(char operator,int precedence){
            this.operator=operator;
            this.precedence=precedence;
            this.next=null;
        }
    }
    Node head;

    public boolean isEmpty(){
        return head==null;
    }

    public void push(char operator,int precedence){
        Node newNode=new Node(operator, precedence);
        if (head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void pop(){
        if (head==null)
            throw new EmptyStackException();

        head=head.next;
    }

    public int topPrecedence(){
        return head.precedence;
    }

    public char topOperator(){
        return head.operator;
    }
}
