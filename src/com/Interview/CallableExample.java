package com.Interview;

import java.util.concurrent.*;

// concurrency
//
public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        // Implementation for the ‘Call’ method -
        // this returns a ‘String’ result and a new ‘ExecutorService’ is created.
        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(1000);
            return "Hello";
        };

        System.out.println("Starting new Thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);

        System.out.println("Doing something else");
        System.out.println("Retrieve thread result");

        String result = future.get(); // this blocks till result is available
        System.out.println("Result is:" + result);

        executorService.shutdown();
    }
}
