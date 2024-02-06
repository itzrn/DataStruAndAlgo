package DSAJAVA.Tree.BinaryTree;

/**
 *Algorithm
 * pick element from preorder & create node
 * Increment preorder index
 * search the picked element's pos in inorder
 * call to build left subtree from in order's 0 tto pos-1
 * call to build right subtree from inorder pos+1 to n
 * return the node
 */
public class TreeBuildUsingPreorderAndInorder<T> {
    int index;
    Node<T> root;

    TreeBuildUsingPreorderAndInorder(){
        index=0;
    }
    public int searchPosition(T[] inOrder, int startIndex, int endIndex, T current){
        for (int i=startIndex;i<=endIndex;i++){
            if (inOrder[i]==current)
                return i;
        }
        return -1;
    }

    public Node<T> buildTreeRecursive(T[] preOrder, T[] inOrder, int startIndex, int endIndex){
        if (startIndex>endIndex)
            return null;

        T currentData=preOrder[index];
        index++;
        Node<T> newNode=new Node<>(currentData);
        if (startIndex==endIndex)
            return newNode;
        int position= searchPosition(inOrder,startIndex,endIndex,currentData);
        newNode.left= buildTreeRecursive(preOrder,inOrder,startIndex,position-1);
        newNode.right= buildTreeRecursive(preOrder,inOrder,position+1,endIndex);

        return newNode;
    }

    public void builtTree(T[] preOrder,T[] inOrder,int startIndex,int endIndex){
        root=buildTreeRecursive(preOrder,inOrder,startIndex,endIndex);
    }



    public static void main(String[] args) {
        TreeBuildUsingPreorderAndInorder<Integer> tree=new TreeBuildUsingPreorderAndInorder<>();
        Integer[] preOrder={1,2,4,5,3,6,7};
        Integer[] inOrder={4,2,5,1,6,3,7};
        tree.builtTree(preOrder,inOrder,0,6);
    }
}
