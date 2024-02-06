package DSAJAVA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfAllDataAtKthLevel extends LevelOrderTreeBuild<Integer> {

    /**
    public int sum(int level){// My First Approach
        if (root==null)
            return 0;

        if (level==1)
            return root.data;

        Queue<Node<Integer>> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int sum=0;
        Node<Integer> temp;
        int i=1;
        while (i!=level) {
            temp = queue.remove();
            if (temp != null) {
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            } else {
                i++;
                queue.add(null);
            }
        }
        temp=queue.remove();

        while (temp!=null){
            sum=sum+ temp.data;
            temp=queue.remove();
        }

        return sum;
    }
     */

    public int summation(int level){
        if (level==1) {
            return root.data;
        }

        int sum=0;
        Queue<Node<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<Integer> temp;
        while (true){
            temp=queue.remove();
            if (temp==null){
                level=level-1;
                queue.add(null);
            }else {
                if (level==2){
                    while (temp!=null){
                        if (temp.left!=null)
                            sum=sum+temp.left.data;
                        if (temp.right!=null)
                            sum=sum+temp.right.data;
                        temp=queue.remove();
                    }
                    break;
                }
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfAllDataAtKthLevel sumOfAllDataAtKthLevel=new SumOfAllDataAtKthLevel();
        Integer[] data={1,2,3,4,8,5,7,null,null,11,12};
        for (Integer datum : data) {
            sumOfAllDataAtKthLevel.push(datum);
        }
        System.out.println(sumOfAllDataAtKthLevel.summation(3));
    }
}