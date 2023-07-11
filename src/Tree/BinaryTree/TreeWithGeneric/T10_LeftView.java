package src.Tree.BinaryTree.TreeWithGeneric;


import java.util.LinkedList;
import java.util.Queue;

public class T10_LeftView<T> extends T04_LevelOrderTreeBuilt<T>{

    public void leftView(){
        if (root==null)
            return;

        Queue<T01_Node<T>> queue=new LinkedList<>();
        queue.add(null);
        queue.add(root);

        T01_Node<T> temp;
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
        T10_LeftView<Integer> leftView=new T10_LeftView<>();
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
