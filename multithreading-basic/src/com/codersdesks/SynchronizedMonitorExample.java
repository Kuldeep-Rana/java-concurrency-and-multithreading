package com.codersdesks;

public class SynchronizedMonitorExample {
    public static void main(String[] args) {
        var sme = new SynchronizedWithMonitor() ;
        var t1  = new Thread(sme,  "Thread 1");
        var t2  = new Thread(sme, "Thread 2");
        t1.start();
        t2.start();
    }
}

class SynchronizedWithMonitor implements Runnable{
    private Object monitor = new Object();
    private int count = 0;
    public void increment() {
        synchronized (monitor) {
            for(int i=0; i< 1000; i++) {
                this.count++;
            }
            System.out.println(Thread.currentThread().getName() +" count value is "+this.count);
        }
    }

    @Override
    public void run() {
        increment();
    }
}
