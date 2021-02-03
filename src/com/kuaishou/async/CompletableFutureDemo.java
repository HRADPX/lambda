package com.kuaishou.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

public class CompletableFutureDemo {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future1_done = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return doSomething("future1 done");
        }).thenAccept(x -> {
            System.out.println("pic parse success!");
            System.out.println("send rocket mq message" + x);
        }).exceptionally(e -> {
            System.out.println(e.getMessage() + "1");
            return null;
        });


        CompletableFuture<Void> future1_done1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 1 / 0;
            return doSomething("future2 done");
        }).thenAccept(x -> {
            System.out.println("video parse success!");
            System.out.println("send rocket mq message" + x);
        }).exceptionally(e -> {
            System.out.println(e.getMessage() + "2");
            return null;
        });


        CompletableFuture.allOf(future1_done,future1_done1).thenRun(() -> System.out.println("ALL TASK DONE")).join();


//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("future2 start");
//        });
//
//        CompletableFuture<Void> future = CompletableFuture.allOf(future1,future2)
//                .thenRun(() -> {
//                    System.out.println("end");
//                });
    }

    private static String doSomething(String input) {
//        if(true)
//            throw new RuntimeException("aaa");
        return input;
    }
}
