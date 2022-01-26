package cn.superstallion.DataStructure;

public class ThreadBinaryTree<T> {
    class Node{
        private Node left;
        private Node right;
        private T value;
        //0为指向孩子,1为指向前驱或后继
        private boolean leftType;
        private boolean rightType;
    }
}
