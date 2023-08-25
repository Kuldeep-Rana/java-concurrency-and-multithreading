package com.codersdesks;
/**
 * In this example you will see, the counter is incremented by two threads but there is no guarantee that it will be incremented correctly. you may see following output or something similar to this where the count values is not as we expected.
 * Thread 1 count increment to 11905
 * Thread 2 count increment to 12031
 * latest value of count is 12031
 * TO fix this we will have to make the increment method synchronized refer to this {@link com.codersdesks.AvoidRaceConditionWithSynchronized}
 **/
public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        var counterObj = new MyCounter();
        var t1 = new Thread(counterObj,"Thread 1");
        var t2 = new Thread(counterObj, "Thread 2");
        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println("latest value of count is "+counterObj.getCount());
    }
}
class MyCounter implements Runnable{
    private int count = 0;
    public void run(){
        incrementCount();
    }
     void incrementCount(){
        for(int i =0 ; i < 10000; i++) {
            this.count +=1;
        }
        System.out.println(Thread.currentThread().getName()+" count increment to "+this.count);
    }
    public int getCount() {
        return this.count;
    }
}