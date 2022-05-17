package com.codes.practice;

public class ThreadDeadlock {

    public static void main(String[] args) {
        final Object o1 = "This is resource one";
        final Object o2 = "This is resource two";

        //Deadlock sequence:  t1->o1->o2 and t2->o2->o1
        //Resolve deadlock by a sequence as t1->o1->o2 and t2->o1->o2
        //
        Thread t1 = new Thread() {
            public void run() {
                synchronized (o1) {
                    System.out.println("Thread 1: locked resource one");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    synchronized (o2) {
                        System.out.println("Thread 2: locked resource two");
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                    }
                }

            }


        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (o1) {
                    System.out.println("Thread 1: locked resource one");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    synchronized (o2) {
                        System.out.println("Thread 2: locked resource two");
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }

}
