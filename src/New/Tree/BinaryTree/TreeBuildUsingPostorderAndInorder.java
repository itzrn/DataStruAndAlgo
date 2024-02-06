package DSAJAVA.Tree.BinaryTree;

/**
 *Algorithm
 * Start from the end of postOrder & pick an element to create a node
 * Decrement postOrder index
 * Search for picked element's position in inOrder
 * Call to Build  right subtree from inOrder's Position+1 to n
 * call to Build left subtree from inorder 0 to position-1
 * return the node
 */
public class TreeBuildUsingPostorderAndInorder<T> {
    int index;

    TreeBuildUsingPostorderAndInorder(int index){
        this.index=index;
    }

    private int searchPosition(T[] inOrder,T currentData,int startIndex,int endIndex){
        for (int i=startIndex;i<=endIndex;i++){
            if (inOrder[i]==currentData)
                return i;
        }
        return -1;
    }

    public Node<T> buildTree(T[] postOrder,T[] inOrder, int startIndex,int endIndex){
        if (startIndex>endIndex)
            return null;
        T currentData=postOrder[index];
        index--;
        Node<T> newNode=new Node<>(currentData);
        if (startIndex==endIndex)
            return newNode;
        int position=searchPosition(inOrder,currentData,startIndex,endIndex);
        newNode.right=buildTree(postOrder,inOrder,position+1,endIndex);
        newNode.left=buildTree(postOrder,inOrder,startIndex,position-1);

        return newNode;
    }

    public static void main(String[] args) {
        TreeBuildUsingPostorderAndInorder<Integer> tree=new TreeBuildUsingPostorderAndInorder<>(6);
        Integer[] postOrder={4,5,2,6,7,3,1};
        Integer[] inOrder={4,2,5,1,6,3,7};

        tree.buildTree(postOrder,inOrder,0,6);
    }
}
