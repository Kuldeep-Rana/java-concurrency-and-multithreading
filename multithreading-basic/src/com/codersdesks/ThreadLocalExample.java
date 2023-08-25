package com.codersdesks;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        var t1 = new Thread(() -> {
            local.set("Thread 1");
            try {
                Thread.sleep(3000);
                System.out.println(local.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var t2 = new Thread(() -> {
            local.set("Thread 2");
            try {
                Thread.sleep(3000);
                System.out.println(local.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

    }
}
