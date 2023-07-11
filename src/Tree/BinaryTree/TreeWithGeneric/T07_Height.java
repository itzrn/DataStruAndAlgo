package src.Tree.BinaryTree.TreeWithGeneric;


public class T07_Height<T> extends T04_LevelOrderTreeBuilt<T> {//search of iterative way

    public int heightOfTree(T01_Node<T> root){
        if (root==null)
            return 0;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
        //     Math.max(leftHeight,rightHeight) + 1;
    }

    public int heightOfTree(){
        return heightOfTree(root);
    }

    public static void main(String[] args) {
        T07_Height<Integer> height=new T07_Height<>();
        height.push(1);
        height.push(2);
        height.push(3);
        height.push(4);
        height.push(5);
        height.push(6);
        height.push(7);
        height.push(8);
        height.push(9);
        height.push(10);
        System.out.println(height.heightOfTree());

    }
}
