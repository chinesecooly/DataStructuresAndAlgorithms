package cn.superstallion.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>,V> {

    class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(K key, V val, Node left, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public V search(K key){
        Node search = search(root, key);
        return search==null?null:search.val;
    }

    public void insert(K key,V val){
        root=insert(root,key,val);
    }

    //todo
    public boolean remove(K key){
        Node search = search(root, key);
        if (search==null){
            return false;
        }else if (search.left==null&&search.right==null){

        }
        return false;
    }

    public List<V> traversal(){
        ArrayList<V> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    //查找
    private Node search(Node node, K key){
        if (node==null||key.compareTo(node.key)==0){
            return node;
        }else if (key.compareTo(node.key)<0){
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }

    //插入
    private Node insert(Node node,K key,V val){
        if (node==null){
            node=new Node(key,val,null,null);
        }else {
            if (key.compareTo(node.key)<0){
                node.left=insert(node.left,key,val);
            }else if (key.compareTo(node.key)==0){
                node.val=val;
            }else {
                node.right=insert(node.right,key,val);
            }
        }
        return node;
    }

    //中序遍历
    private void inorderTraversal(Node root, List<V> list){
        if (root==null){
            return;
        }else {
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }

    public static void main(String[] args) {
        int[] ints = {45, 24, 53, 45, 12, 24, 90};
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        for (int anInt : ints) {
            tree.insert(anInt, anInt);
        }
        System.out.println(tree.traversal());
        System.out.println(tree.search(10));
    }
}
