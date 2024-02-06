package src.Tree.BinarySearchTree;

/**
 * Time Complexity to search a node in Binary Tree is O(n).
 * Whereas Time Complexity in BST is O(h)(h -> height of the tree), sometimes we say log(n) to be time complexity mean BST is height balanced Tree
 *
 * Left subtree node < root
 * right subtree node > root
 * left and right subtree are also BST with no duplicates
 *
 * Inorder traversal of BST gives sorted sequence
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4 This type of tree is called skewed tree
 */

public class BST01 {
    BSTNode root;

    public BSTNode insert(BSTNode root, int data){
        if(root == null){
            root = new BSTNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else {
            root.right = insert(root.right,data);
        }
        return root;
    }
}
