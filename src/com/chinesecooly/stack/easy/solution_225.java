package com.chinesecooly.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class solution_225 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }


}

class MyStack{

    private Queue<Integer> queue1=new LinkedList<Integer>();
    private Queue<Integer> queue2=new LinkedList<Integer>();

    public MyStack() {

    }

    public void push(int x) {
        if (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        queue2.offer(x);
    }

    public int pop() {
        if (queue2.isEmpty()){
            for (int i = 0; i < queue1.size()-1; i++) {
                queue1.offer(queue1.poll());
            }
            queue2.offer(queue1.poll());
        }
        Integer peek = queue2.peek();
        queue2.poll();
        return peek;
    }

    public int top() {
        if (queue2.isEmpty()){
            for (int i = 0; i < queue1.size()-1; i++) {
                queue1.offer(queue1.poll());
            }
            queue2.offer(queue1.poll());
        }
        return queue2.peek();
    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
