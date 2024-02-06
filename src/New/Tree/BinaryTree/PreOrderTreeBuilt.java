package DSAJAVA.Tree.BinaryTree;

import java.util.Stack;

public class PreOrderTreeBuilt<T> {
    Node<T> root;
    Stack<Node<T>> stack;

    PreOrderTreeBuilt(){
        stack=new Stack<>();
    }

    public void push(T data){//iterative way
        Node<T> newNode=null;
        if (data!=null)
            newNode=new Node<>(data);
        if (root==null){
            root=newNode;
            stack.add(newNode);
            return;
        }

        if (stack.peek()!=null) {
            if (stack.peek().left == null && stack.peek().right != null)
                stack.pop();
            if (stack.peek().right != null && stack.peek().left != null)
                stack.pop();
        }

        if (stack.peek()==null) {
            stack.pop();
            stack.peek().right = newNode;
            if (newNode!=null) {
                stack.add(newNode);
                return;
            }
            else stack.pop();
            return;
        }

        if (stack.peek().left!=null && stack.peek().right==null){
            stack.peek().right=newNode;
            stack.add(newNode);
            return;
        }

        stack.peek().left=newNode;
        stack.add(newNode);
    }
}
