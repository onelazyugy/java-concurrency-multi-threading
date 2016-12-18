package com.viet.le.livecoding1firstthread;

public class FirstRunnable {

    public static void main(String[] args) {
	    // write your code here
        Runnable runnable = () ->{
            System.out.println("I am running in " + Thread.currentThread().getName());
        };
        Thread t = new Thread(runnable);
        t.setName("My thread");
        //will execute the code inside runnable
        t.start();
        //will execute the main thrad
        //t.run();
    }
}
