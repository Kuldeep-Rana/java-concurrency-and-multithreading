package com.codersdesks;

public class DemonThreadUseCase {

    public static void main(String[] args) throws Exception{
        Runnable runnable = () ->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("my thread running");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(runnable);
         //t1.setDaemon(true); // this line mark this thread as demon and as soon as the main thread terminates it will automatically terminate. But if you remove this the inner thread keeps running even after main thread ends.
        t1.start();
        t1.sleep(3000);
        /**
         * in case you want to manage the demon thread and wants its to complete after that only the main thread should finish.
         * You need to call t1.join() so that once it finish the call will return to main thread and it can complete.
         **/
        System.out.println("main thread ends");
    }
}
