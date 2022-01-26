package cn.superstallion.DataStructure;

public class Stack<T> {

    class Node{
        private T val;
        private Node next;

        public Node() {
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node top;
    private Node base;
    private int size;

    public Stack() {
        base=top=new Node();
    }

    //是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //栈的大小m,
    public int size(){
        return size;
    }

    //清空
    public void clear(){
        for (Node node=top;node!=null;){
            Node temp=node;
            node=temp.next;
            temp.next=null;
        }
        top=base;
        size=0;
    }

    //入栈
    public void push(T val){
        top=new Node(val, top);
        size++;
    }

    //出栈
    public T pop(){
        if (top==base){
            return null;
        }
        Node node=top;
        top=top.next;
        size--;
        return node.val;
    }

}


