package DSAJAVA.Tree.BinaryTree;

public class SumReplacement extends LevelOrderTreeBuild<Integer> {

    int sum;

    public void sum(Node<Integer> root){
        if (root==null)
            return;

        sum=sum+root.data;
        sum(root.left);
        sum(root.right);
    }

    public void sumReplacement(Node<Integer> root){
        if (root==null)
            return;

        sum=0;
        sum(root);
        root.data=sum;
        sumReplacement(root.left);
        sumReplacement(root.right);
    }

    public static void main(String[] args) {
        SumReplacement sr=new SumReplacement();
        sr.push(1);
        sr.push(2);
        sr.push(3);
        sr.push(4);
        sr.push(5);
        sr.push(6);
        sr.push(7);
        sr.sumReplacement(sr.root);
        LevelOrderPrint<Integer> levelOrderPrint=new LevelOrderPrint<>();
        levelOrderPrint.root=sr.root;
        levelOrderPrint.print();
    }
}
