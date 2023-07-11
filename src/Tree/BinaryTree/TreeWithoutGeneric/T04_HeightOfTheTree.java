package src.Tree.BinaryTree.TreeWithoutGeneric;

public class T04_HeightOfTheTree extends T02_PreOrderTreeBuilt{
    public int heightOfTree(T01_Node root){
        if(root == null)
            return 0;

        return 1 + Math.max(heightOfTree(root.left) , heightOfTree(root.right));
    }

    public static void main(String[] args) {
        T04_HeightOfTheTree test = new T04_HeightOfTheTree();
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        System.out.println(test.heightOfTree(test.pushRecursivelyUsingArray(array)));
    }
}
