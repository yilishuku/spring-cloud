package com.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: wcy
 * Date: 2017/8/30
 * Time: 16:54
 */
public class TaskPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(500);
        for (int i=0 ;i<20000;i++){
            final int a = i;
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a);
            },executor);
        }
    }

    private static void sleep(int i){
        try {
            System.out.println("aaa"+i);
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
