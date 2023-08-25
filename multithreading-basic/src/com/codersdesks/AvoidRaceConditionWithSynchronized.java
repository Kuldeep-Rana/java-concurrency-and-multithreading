package com.codersdesks;
/**
Here you can see the entire code is same as {@link com.codersdesks.RaceConditionExample}. Only difference is the {@link MyCounterWithVolatile#incrementCount()} is synchronized now.
You will get out like
 Thread 1 count increment to 10000
 Thread 2 count increment to 20000
 latest value of count is 20000
 or
 Thread 2 count increment to 10000
 Thread 1 count increment to 20000
 latest value of count is 20000
 But the latest value of count will always be 20000
**/
public class AvoidRaceConditionWithSynchronized {
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
class MyCounterWithSynchronized implements Runnable{
    private int count = 0;
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
