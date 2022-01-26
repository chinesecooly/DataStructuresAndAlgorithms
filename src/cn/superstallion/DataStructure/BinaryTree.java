package cn.superstallion.DataStructure;

import java.util.*;
import java.util.Queue;

public class BinaryTree<T>{

    class Node {
        private T val;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(T val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Queue<T> queue) {
        root=preorderConstruct(queue);
    }

    public List<T> traversal(){
        ArrayList<T> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    public void copy(BinaryTree<T> tree){
        root=preorderCopy(tree.root);
    }

    public int depth(){
        return preorderDepth(root);
    }

    public int size(){
        return preorderSize(root);
    }

    public int leafSize(){
        return preorderLeafSize(root);
    }

    //前序遍历
    private void preorderTraversal(Node root,List<T> list){
        if (root==null){
            return;
        }else {
            list.add(root.val);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }

    //前序构造
    private Node preorderConstruct(Queue<T> queue){
        if (queue.isEmpty()||queue.peek()==null){
            queue.poll();
            return null;
        }else {
            Node node=new Node();
            node.val=queue.poll();
            node.left=preorderConstruct(queue);
            node.right=preorderConstruct(queue);
            return node;
        }
    }

    //前序深度
    private int preorderDepth(Node node){
        if (node==null){
            return 0;
        }else {
            int leftDepth,rightDepth=0;
            leftDepth=preorderDepth(node.left);
            rightDepth=preorderDepth(node.right);
            return Math.max(leftDepth+1, rightDepth+1);
        }
    }

    //前序节点数
    private int preorderSize(Node node){
        if (node==null){
            return 0;
        }else {
            return preorderSize(node.left)+preorderSize(node.right)+1;
        }
    }

    //前序复制
    private Node preorderCopy(Node node){
        if (node==null){
            return null;
        }else {
            Node newNode=new Node(node.val, null,null);
            newNode.left=preorderCopy(node.left);
            newNode.right=preorderCopy(node.right);
            return newNode;
        }
    }

    //前序叶子节点数
    private int preorderLeafSize(Node node){
        if (node==null){
            return 0;
        }
        if (node.left==null&&node.right==null){
            return 1;
        }else {
            return preorderLeafSize(node.left)+preorderLeafSize(node.right);
        }
    }

    //中序遍历
    private void inorderTraversal(Node root,List<T> list){
        if (root==null){
            return;
        }else {
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }

    //后序遍历
    private void postorderTraversal(Node root,List<T> list){
        if (root==null){
            return;
        }else {
            postorderTraversal(root.left,list);
            postorderTraversal(root.right,list);
            list.add(root.val);
        }
    }

    //层序遍历
    private void levelOrderTraversal(Node root,List<T> list){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        for (;!queue.isEmpty();){
            Node node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list,1, 2, 4, null, null, 5, null, null, 3, 6, null, null);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);
        System.out.println(binaryTree.traversal());
        System.out.println(binaryTree.leafSize());
    }

}
