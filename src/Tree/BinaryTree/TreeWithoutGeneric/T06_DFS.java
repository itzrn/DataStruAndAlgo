package src.Tree.BinaryTree.TreeWithoutGeneric;

import java.util.Stack;

// this can be postorder, inorder or preorder --> which depends on which node first is getting out or in, in the stack(root.right,left)
public class T06_DFS extends T02_PreOrderTreeBuilt{
    public void dfsTraversal(T01_Node root){ // this going to give you the preorder sequence
        if(root == null){
            return;
        }
        Stack<T01_Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            T01_Node node = stack.pop();
            System.out.println(node.data);

            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }
    }

    public static void main(String[] args) {
        T06_DFS test = new T06_DFS();
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        test.dfsTraversal(test.pushRecursivelyUsingArray(array));
    }
}
