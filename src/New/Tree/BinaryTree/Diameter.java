package DSAJAVA.Tree.BinaryTree;

public class Diameter<T> extends Height<T> {

    public int diameter(Node<T> root){//Big O(N^2) ---> this function can be optimized to liner time function
        if (root==null)
            return 0;
        int diaLeft=diameter(root.left);
        int diaRight=diameter(root.right);
        int diaRoot=heightOfTree(root.left)+heightOfTree(root.right)+1;


        //one line return --->
        //return Math.max(Math.max(diameter(root.left),diameter(root.right)),heightOfTree(root.left)+heightOfTree(root.right)+1);

        return Math.max(Math.max(diaLeft,diaRight),diaRoot);
    }

    public int height(){
        return heightOfTree(root);
    }



    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }

    public TreeInfo diameterOptimized(Node<T> root) {//Big O(n)
        if (root==null)
            return new TreeInfo(0,0);

        TreeInfo left=diameterOptimized(root.left);
        TreeInfo right=diameterOptimized(root.right);

        int myHeight=Math.max(left.height, right.height)+1;

        int diaLeft= left.diameter;
        int diaRight= right.diameter;
        int diaRoot=left.height+right.height+1;//diameter through root

        int myDiameter=Math.max(Math.max(diaLeft,diaRight),diaRoot);

        return new TreeInfo(myHeight,myDiameter);
    }

    public int diameterOptimized(){
        return diameterOptimized(root).diameter;
    }

    public static void main(String[] args) {
        Diameter<Integer> diameter=new Diameter<>();
        diameter.push(1);
        diameter.push(2);
        diameter.push(3);
        diameter.push(4);
        diameter.push(5);
        diameter.push(6);
        diameter.push(7);
        diameter.push(8);
        diameter.push(9);
        diameter.push(10);
        System.out.println(diameter.diameter(diameter.root));
        System.out.println(diameter.diameterOptimized());
    }
}