package com.codersdesks;

public class DifferentWaysToCreateThread {

    //Example 1, using Thread class
    static class ThreadTest extends Thread{

        public void run(){
            System.out.println("Thread "+Thread.currentThread().getName());
        }
    }

    //Example 2, using Runnable Interface
    static  class RunnableTest implements  Runnable{

        @Override
        public void run() {
            System.out.println("Runnable "+Thread.currentThread().getName());
        }
    }




    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        Thread runnableTest =  new Thread(new RunnableTest());
        runnableTest.start();


        //Example 3, using Annonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Annonymous "+Thread.currentThread().getName());
            }
        }).start();

        //Example 4, using Annonymous with lambda
        new Thread(() -> {
            System.out.println("Annonymous with Lambda "+Thread.currentThread().getName());
        }).start();

        //Example 5, using lambda and Runnable
        Runnable runnable = () ->  System.out.println("Using Lambda and Runnable "+Thread.currentThread().getName());
        new Thread(runnable).start();
    }



}
