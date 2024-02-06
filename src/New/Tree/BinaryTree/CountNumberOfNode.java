package DSAJAVA.Tree.BinaryTree;

import java.util.Stack;

public class CountNumberOfNode<T> extends LevelOrderTreeBuild<T> {//Big O(n)
    int c;
    public void totalNodeRecursive(Node<T> root){//
        if (root==null)
            return;

        c++;
        totalNodeRecursive(root.left);
        totalNodeRecursive(root.right);
    }
    
    public int countRecursive(){
        totalNodeRecursive(root);//this root is of Tree class
        return c;
    }

    /**
    public int totalNodeRecursive(BinaryTreeNode<T> root){
        if (root==null)
            return 0;

        return totalNodeRecursive(root.left) + totalNodeRecursive(root.right)+1;
    }

    public int countRecursive(){
        return totalNodeRecursive(root);
    }
     */
    
    public int totalNodeIterative(){//Big O(n)
        if (root==null)//this root is of Tree class
            return 0;
        int count=0;
        Stack<Node<T>> stack=new Stack<>();
        stack.push(root);
        Node<T> temp;
        while (!stack.empty()){
            count++;
            temp=stack.pop();
            if (temp.left!=null)
                stack.push(temp.left);
            if (temp.right!=null)
                stack.push(temp.right);
        }

        return count;
    }

    public static void main(String[] args) {
        CountNumberOfNode<Integer> countNumberOfNode=new CountNumberOfNode<>();
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        countNumberOfNode.push(1);
        System.out.println(countNumberOfNode.totalNodeIterative());
    }
}