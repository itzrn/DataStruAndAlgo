package src.Tree.BinaryTree.TreeWithGeneric;

public class T05_CountNumberOfNodes<T> {

    int count = 0;
    public void count(T01_Node<T> root){
        if (root == null)
            return;

        count++;
        count(root.left);
        count(root.right);
    }

    public int count02(T01_Node<T> root){// another way to do count the numbers of nodes
        if (root == null)
            return 0;

        return count02(root.left) + count02(root.right) + 1;
    }
    public static void main(String[] args) {
        T04_LevelOrderTreeBuilt<Integer> levelOrderTreeBuilt = new T04_LevelOrderTreeBuilt<>();
        T05_CountNumberOfNodes<Integer> countNumberOfNodes = new T05_CountNumberOfNodes<>();
        levelOrderTreeBuilt.push(1);
        levelOrderTreeBuilt.push(2);
        levelOrderTreeBuilt.push(3);
        levelOrderTreeBuilt.push(4);
        levelOrderTreeBuilt.push(null);
        levelOrderTreeBuilt.push(5);
        levelOrderTreeBuilt.push(null);
        countNumberOfNodes.count(levelOrderTreeBuilt.root);

        System.out.println(countNumberOfNodes.count);


        System.out.println(countNumberOfNodes.count02(levelOrderTreeBuilt.root));
    }
}
