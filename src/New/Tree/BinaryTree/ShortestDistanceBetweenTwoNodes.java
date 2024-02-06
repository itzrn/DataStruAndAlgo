package DSAJAVA.Tree.BinaryTree;

public class ShortestDistanceBetweenTwoNodes<T> extends LevelOrderTreeBuild<T>{

    public Node<T> LCARecursive(Node<T> root,T data1,T data2){
        if (root==null)
            return null;

        if (root.data==data1 || root.data==data2)
            return root;

        Node<T> left=LCARecursive(root.left, data1, data2);
        Node<T> right=LCARecursive(root.right, data1, data2);

        if (left!=null && right!=null)
            return root;
        if (right==null && left==null)
            return null;
        if (left!=null)
            return LCARecursive(root.left, data1, data2);
        return LCARecursive(root.right, data1, data2);
    }

    public int findDistance(Node<T> lca,T data,int k){
        if (lca==null)
            return -1;

        if (lca.data==data)
            return k;

        int left=findDistance(lca.left,data,k+1);
        if (left!=-1)
            return left;
        return findDistance(lca.right, data, k+1);
    }

    public int shortestDistance(T data1,T data2){
        Node<T> lca=LCARecursive(root,data1,data2);

        int distance1=findDistance(lca,data1,0);
        int distance2=findDistance(lca,data2,0);

        return distance1+distance2;
    }



    public static void main(String[] args) {
        ShortestDistanceBetweenTwoNodes<Integer> sr=new ShortestDistanceBetweenTwoNodes<>();
        sr.push(1);
        sr.push(2);
        sr.push(3);
        sr.push(4);
        sr.push(5);
        sr.push(6);
        sr.push(7);
        System.out.println(sr.shortestDistance(5,6));
    }
}
