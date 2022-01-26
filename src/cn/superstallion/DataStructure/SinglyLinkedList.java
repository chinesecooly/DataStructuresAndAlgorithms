package cn.superstallion.DataStructure;

import java.lang.reflect.Modifier;

public class SinglyLinkedList<T>{

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

    private Node headPoint;

    //构造单链表,将头指针指向头节点
    public SinglyLinkedList() {
        headPoint=new Node();
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return headPoint.next == null;
    }

    //清空单链表
    public void clear(){
        Node node=headPoint.next;
        for (headPoint.next=null;node!=null;){
            Node temp=node;
            node=node.next;
            temp.next=null;
        }
    }

    //链表长度
    public int size(){
        int sum=0;
        for (Node node=headPoint.next;node!=null;node=node.next){
            sum++;
        }
        return sum;
    }

    //取第i个元素
    public T get(int index){
        int sum=0;
        for (Node node=headPoint.next;node!=null;node=node.next,sum++){
            if (sum==index){
                return node.val;
            }
        }
        return null;
    }

    //判断是否存在
    public boolean contains(T val){
        for (Node node=headPoint.next;node!=null;node=node.next){
            if (node.val.equals(val)){
                return true;
            }
        }
        return false;
    }

    //插入元素
    public void insert(T val,int index){
        int sum=-1;
        for (Node node=headPoint;node!=null;node=node.next,sum++){
            if (sum==index-1){
                Node temp=node.next;
                node.next=new Node(val,temp);
            }
        }
    }

    //删除元素
    public void remove(int index){
        int sum=-1;
        for (Node node=headPoint;node!=null;node=node.next,sum++){
            if (sum==index-1){
                node.next=node.next.next;
            }
        }
    }

    //头插法
    public void add(T val){
        insert(val,0);
    }

    //尾插法就是再用一个尾指针执行最后一个节点,然后插入该节点后
}
