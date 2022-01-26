package cn.superstallion.DataStructure;

public class CyclicDoublyLinkedList <T>{
    private class Node{
        private T val;
        private Node next;
        private Node prior;

        public Node() {
        }

        public Node(T val, Node next, Node prior) {
            this.val = val;
            this.next = next;
            this.prior = prior;
        }
    }

    private Node headPoint;

    public CyclicDoublyLinkedList() {
        headPoint=new Node();
        headPoint.prior=headPoint;
        headPoint.next=headPoint;
    }
}
