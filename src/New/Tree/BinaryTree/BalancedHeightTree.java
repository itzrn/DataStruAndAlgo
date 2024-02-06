package DSAJAVA.Tree.BinaryTree;
/**
 * Balanced Height Tree
 * For Each Node, The Difference between the heights of the left subTree & right subTree <= 1
 */
public class BalancedHeightTree<T> extends LevelOrderTreeBuild<T>{

    public int heightOfTree(Node<T> root){
        if (root==null)
            return 0;

        return Math.max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
    }

    public boolean isBalanced(Node<T> root){
        if (root==null)
            return true;

        boolean leftBoolean=isBalanced(root.left);
        boolean rightBoolean=isBalanced(root.right);

        if (!leftBoolean)
            return false;
        if (!rightBoolean)
            return false;

        int leftHeight=heightOfTree(root.left);
        int rightHeight=heightOfTree(root.right);

        return (leftHeight - rightHeight) <= 1;
    }

    public static void main(String[] args) {
        BalancedHeightTree<Integer> balancedHeightTree=new BalancedHeightTree<>();
        balancedHeightTree.push(1);
        balancedHeightTree.push(2);
        balancedHeightTree.push(3);
        balancedHeightTree.push(4);
        balancedHeightTree.push(5);
        balancedHeightTree.push(6);
        balancedHeightTree.push(7);
        balancedHeightTree.push(8);
        System.out.println(balancedHeightTree.isBalanced(balancedHeightTree.root));
    }
}
