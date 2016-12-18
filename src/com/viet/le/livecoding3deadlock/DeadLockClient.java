package com.viet.le.livecoding3deadlock;

/**
 * What is deadlock? multiple threads running parallel and one thread is waiting for the other thread to finish
 * so that it can continue running. In the case of deadlock, the thread never finish execution since it is waiting for the other
 * thread to finish. Basically, threads wait on other thread and they never finish execution so the JVM never stop and eventually
 * will end up with out of memory exception.
 * This demonstrates dead lock
 * Created by onelazyguy on 12/17/16.
 */
public class DeadLockClient {
    public static void main(String[] args) throws InterruptedException {
        DeadLockObject deadLockObject = new DeadLockObject();

        Runnable r1 = () -> deadLockObject.a();
        Runnable r2 = () -> deadLockObject.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        //waiting for both thread to stop or done before main thread take over again
        t1.join();
        t2.join();
        System.out.print("I never get called due to deadlock...");
    }
}