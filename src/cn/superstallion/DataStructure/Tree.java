package cn.superstallion.DataStructure;

public class Tree<T>{

    class Node{
        private T val;
        private Node child;
        private Node sibling;
    }

    private Node root;
}
