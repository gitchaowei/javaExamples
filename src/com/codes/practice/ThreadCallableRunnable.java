package com.codes.practice;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

// 1) The Runnable interface is older than Callable which is there from JDK 1.0,
//     while Callable is added on Java 5.0.
// 2) Runnable interface has run () method to define task
//    while Callable interface uses call () method for task definition.
// 3) run () method does not return any value, its return type is void
//    while the call method returns a value.
//
public class ThreadCallableRunnable {

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            System.out.println("Main Thread start...");
            Instant start = java.time.Instant.now();

            System.out.println("Runnable Threads start...");
            runnableThreads();
            System.out.println("Runnable Threads end");

            System.out.println("Callable Threads start...");
            callableThreads();
            System.out.println("Callable Threads end");

            Instant end = java.time.Instant.now();
            Duration between = java.time.Duration.between(start, end);
            System.out.printf("Time taken : %02d:%02d.%04d \n", between.toMinutes(), between.getSeconds(), between.toMillis());
            // or
            //System.out.format("Time taken : %02d:%02d.%04d \n", between.toMinutes(), between.getSeconds(), between.toMillis());

            System.out.println("Main Thread completed...");
        }
        public static void runnableThreads() throws InterruptedException, ExecutionException {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            Future<?> f1 = executor.submit( new RunnableTask(5) );
            Future<?> f2 = executor.submit( new RunnableTask(2) );
            Future<?> f3 = executor.submit( new RunnableTask(1) );

            // Using Future, Waits until pool-thread complete, return null upon successful completion.
            System.out.println("F1 : "+ f1.get());
            System.out.println("F2 : "+ f2.get());
            System.out.println("F3 : "+ f3.get());

            executor.shutdown();
        }
        public static void callableThreads() throws InterruptedException, ExecutionException {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            Future<Integer> f1 = executor.submit( new CallableTask(5) );
            Future<Integer> f2 = executor.submit( new CallableTask(2) );
            Future<Integer> f3 = executor.submit( new CallableTask(1) );

            // Using Future, Waits until pool-thread complete, returns the result.
            System.out.println("F1 : "+ f1.get());
            System.out.println("F2 : "+ f2.get());
            System.out.println("F3 : "+ f3.get());

            executor.shutdown();
        }
}

class CallableTask implements Callable<Integer> {
    private int num = 0;
    public CallableTask(int num) {
        this.num = num;
    }
    @Override
    public Integer call() throws Exception {   // return Integer
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " : Started Task...");

        for (int i = 0; i < 5; i++) {
            System.out.println(i + " : " + threadName + " : " + num);
            num = num + i;
            Thread.sleep(1);
        }
        System.out.println(threadName + " : Completed Task. Final Value : "+ num);

        return num;
    }
}
class RunnableTask implements Runnable {
    private Integer num = 0;
    public RunnableTask(int num) {
        this.num = num;
    }
    @Override
    public void run() {  // no return value
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " : Started Task...");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " : " + threadName + " : " + num);
                num = num + i;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(threadName + " : Completed Task. Final Value : "+ num);
    }
}

