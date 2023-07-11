package src.Tree.BinaryTree.TreeWithGeneric;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class T04_LevelOrderTreeBuilt<T> {
    T01_Node<T> root;
    Queue<T01_Node<T>> queue;

    T04_LevelOrderTreeBuilt() {
        queue = new ArrayDeque<>();
    }

    int i=1;
    public void push(T data) {//This function is pushing data in level order
        T01_Node<T> newNode = null;

        if (data!=null){
            newNode=new T01_Node<>(data);
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
