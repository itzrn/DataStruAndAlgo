package src.Tree.BinaryTree.TreeWithGeneric;

public class T21_SumReplacement extends T04_LevelOrderTreeBuilt<Integer> {

    int sum;

    public void sum(T01_Node<Integer> root){
        if (root==null)
            return;

        sum=sum+root.data;
        sum(root.left);
        sum(root.right);
    }

    public void sumReplacement(T01_Node<Integer> root){
        if (root==null)
            return;

        sum=0;
        sum(root);
        root.data=sum;
        sumReplacement(root.left);
        sumReplacement(root.right);
    }

    public static void main(String[] args) {
        T21_SumReplacement sr=new T21_SumReplacement();
        sr.push(1);
        sr.push(2);
        sr.push(3);
        sr.push(4);
        sr.push(5);
        sr.push(6);
        sr.push(7);
        sr.sumReplacement(sr.root);
        T11_LevelOrderPrint<Integer> levelOrderPrint=new T11_LevelOrderPrint<>();
        levelOrderPrint.root=sr.root;
        levelOrderPrint.print();
    }
}
