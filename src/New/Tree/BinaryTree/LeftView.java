package DSAJAVA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView<T> extends LevelOrderTreeBuild<T>{

    public void leftView(){
        if (root==null)
            return;

        Queue<Node<T>> queue=new LinkedList<>();
        queue.add(null);
        queue.add(root);

        Node<T> temp;
        while (!queue.isEmpty()){
            temp=queue.remove();
            if (temp==null){
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek().data);
                    queue.add(null);
                }
            }else {
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        LeftView<Integer> leftView=new LeftView<>();
        leftView.push(1);
        leftView.push(2);
        leftView.push(3);
        leftView.push(4);
        leftView.push(5);
        leftView.push(6);
        leftView.push(7);
        leftView.push(8);
        leftView.leftView();
    }
}
