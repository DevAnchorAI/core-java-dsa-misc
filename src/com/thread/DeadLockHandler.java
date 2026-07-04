package com.thread;


public class DeadLockHandler {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {

        //If every thread acquires locks in the same order, circular waiting cannot occur.
        Runnable task = ()->{

            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+" acquired Lock1");

                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+" acquired Lock2");
                }
            }
        };

        new Thread(task,"Thread-1").start();
        new Thread(task,"Thread-2").start();;

    }
}
