package com.codersdesks;

public class AvoidRaceConditionWithVolatile {
    public static void main(String[] args) throws InterruptedException {
        var counterObj = new MyCounterWithVolatile();
        var t1 = new Thread(counterObj,"Thread 1");
        var t2 = new Thread(counterObj, "Thread 2");
        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println("latest value of count is "+counterObj.getCount());
    }
}
class MyCounterWithVolatile implements Runnable{
    private volatile int count = 0;
    public void run(){
        incrementCount();
    }
     synchronized void incrementCount(){
        for(int i =0 ; i < 10000; i++) {
            this.count +=1;
        }
        System.out.println(Thread.currentThread().getName()+" count increment to "+this.count);
    }
    public int getCount() {
        return this.count;
    }
}
