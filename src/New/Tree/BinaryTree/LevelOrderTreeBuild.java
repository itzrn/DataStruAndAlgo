package DSAJAVA.Tree.BinaryTree;


import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class LevelOrderTreeBuild<T> {
    Node<T> root;
    Queue<Node<T>> queue;

    LevelOrderTreeBuild() {
        queue = new ArrayDeque<>();
    }

    int i=1;
    public void push(T data) {//This function is pushing data in level order
        Node<T> newNode = null;

        if (data!=null){
            newNode=new Node<>(data);
            queue.add(newNode);
        }

        if (root == null) {
            root = newNode;
            return;
        }
        if (!queue.isEmpty()) {
            if (i == 2) {
                queue.peek().right = newNode;
                queue.remove();
                i=1;
                return;
            }
            queue.peek().left = newNode;
            i=2;
        }else
            throw new EmptyStackException();
    }
}