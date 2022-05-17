package com.codes.practice;

import java.util.concurrent.*;

// Callable, ExecutorService, and Future
//
public class ThreadCallableExecutorServiceFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        // Implementation for the ‘Call’ method -
        // this returns a ‘String’ result and a new ‘ExecutorService’ is created.
        //
        // Callable interface is @FunctionalInterface with call()
        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(1000);
            return "Hello";
        };
// Same as:
//        Callable<String> callable = new Callable<String>()  {
//            @Override
//            public String call() throws Exception {
//                System.out.println("Entered Callable");
//                Thread.sleep(1000);
//                return "Hello";
//            }
//
//        };
        // another example:
//        Callable<Integer> callableObj = () -> { return 2*3; };
        // same as:
//        Callable<Integer> callableObj = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 2*3;
//            }
//        };

        System.out.println("Starting new Thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);

        System.out.println("Doing something else");
        System.out.println("Retrieve thread result");

        String result = future.get(); // this blocks till result is available
        System.out.println("Result is: " + result);

        executorService.shutdown();
    }
}
