package com.Interview;

public class MultiThreadingExample {
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
