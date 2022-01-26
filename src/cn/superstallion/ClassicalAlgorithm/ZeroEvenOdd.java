package cn.superstallion.ClassicalAlgorithm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

//1116. 打印零与奇偶数
class ZeroEvenOdd {

    private int n;
    private int now = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Thread zero;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        zero = Thread.currentThread();
        int temp = 0;
        while (temp < n) {
            LockSupport.park(this);
            printNumber.accept(0);
            temp++;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int temp = 2;
        while (temp <= n) {
            try {
                lock.lock();
                while (now != 2) {
                    condition.await();
                }
                now = 1;
                LockSupport.unpark(zero);
                while (LockSupport.getBlocker(zero) != null) {

                }
                printNumber.accept(temp);
                temp += 2;
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int temp = 1;
        while (temp <= n) {
            try {
                lock.lock();
                while (now != 1) {
                    condition.await();
                }
                now = 2;
                LockSupport.unpark(zero);
                while (LockSupport.getBlocker(zero) != null) {

                }
                printNumber.accept(temp);
                temp += 2;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
//        new Thread(()->{
//            try {
//                zeroEvenOdd.zero(System.out::print);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(()->{
//            try {
//                zeroEvenOdd.even(System.out::print);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(()->{
//            try {
//                zeroEvenOdd.odd(System.out::print);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        Thread thread = new Thread(() -> {
            LockSupport.park(Thread.currentThread());
            while (true) {
            }
        });
        thread.start();
        thread.join(2);
        System.out.println(LockSupport.getBlocker(thread));
        LockSupport.unpark(thread);
        System.out.println(LockSupport.getBlocker(thread));
    }
}
