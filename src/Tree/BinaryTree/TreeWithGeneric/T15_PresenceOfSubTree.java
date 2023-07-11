package src.Tree.BinaryTree.TreeWithGeneric;

public class T15_PresenceOfSubTree<T> extends T04_LevelOrderTreeBuilt<T> {

    public boolean isIdentical(T01_Node<T> root, T01_Node<T> subRoot){
        if (root==null && subRoot==null)
            return true;
        if (root==null || subRoot==null)
            return false;

        if (root.data!= subRoot.data)
            return false;

        return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
    }

    public boolean isSubTree(T01_Node<T> root, T01_Node<T> subRoot){
        if (subRoot==null)
            return true;
        if (root==null)
            return false;
        if (root.data== subRoot.data)
            return isIdentical(root, subRoot);

        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
    }
}
