package com.codersdesks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> System.out.println("call 1 running thread  - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 2 running thread - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 3 running thread - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 4 running thread - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 5 running thread - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 6 running thread - " + Thread.currentThread().getName()));
        service.execute(() -> System.out.println("call 7 running thread - " + Thread.currentThread().getName()));
        service.shutdown();
    }
}
