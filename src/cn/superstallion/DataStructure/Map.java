package cn.superstallion.DataStructure;

import java.util.*;
import java.util.Queue;

public class Map<T> {

//    private Object[] nodes;
//    private int[][] sides;
//    private int nodeNum;
//    private int sideNum;
//
//    public Map(int nodeNum, int sideNum,T[] nodes) {
//        this.nodeNum = nodeNum;
//        this.sideNum = sideNum;
//        this.nodes=nodes;
//        this.sides=new int[nodeNum][nodeNum];
//    }
//
//    //设置边,1表示有边,0表示没边
//    public void setSide(T node1,T node2){
//        int index1=-1,index2=-1;
//        for (int i = 0; i < nodes.length; i++) {
//            if (nodes[i]==node1){
//                index1=i;
//            }
//            if (nodes[i]==node2){
//                index2=i;
//            }
//            if (index1!=-1&&index2!=-1){
//                break;
//            }
//        }
//        sides[index1][index2]=1;
//    }

    class Node<U> {
        private U val;
        private Node<Integer> next;

        public Node() {
        }

        public Node(U val, Node<Integer> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T>[] nodes;
    private int nodeNum;
    private int sideNum;

    public Map(int nodeNum, int sideNum, T[] nodes) {
        this.nodeNum = nodeNum;
        this.sideNum = sideNum;
        this.nodes = new Node[nodeNum];
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i] = new Node<>(nodes[i], null);
        }
    }

    public void setSide(T node1, T node2) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].val == node1) {
                index1 = i;
            }
            if (nodes[i].val == node2) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                break;
            }
        }
        Node<Integer> temp = nodes[index1].next;
        nodes[index1].next = new Node<>(index2, temp);
    }

    public HashSet<T> traversal(T val){
        HashSet<T> set = new HashSet<>();
        for (Node<T> node:nodes){
            if (node.val==val){
                BFS(node,set);
                break;
            }
        }
        return set;
    }

    private void DFS(Node<T> node,HashSet<T> isVisited){
        isVisited.add(node.val);
        for (Node<Integer> side=node.next;side!=null;side=side.next){
            if (!isVisited.contains(nodes[side.val].val)){
                isVisited.add(nodes[side.val].val);
                DFS(nodes[side.val],isVisited);
            }
        }
    }

    private void BFS(Node<T> node,HashSet<T> isVisited){
        isVisited.add(node.val);
        Queue<Node<T>>queue = new LinkedList<>();
        queue.offer(node);
        isVisited.add(node.val);
        for (;!queue.isEmpty();){
            Node<T> temp = queue.poll();
            for (Node<Integer> side=temp.next;side!=null;side=side.next){
                if (!isVisited.contains(nodes[side.val].val)){
                    queue.offer(nodes[side.val]);
                    isVisited.add(nodes[side.val].val);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }

    public static void main(String[] args) {
        Map<Integer> map = new Map<>(6, 6, new Integer[]{1, 2, 3, 4, 5, 6});
        map.setSide(1,2);
        map.setSide(1,3);
        map.setSide(1,4);
        map.setSide(2,5);
        map.setSide(2,1);
        map.setSide(3,5);
        map.setSide(3,1);
        map.setSide(4,6);
        map.setSide(4,1);
        map.setSide(5,2);
        map.setSide(5,3);
        map.setSide(6,4);
        System.out.println(map.traversal(6));
    }
}
