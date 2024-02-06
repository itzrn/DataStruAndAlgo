package DSAJAVA.Tree.BinaryTree;

/**
 * Given a binary tree, flatten it into linked list in place.
 * After flatting, left of each node should point to null and right should contain
 * next node in preorder sequence.
 * (it's not allowed to use other data structure)
 *
 * Strategy -->
 * 1- Recursively, flatten the left & right SubTree
 * 2- Store the left tail and right tail
 * 3- store right subtree in 'temp' & make left subtree as right subtree
 * 4- join right subtree with left tail
 * 5- return right tail
 */
public class FlattenABinaryTreeInPreorder<T> extends LevelOrderTreeBuild<T>{

    public Node<T> flatten(Node<T> root){//My First Approach
        if (root==null)
            return null;

        Node<T> rightNode=root.right;//saving every right subTree
        root.right=flatten(root.left);
        root.left=null;

        Node<T> t=root;
        while (t.right!=null){//reaching to end node of flattened left SubTree to connect the right subTree
            t=t.right;
        }

        t.right=flatten(rightNode);
        return root;
    }

    public void flatteningBinaryTree(Node<T> root){//given above strategy is for this method
        if (root==null || (root.left==null && root.right==null))
            return;
        if (root.left!=null){
            flatteningBinaryTree(root.left);

            Node<T> temp=root.right;
            root.right=root.left;
            root.left=null;

            Node<T> t=root.right;
            while (t.right!=null)
                t=t.right;

            t.right=temp;
        }

        flatteningBinaryTree(root.right);
    }


    public static void main(String[] args) {
        FlattenABinaryTreeInPreorder<Integer> flattenABinaryTree=new FlattenABinaryTreeInPreorder<>();
        flattenABinaryTree.push(1);
        flattenABinaryTree.push(2);
        flattenABinaryTree.push(3);
        flattenABinaryTree.push(4);
        flattenABinaryTree.push(5);
        flattenABinaryTree.push(null);
        flattenABinaryTree.push(7);
        flattenABinaryTree.flatteningBinaryTree(flattenABinaryTree.root);

        while (flattenABinaryTree.root!=null){
            System.out.println(flattenABinaryTree.root.data);
            flattenABinaryTree.root=flattenABinaryTree.root.right;
        }
    }
}
