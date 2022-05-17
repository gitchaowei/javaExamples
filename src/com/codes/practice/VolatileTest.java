package com.codes.practice;

// Volatile keyword is used to modify the value of a variable by different threads.
// The volatile keyword can be used either with primitive type or objects.
// The volatile keyword cannot be used with classes or methods.
public class VolatileTest {

    private static volatile int MY_INT = 0;

    public static void main(String[] args)
    {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run()
        {
            int local_value = MY_INT;
            while (local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.println("MY_INT in ChangeListener: " + MY_INT);
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run()
        {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("MY_INT in ChangeMaker: " + local_value);

                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
