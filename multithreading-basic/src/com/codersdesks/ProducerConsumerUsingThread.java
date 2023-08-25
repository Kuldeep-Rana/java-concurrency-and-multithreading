package com.codersdesks;

public class ProducerConsumerUsingThread {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer sb = new SharedBuffer();
        var producer = new Thread(new Producer(sb));
        var consumer = new Thread(new Consumer(sb));
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
        //the above join will make sure the main thread finish only after these two executed.
    }
}

class Producer implements Runnable{

    private SharedBuffer monitor;
    public Producer(SharedBuffer o){
        this.monitor  = o;
    }
    public void run(){
        try {
            for(int i = 1; i<= 5000; i++) {
                monitor.produce(i);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Consumer implements Runnable{

    private SharedBuffer monitor;
    public Consumer(SharedBuffer o){
        this.monitor  = o;
    }
    public void run(){
        try {
            for(int i = 1; i<= 5000; i++) {
                monitor.consume();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SharedBuffer {
    private int i = 0;
    private boolean produced = false;
    public synchronized void produce(int i) throws InterruptedException {
        while(produced){
            wait();
        }
        this.i = i;
        System.out.println("produced "+i);
        produced = true;
        notify();
    }
    public synchronized void consume() throws InterruptedException {
        while(!produced){
            wait();
        }
        System.out.println("consumed "+i);
        produced = false;
        notify();
    }
    public int get(){
        return i;
    }
}
