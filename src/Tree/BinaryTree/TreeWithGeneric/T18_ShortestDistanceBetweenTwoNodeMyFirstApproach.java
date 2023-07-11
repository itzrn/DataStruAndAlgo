package src.Tree.BinaryTree.TreeWithGeneric;


import java.util.Stack;

public class T18_ShortestDistanceBetweenTwoNodeMyFirstApproach<T> extends T04_LevelOrderTreeBuilt<T>{
    Stack<T01_Node<T>> stack1;
    Stack<T01_Node<T>> stack2;

    public boolean getPath(T01_Node<T> root, T data, Stack<T01_Node<T>> stack){
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

    public int shortestDistanceBetweenTwoNode(T01_Node<T> root,T data1,T data2){
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
        T18_ShortestDistanceBetweenTwoNodeMyFirstApproach<Integer> sdbtn=new T18_ShortestDistanceBetweenTwoNodeMyFirstApproach<>();
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
