package DSAJAVA.Tree.BinaryTree;

import java.util.Stack;

public class ShortestDistanceBetweenTwoNodesMyFirstApproach<T> extends LevelOrderTreeBuild<T>{
    Stack<Node<T>> stack1;
    Stack<Node<T>> stack2;

    public boolean getPath(Node<T> root, T data, Stack<Node<T>> stack){
        if (root==null)
            return false;
        stack.add(root);
        if (root.data==data)
            return true;

        if (getPath(root.left,data,stack) || getPath(root.right, data, stack))
            return true;

        stack.pop();
        return false;
    }

    public int shortestDistanceBetweenTwoNode(Node<T> root,T data1,T data2){
        stack1=new Stack<>();
        stack2=new Stack<>();

        if (!getPath(root,data1,stack1) || !getPath(root,data2,stack2))
            return -1;

        for (int i=0;i<stack1.size();i++){
            stack1.pop();
            stack2.pop();
            if (stack1.get(i+1)!=stack2.get(i+1)){
                break;
            }
        }
        return stack1.size()+stack2.size();
    }

    public static void main(String[] args) {
        ShortestDistanceBetweenTwoNodesMyFirstApproach<Integer> sdbtn=new ShortestDistanceBetweenTwoNodesMyFirstApproach<>();
        sdbtn.push(1);
        sdbtn.push(2);
        sdbtn.push(3);
        sdbtn.push(4);
        sdbtn.push(5);
        sdbtn.push(6);
        sdbtn.push(7);
        System.out.println(sdbtn.shortestDistanceBetweenTwoNode(sdbtn.root,5,6));
    }

}
