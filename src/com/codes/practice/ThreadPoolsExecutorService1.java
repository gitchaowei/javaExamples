package com.codes.practice;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Java program to illustrate ThreadPool
// Executors
// Executors has all static methods including newFixedTreadPool() for creating a thread pool that use fixed
// number of threads operating off a shared unbounded queue.
//
//  the Executor interface does not strictly require that execution be asynchronous.
//  In the simplest case, an executor can run the submitted task immediately in the caller's thread:
//
// ExecutorService: an interface extends Executor
//  void execute(Runnable): inherited from interface java.util.concurrent.Executor and return void
//                          Once the task is assigned in the execute() method,
//                          we won’t get any response and forget about the task.
//  Future submit(Runnable): Submits a Runnable task for execution and returns a Future representing that task.
//                           Unlike the execute method, this method returns a future.
//                           In Java, the future represents the result of an asynchronous computation.
//
public class ThreadPoolsExecutorService1 {
        // Maximum number of threads in thread pool
        static final int MAX_T = 3;

        public static void main(String[] args) {
            // Step 1:
            // Create Task class extended from Runnable interface
            // creates five tasks
            Runnable r1 = new Task("task 1");
            Runnable r2 = new Task("task 2");
            Runnable r3 = new Task("task 3");
            Runnable r4 = new Task("task 4");
            Runnable r5 = new Task("task 5");

            // Step 2:
            // creates a thread pool with MAX_T no. of threads as the fixed pool size
            ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

            // Step 3:
            // passes the Task objects to the pool to execute
            // only MAX_T number of processes in the pool are running. New processes enter when
            // any running process finishes
            pool.execute(r1);
            pool.execute(r2);
            pool.execute(r3);
            pool.execute(r4);
            pool.execute(r5);
            // Step 4:
            // pool shutdown
            // ExecutorService.shutdown() will allow previously submitted tasks to execute before terminating.
            pool.shutdown();
            // ExecutorService.shutdownNow() prevents waiting tasks from starting and attempts to stop currently executing tasks.
            //pool.shutdownNow();

            // Upon termination, an executor has no tasks actively executing, no tasks awaiting execution,
            // and no new tasks can be submitted.
            // An unused ExecutorService should be shut down to allow reclamation of its resources.
        }

        // example for ExecutorService.shutdown() and ExecutorService.shutdownNow()
    static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

// Task class to be executed (Step 1)
class Task implements Runnable
{
        private String name;

        public Task(String s)
        {
            name = s;
        }

        // Prints task name and sleeps for 1s
        // This Whole process is repeated 5 times
        public void run()
        {
            try
            {
                for (int i = 0; i<=5; i++)
                {
                    if (i==0)
                    {
                        Date d = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                        //prints the initialization time for every task
                        System.out.println(
                                "Initialization Time for"
                                + " task name - "
                                + name
                                + " = "
                                + ft.format(d));
                    }
                    else
                    {
                        Date d = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                        // prints the execution time for every task
                        System.out.println(
                                "Executing Time for task name - "
                                +
                                name
                                + " = "
                                + ft.format(d));
                    }
                    Thread.sleep(1000);
                }
                System.out.println(name+" complete");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
}

