package com.lambda;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        runStreamDemo();
    }

    // Simulated work: prints start (with thread), sleeps, prints end
    private static void simulateWork(String item) {
        System.out.println("Processing " + item + " on " + Thread.currentThread().getName());
        try {
            Thread.sleep(200); // Simulate time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed " + item + " on " + Thread.currentThread().getName());
    }

    private static void runStreamDemo() {
        java.util.List<String> itemsList = new java.util.ArrayList<>();
        for (int i = 1; i <= 10; i++) itemsList.add("item-" + i);

        // Sequential forEach
        long t0 = System.nanoTime();
        itemsList.forEach(ParallelStreamDemo::simulateWork);
        long t1 = System.nanoTime();
        long seqMs = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println("Sequential forEach took: " + seqMs + " ms");

        // Parallel stream
        long t2 = System.nanoTime();
        itemsList.parallelStream().forEach(ParallelStreamDemo::simulateWork);
        long t3 = System.nanoTime();
        long parMs = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println("parallelStream took: " + parMs + " ms");

        System.out.println();
        System.out.println("Notes: \n- parallelStream uses the common ForkJoinPool (size ~ number of processors).\n- For IO-bound tasks, parallel streams can speed up processing but results vary based on workload and CPU/IO characteristics.");
    }
}
