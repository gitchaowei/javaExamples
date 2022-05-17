package com.codes.practice;

public class ThreadMultiTest2 {
    public static void main(String[] args) {

        for (int i = 0; i <= 5; i++) {
//            // extend Thread
//            Multithreading myThing = new Multithreading(i);
//            myThing.start();

            // implements runnable
            Multithreading myThing = new Multithreading(i);
            Thread myThread = new Thread(myThing);
            myThread.start();

            myThread.isAlive();
            try {
                myThread.join(); // stop till the thread complete, that means no multithreading
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

class Multithreading implements Runnable {

    //public class Multithreading extends Thread {
    private int threadNumber;

    public Multithreading(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(i + " from " + threadNumber);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
