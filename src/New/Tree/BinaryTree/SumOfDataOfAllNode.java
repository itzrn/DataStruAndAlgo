package DSAJAVA.Tree.BinaryTree;

import java.util.Stack;

public class SumOfDataOfAllNode extends LevelOrderTreeBuild<Integer> {

    public Integer sumRecursive(Node<Integer> root){
        if (root==null)
            return 0;
        return sumRecursive(root.left) + sumRecursive(root.right) + root.data;
    }

    public Integer sumIterative(){
        if (root==null)//this root is of Tree class
            return 0;

        int sum=0;
        Stack<Node<Integer>> stack=new Stack<>();
        stack.push(root);
        Node<Integer> temp;
        while (!stack.empty()){
            temp=stack.pop();
            sum=sum+ temp.data;
            if (temp.left!=null)
                stack.push(temp.left);
            if (temp.right!=null)
                stack.push(temp.right);
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfDataOfAllNode sum=new SumOfDataOfAllNode();
        sum.push(1);
        sum.push(2);
        sum.push(3);
        sum.push(4);
        sum.push(5);
        sum.push(6);
        sum.push(7);
        sum.push(8);
        System.out.println(sum.sumRecursive(sum.root));
    }
}