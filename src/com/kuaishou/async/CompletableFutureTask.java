package com.kuaishou.async;

import com.kuaishou.model.DataInfo;
import com.kuaishou.model.DbInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTask {


    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {

        List<DbInfo> list = Arrays.asList(new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),new DbInfo(),
                new DbInfo());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        list.forEach(dataInfo -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("start task...");
                    long start = System.currentTimeMillis();
                    Thread.sleep(new Random(200).nextInt(4) * 1000);
                    dataInfo.setName("");
                    dataInfo.setTaskName("TA");
                    long end = System.currentTimeMillis();
                    System.out.println("task spend time " + (end - start) / 1000 + " s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executorService);
            futures.add(future);

        });
        System.out.println("async task all have submit, wait to end....");
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("async task all end....");
        list.forEach(dbInfo -> {
            System.out.println(dbInfo.getName().length());
            System.out.println(dbInfo.getTaskName().replace("a","b"));
        });
    }
}
