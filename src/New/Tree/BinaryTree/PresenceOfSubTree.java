package DSAJAVA.Tree.BinaryTree;

public class PresenceOfSubTree<T> extends LevelOrderTreeBuild<T> {

    public boolean isIdentical(Node<T> root, Node<T> subRoot){
        if (root==null && subRoot==null)
            return true;
        if (root==null || subRoot==null)
            return false;

        if (root.data!= subRoot.data)
            return false;

        return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
    }

    public boolean isSubTree(Node<T> root, Node<T> subRoot){
        if (subRoot==null)
            return true;
        if (root==null)
            return false;
        if (root.data== subRoot.data)
            return isIdentical(root, subRoot);

        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
    }
}