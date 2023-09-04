package com.codersdesks;
import java.util.concurrent.*;

public class ThreadPoolExamples {
    public static void main(String[] args) {
        // ScheduledThreadPool Example
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled task running");
        }, 0, 1, TimeUnit.SECONDS);

        // FixedThreadPool Example
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            fixedExecutor.submit(() -> {
                System.out.println("FixedThreadPool task " + taskNumber + " running");
            });
        }
        fixedExecutor.shutdown();

        // CachedThreadPool Example
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            cachedExecutor.submit(() -> {
                System.out.println("CachedThreadPool task " + taskNumber + " running");
            });
        }
        cachedExecutor.shutdown();
    }
}

