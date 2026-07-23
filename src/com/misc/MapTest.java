package src.com.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MapTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

       // excecutorServiceTest();

        supplyAsync();
        runAsync();
    }

    //ExecutorService = A framework for managing and executing tasks using a thread pool.
    private static void excecutorServiceTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future=executorService.submit(
                ()->{
                    System.out.println("Task Executed");
                    return "Done";
                }

        );

        System.out.println("Result:"+future.get());
        executorService.shutdown();
    }

   // CompletableFuture = A framework for writing asynchronous, non-blocking workflows and composing multiple tasks.
    private static CompletableFuture<String>  supplyAsync(){
     CompletableFuture<String> future= CompletableFuture.supplyAsync(()->"Hello");

        future.thenAccept(System.out::println);
        return future;
    }
    private static void   runAsync(){
       CompletableFuture.runAsync(()->{
           System.out.println("HELLO");
       });

    }
}

//With ExecutorService alone, you'd submit tasks and manually wait for each Future.
//
//        With CompletableFuture, you can fetch everything in parallel and combine the results elegantly:
//
//CompletableFuture<Product> product = ...
//CompletableFuture<Inventory> inventory = ...
//CompletableFuture<Reviews> reviews = ...
//
//        CompletableFuture.allOf(product, inventory, reviews)
//                 .thenRun(() -> renderPage());