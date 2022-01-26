package cn.superstallion.ClassicalAlgorithm;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

//1117. H2O 生成
public class H2O {

    private final BlockingQueue<Thread> hydrogen=new SynchronousQueue<>();

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.put(Thread.currentThread());
        LockSupport.park();
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        Thread thread1 = hydrogen.take();
        Thread thread2 = hydrogen.take();
        LockSupport.unpark(thread1);
        LockSupport.unpark(thread2);
        releaseOxygen.run();
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    h2O.hydrogen(() -> {
                        System.out.print("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    h2O.oxygen(() -> {
                        System.out.print("O");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
