package com.codersdesks;

public class SharedMonitorExample {
    public static void main(String[] args) {
        Object o = new Object();
        var monitor1 = new SharedMonitor(o);
        var monitor2 = new SharedMonitor(o);

        monitor1.increment();
        monitor2.increment();
    }
}
class SharedMonitor {
    private Object monitor;
    private int count = 0;
    public SharedMonitor(Object o){
        this.monitor = o;
    }

    public void increment() {
        synchronized (this.monitor) {
            for(int i=0; i< 10000; i++) {
                this.count++;
            }
            System.out.println(Thread.currentThread().getName() +" count value is "+this.count);
        }
    }
}