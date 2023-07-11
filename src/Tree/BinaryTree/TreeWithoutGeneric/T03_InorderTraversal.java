package src.Tree.BinaryTree.TreeWithoutGeneric;

import java.util.Scanner;
//Inorder tree built is not possible, traversal is possible
// left root right
public class T03_InorderTraversal extends T02_PreOrderTreeBuilt{
    @Override
    public void print(T01_Node root){
        if (root == null){
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }

    public static void main(String[] args) {
        T03_InorderTraversal test = new T03_InorderTraversal();
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // this array is getting build in preorder tree
        test.print(test.pushRecursivelyUsingArray(array)); // printing is in inorder pattern
    }
}
