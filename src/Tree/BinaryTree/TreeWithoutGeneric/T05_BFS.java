package src.Tree.BinaryTree.TreeWithoutGeneric;
// this is a level-order traversal
import java.util.LinkedList;
import java.util.Queue;

public class T05_BFS extends T02_PreOrderTreeBuilt{
    public void bfsTraversal(T01_Node root){
        if(root == null){
            return;
        }
        Queue<T01_Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            T01_Node node = queue.remove();
            System.out.println(node.data);

            if(node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        T05_BFS test = new T05_BFS();
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        test.bfsTraversal(test.pushRecursivelyUsingArray(array));
    }
}
