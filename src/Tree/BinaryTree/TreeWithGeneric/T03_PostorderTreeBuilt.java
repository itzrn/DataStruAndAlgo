package src.Tree.BinaryTree.TreeWithGeneric;

import java.util.Scanner;

public class T03_PostorderTreeBuilt<T> {// Tree is created in a preorder traversal but data is
    // filled in postorder traversal

    Scanner sc = new Scanner(System.in);

    int i = -1;
    T tempData = null;
    public T01_Node<T> pushRecursively(T[] dataArray){

        int n = sc.nextInt();
        T01_Node<T> root = new T01_Node<>(tempData);
        if (n == 0)
            return null;

        if (n == 1){
            root.left = pushRecursively(dataArray);
        }
        root.right = pushRecursively(dataArray);
        i++;
        root.data=dataArray[i];

        return root;
    }

    public void print(T01_Node<T> root){
        if (root == null)
            return;

        print(root.left);
        print(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        T03_PostorderTreeBuilt<Integer> t03PostOrderTreeBuilt = new T03_PostorderTreeBuilt<>();
        Integer [] arrayData = {5, 7, 3, 8, 2};
        T01_Node<Integer> root = t03PostOrderTreeBuilt.pushRecursively(arrayData);
        t03PostOrderTreeBuilt.print(root);
    }
}
