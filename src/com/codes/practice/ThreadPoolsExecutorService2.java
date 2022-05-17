package com.codes.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// To show difference between Executor.execute() and ExecutorService.submit()
//
// execute() Method
//        This method is declared in the Executor interface.
//        This method can accept only runnable task.
//        This method has a return type of void.
//        This method is used when we are not bothered about the result
//                 but want the code to run in parallel by the worker threads of the thread pool.
//  submit() Method
//        This method is declared in the ExecutorService interface.
//        This method can accept both runnable and callable tasks.
//        This method has a return type of Future.
//        This method is used when we care about the result and need it from the task which has been executed.
//
public class ThreadPoolsExecutorService2 {
    public static void main(String[] args) throws Exception {
        ExecutorServiceSubmitMethod();
        ExecutorServiceExecuteMethod();

    }

    private static void ExecutorServiceExecuteMethod() throws Exception {
        // Creating the object of the Executor Service
        // Note: ExecutorService extends Executor.
        //       execute() is from Executor interface
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // execute() method cannot return
        // anything because it's return type
        // is void.

        // By using execute(), accepting a Runnable task only
        executorService.execute(new Runnable() {

            // Override the run method
            public void run()
            {
                System.out.println("This is execute() method example");
            }
        });

        // This method performs all the previously submitted tasks
        // before termination
        executorService.shutdown();
    }

    private static void ExecutorServiceSubmitMethod() throws Exception {
        // Creating the object of the
        // Executor service interface
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // submit() method can return the result of the computation
        // because it has a return type of Future.

        // By using submit(), we are accepting a Callable or Runnable task.
        // submit() method returns a Java Future object which is
        // used to check when the Runnable has completed.
        Future futureObj = executorService.submit(new Callable() {

            // Overriding the call method
            public Object call()
            {
                System.out.println("This is submit() method example");

                return "Returning Callable Task Result";
            }
        });

        //
        // As it implements Future, get() method is called
        // to get the result
        // get() Waits if necessary for the computation to complete, and then retrieves its result.
        System.out.println(futureObj.get());
        executorService.shutdown();
    }
}
