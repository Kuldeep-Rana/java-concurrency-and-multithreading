package com.codersdesks;

public class InheritableThreadLocalExample {

    public static void main(String[] args) {
        var inheritableThreadLocal = new InheritableThreadLocal<String>();
        var threadLocal = new ThreadLocal<String>();

        var parentThread = new Thread(() ->{
            try {
                inheritableThreadLocal.set("parent thread - 1");
                threadLocal.set("parent thread - 11");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var childThread = new Thread(()->{
                System.out.println("child - getting parent data from inheritableThreadLocal: "+inheritableThreadLocal.get());
                System.out.println("child - getting parent data from thread local: "+threadLocal.get());
            }) ;
            childThread.start();
        });
        parentThread.start();
    }
}
