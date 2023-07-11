package src.Tree.BinaryTree.TreeWithGeneric;

import java.util.Stack;

public class T02_PreorderTreeBuilt<T> {
    T01_Node<T> root;
    Stack<T01_Node<T>> stack;

    T02_PreorderTreeBuilt(){
        stack=new Stack<>();
    }

    public void push(T data){//iterative way
        T01_Node<T> newNode=null;
        if (data!=null)
            newNode=new T01_Node<>(data);
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

    int i = -1;
    public T01_Node<T> pushRecursively(T[] dataArray){
        i++;
        if (dataArray[i] == null)
            return null;

        T01_Node<T> root = new T01_Node<>(dataArray[i]);

        root.left = pushRecursively(dataArray);
        root.right = pushRecursively(dataArray);

        return root;
    }

    public void print(T01_Node<T> root){
        if (root == null)
            return;

        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        T02_PreorderTreeBuilt<Integer> t02PreOrderTreeBuilt = new T02_PreorderTreeBuilt<>();
        Integer[]dataArray = {2,3,null,null,6,null,null};
        T01_Node<Integer> root = t02PreOrderTreeBuilt.pushRecursively(dataArray);
        t02PreOrderTreeBuilt.print(root);
    }

}
