package cn.superstallion.DataStructure;

public class Queue<T> {
    private Object [] base;
    private int front;
    private int rear;
    private int length;

    public Queue() {
        length=12;
        base= new Object[length];
        front=0;
        rear=0;
    }

    public Queue(int length) {
        this.length = length;
        base= new Object[length];
        front=0;
        rear=0;
    }

    //队列长度
    public int size(){
        return (rear-front+length)%length;
    }

    //队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //入队
    public void enQueue(T val){
        if ((rear+1)%length==front){
            return;
        }
        base[rear]=val;
        rear=(rear+1)%length;
    }

    //出队
    public void deQueue(){
        if (isEmpty()){
            return;
        }
        front=(front+1)%length;
    }

    //取队头元素
    public T peek(){
        if (isEmpty()){
            return null;
        }
        return (T)base[front];
    }

}


