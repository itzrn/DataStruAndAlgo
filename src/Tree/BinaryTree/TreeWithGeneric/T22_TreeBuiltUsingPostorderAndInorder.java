package src.Tree.BinaryTree.TreeWithGeneric;

/**
 *Algorithm
 * Start from the end of postOrder & pick an element to create a node
 * Decrement postOrder index
 * Search for picked element's position in inOrder
 * Call to Build  right subtree from inOrder's Position+1 to n
 * call to Build left subtree from inorder 0 to position-1
 * return the node
 */
public class T22_TreeBuiltUsingPostorderAndInorder<T> {
    int index;

    T22_TreeBuiltUsingPostorderAndInorder(int index){
        this.index=index;
    }

    private int searchPosition(T[] inOrder,T currentData,int startIndex,int endIndex){
        for (int i=startIndex;i<=endIndex;i++){
            if (inOrder[i]==currentData)
                return i;
        }
        return -1;
    }

    public T01_Node<T> buildTree(T[] postOrder,T[] inOrder, int startIndex,int endIndex){
        if (startIndex>endIndex)
            return null;
        T currentData=postOrder[index];
        index--;
        T01_Node<T> newNode=new T01_Node<>(currentData);
        if (startIndex==endIndex)
            return newNode;
        int position=searchPosition(inOrder,currentData,startIndex,endIndex);
        newNode.right=buildTree(postOrder,inOrder,position+1,endIndex);
        newNode.left=buildTree(postOrder,inOrder,startIndex,position-1);

        return newNode;
    }

    public static void main(String[] args) {
        T22_TreeBuiltUsingPostorderAndInorder<Integer> tree=new T22_TreeBuiltUsingPostorderAndInorder<>(6);
        Integer[] postOrder={4,5,2,6,7,3,1};
        Integer[] inOrder={4,2,5,1,6,3,7};

        tree.buildTree(postOrder,inOrder,0,6);
    }
}
