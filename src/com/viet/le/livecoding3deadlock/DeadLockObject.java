package com.viet.le.livecoding3deadlock;

/**
 * To fix deadlock, uncomment synchronized at method signature and comment out the synchronized inside the method implementation
 * Created by onelazyguy on 12/17/16.
 */
public class DeadLockObject {
    private Object key1 = new Object();
    private Object key2 = new Object();

    public /*synchronized*/ void a() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
            b();
        }
    }
    public /*synchronized*/ void b() {
        synchronized (key2) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
            c();
        }
    }
    public /*synchronized*/ void c() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in c()");
        }
    }
}