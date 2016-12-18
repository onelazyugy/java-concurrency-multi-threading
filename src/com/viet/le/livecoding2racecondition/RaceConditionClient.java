package com.viet.le.livecoding2racecondition;

/**
 * What is race condition? multiple threads running in parallel and they read and update an object value.
 * This will result in inconsistent result.
 * This demonstrate race condition
 * Created by onelazyguy on 12/17/16.
 */
public class RaceConditionClient {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable r = () ->{
            for(int i = 0; i < 1000; i++){
                longWrapper.incrementValue();
            }
        };
        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(r);
            threads[i].start();
        }
        //make sure all threads are done before giving back control to main thread
        //basically the main thread has to wait execution before all threads have finished their task
        for(int i = 0; i < threads.length; i++){
            threads[i].join();
        }
        System.out.println("Value = " + longWrapper.getValue());
    }
}
