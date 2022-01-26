package cn.superstallion.ClassicalAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class JosephProblem implements Iterable<Integer> {
    public static void main(String[] args) {
        int n=10,k=1,m=2;
        JosephProblem josephProblem = new JosephProblem();
        ArrayList<Integer> indexList = josephProblem.begin(n, k, m);
        System.out.println(indexList);
    }

    private class Node {
        public Node(int element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        private int element;
        private Node next;
        private Node previous;
    }

    private class JosephProblemIterator implements Iterator<Integer> {
        private int temp = sum;
        private Node item = last;

        @Override
        public boolean hasNext() {
            return sum > 0;
        }

        @Override
        public Integer next() {
            temp--;
            Node nt = item;
            item = item.next;
            return nt.element;
        }

        public void setStart(Node node) {
            this.item = node;
        }
    }

    private Node first;
    private Node last;
    private int sum;

    public void put(int item) {
        if (first == null && last == null) {
            first = last = new Node(item, null, null);
        } else {
            Node temp = last;
            last = new Node(item, first, temp);
            temp.next = last;
            first.previous = last;
        }
        sum++;
    }

    public void remove(Integer index) {
        for (Node temp = last; ; temp = temp.next) {
            if (temp.element == index) {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                sum--;
                break;
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new JosephProblemIterator();
    }

    public ArrayList<Integer> begin(int n, int k, int m) {
        JosephProblemIterator iterator = (JosephProblemIterator) iterator();
        Integer index = null;
        Node startNode = null;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            put(i);
        }
        for (Node temp = last; ; temp = temp.next) {
            if (temp.element == k) {
                startNode = temp;
                iterator.setStart(startNode);
                break;
            }
        }
        while (true) {
            for (int i = 1; i <= m; i++) {
                index = iterator.next();
            }
            integers.add(index);
            remove(index);
            if (sum==0) {
                break;
            }
        }
        return integers;
    }
}
