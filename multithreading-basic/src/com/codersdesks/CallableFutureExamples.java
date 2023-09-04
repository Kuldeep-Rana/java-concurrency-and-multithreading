package com.codersdesks;

import java.util.concurrent.*;

public class CallableFutureExamples {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ScheduledThreadPool with Callable and Future Example
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        ScheduledFuture<Integer> scheduledFuture = scheduledExecutor.schedule(() -> {
            System.out.println("Scheduled Callable task running");
            return 42;
        }, 3, TimeUnit.SECONDS);

        int resultFromScheduled = scheduledFuture.get();
        System.out.println("Result from Scheduled task: " + resultFromScheduled);
        scheduledExecutor.shutdown();

        // FixedThreadPool with Callable and Future Example
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        Callable<String> callableTask = () -> {
            System.out.println("FixedThreadPool Callable task running");
            return "Callable task result";
        };
        Future<String> futureFromFixed = fixedExecutor.submit(callableTask);
        String resultFromFixed = futureFromFixed.get();
        System.out.println("Result from FixedThreadPool task: " + resultFromFixed);
        fixedExecutor.shutdown();

        // CachedThreadPool with Callable and Future Example
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        Callable<Double> anotherCallableTask = () -> {
            System.out.println("CachedThreadPool Callable task running");
            return Math.random();
        };
        Future<Double> futureFromCached = cachedExecutor.submit(anotherCallableTask);
        double resultFromCached = futureFromCached.get();
        if(futureFromCached.isDone()){
            System.out.println("futureFromCached done");
        }
        System.out.println("Result from CachedThreadPool task: " + resultFromCached);
        cachedExecutor.shutdown();
    }
}

