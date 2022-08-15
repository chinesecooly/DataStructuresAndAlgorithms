package com.chinesecooly.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

public class solution_232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

}

class MyQueue {

    private Deque<Integer> stack1=new LinkedList<>();
    private Deque<Integer> stack2=new LinkedList<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int pop;
        if (stack2.isEmpty()){
            for (;!stack1.isEmpty();){
                stack2.push(stack1.pop());
            }
            pop= stack2.pop();
            for (;!stack2.isEmpty();){
                stack1.push(stack2.pop());
            }
        }else {
            pop= stack2.pop();
        }
        return pop;
    }

    public int peek() {
        int peek;
        if (stack2.isEmpty()){
            for (;!stack1.isEmpty();){
                stack2.push(stack1.pop());
            }
            peek= stack2.peek();
            for (;!stack2.isEmpty();){
                stack1.push(stack2.pop());
            }
        }else {
            peek= stack2.peek();
        }
        return peek;
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}