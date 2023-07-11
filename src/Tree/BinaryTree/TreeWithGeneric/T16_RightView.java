package src.Tree.BinaryTree.TreeWithGeneric;


import java.util.LinkedList;
import java.util.Queue;

public class T16_RightView<T> extends T04_LevelOrderTreeBuilt<T>{

    public void rightView(){
        if (root==null)
            return;

        Queue<T01_Node<T>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        T01_Node<T> temp;
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
        T16_RightView<Integer> rightView=new T16_RightView<>();
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
