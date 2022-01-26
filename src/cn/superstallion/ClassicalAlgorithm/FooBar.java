package cn.superstallion.ClassicalAlgorithm;

import com.sun.xml.internal.ws.model.wsdl.WSDLBoundPortTypeImpl;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//1115. 交替打印FooBar
class FooBar {
    private int n;
    private boolean flag = false;

    public FooBar (int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag) {
                    wait();
                }
                printFoo.run();
                flag=true;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!flag) {
                    wait();
                }
                printBar.run();
                flag=false;
                notifyAll();
            }
        }
    }
}


