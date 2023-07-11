package src.Tree.BinaryTree.TreeWithoutGeneric;
import java.util.Scanner;

// root left right

public class T02_PreOrderTreeBuilt {
    Scanner sc = new Scanner(System.in);

    int i = -1;
    public T01_Node pushRecursivelyUsingArray(int[] array){
        if(array[++i] == -1){
            return null;
        }

        T01_Node root = new T01_Node(array[i]);
        root.left = pushRecursivelyUsingArray(array);
        root.right = pushRecursivelyUsingArray(array);

        return root;
    }

    public void print(T01_Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    public T01_Node pushRecursivelyInputInstant(){
        System.out.print("Enter -> ");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }

        T01_Node root = new T01_Node(data);
        root.left = pushRecursivelyInputInstant();
        root.right = pushRecursivelyInputInstant();
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Using Array");
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        T02_PreOrderTreeBuilt test = new T02_PreOrderTreeBuilt();
        test.print(test.pushRecursivelyUsingArray(array));
        System.out.println("Taking Data Instantly");
        test.print(test.pushRecursivelyInputInstant());

    }
}
