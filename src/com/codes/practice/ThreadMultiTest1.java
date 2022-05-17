package com.codes.practice;

import java.util.concurrent.TimeUnit;



public class ThreadMultiTest1 {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0) ;
        Thread thread1 = new CountThread(count);
        thread1.start();
        Thread thread2 = new CountThread(count);;
        thread2.start();
        Thread thread3 = new CountThread(count);;
        thread3.start();
        Thread thread4 = new CountThread(count);;
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Done!");
    }
}

class Count {
    private int icount;

    public Count(int icount) {
        this.icount = icount;
    }

    void increaseCount() {
        icount++;
    }

    @Override
    public String toString() {
        return "Count{" +
                "icount=" + icount +
                '}';
    }
}

class CountThread extends Thread {
    private Count count ;

    public CountThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            TimeUnit.SECONDS.sleep(1);
            synchronized (count) {
                count.increaseCount();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello " + threadName + " " + count.toString());
    }
}
