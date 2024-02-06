package DSAJAVA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView<T> extends LevelOrderTreeBuild<T>{

    public void rightView(){
        if (root==null)
            return;

        Queue<Node<T>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> temp;
        while (!queue.isEmpty()){
            temp=queue.remove();
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);

            if (queue.peek()==null){
                queue.remove();
                if (!queue.isEmpty())
                    queue.add(null);
                System.out.println(temp.data);
            }
        }
    }

    public static void main(String[] args) {
        RightView<Integer> rightView=new RightView<>();
        rightView.push(1);
        rightView.push(2);
        rightView.push(3);
        rightView.push(4);
        rightView.push(5);
        rightView.push(6);
        rightView.push(7);
        rightView.push(8);
        rightView.rightView();
    }
}