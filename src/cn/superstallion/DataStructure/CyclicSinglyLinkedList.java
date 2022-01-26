package cn.superstallion.DataStructure;

public class CyclicSinglyLinkedList<T> {
    private class Node{
        private T val;
        private Node next;

        public Node() {
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private  Node headPoint;

    public CyclicSinglyLinkedList() {
        headPoint=new Node();
        headPoint.next=headPoint;
    }
}
