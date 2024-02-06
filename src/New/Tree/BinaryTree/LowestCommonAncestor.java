package DSAJAVA.Tree.BinaryTree;

import java.util.Stack;

public class LowestCommonAncestor<T> extends LevelOrderTreeBuild<T>{


    public boolean getPath(Stack<Node<T>> stack, T data, Node<T> root){
        if (root==null)
            return false;

        stack.push(root);
        if (root.data==data)
            return true;

        if (getPath(stack,data,root.left) || getPath(stack,data,root.right))
            return true;

        stack.pop();
        return false;
    }

    public Node<T> LCA(Node<T> root,T data1,T data2){
        Stack<Node<T>> stack1=new Stack<>();
        Stack<Node<T>> stack2=new Stack<>();

        if (!getPath(stack1, data1, root) || !getPath(stack2, data2, root))
            return null;
        Node<T> temp=null;
        for (int i=0;i<stack1.size();i++){
            if (stack1.get(i+1)!=stack2.get(i+1)){
                temp=stack1.get(i);
                break;
            }
        }
        return temp;
    }

    public Node<T> LCARecursive(Node<T> root,T data1,T data2){
        if (root==null)
            return null;

        if (root.data==data1 || root.data==data2)
            return root;

        Node<T> left=LCARecursive(root.left, data1, data2);
        Node<T> right=LCARecursive(root.right, data1, data2);

        if (left!=null && right!=null)
            return root;
        if (right==null && left==null)
            return null;
        if (left!=null)
            return LCARecursive(root.left, data1, data2);
        return LCARecursive(root.right, data1, data2);
    }

    public static void main(String[] args) {
        LowestCommonAncestor<Integer> lcd=new LowestCommonAncestor<>();
        lcd.push(1);
        lcd.push(2);
        lcd.push(3);
        lcd.push(4);
        lcd.push(5);
        lcd.push(6);
        lcd.push(7);
        System.out.println(lcd.LCA(lcd.root,4,7).data);
    }
}
