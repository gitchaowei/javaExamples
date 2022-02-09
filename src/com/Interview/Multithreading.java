package com.Interview;

public class Multithreading implements Runnable {

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
