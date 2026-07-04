package src.com.thread;
public class SimpleThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("Starting SimpleThreadPool dqemo...");


    SimpleThreadPool pool = new SimpleThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            final int id = i;
            pool.submit(() -> {
                System.out.println("Task " + id + " running on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + id + " completed on " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
        boolean finished = pool.awaitTermination(5000);
        System.out.println("All tasks finished: " + finished);

        // demonstrate rejection after shutdown
        try {
            pool.submit(() -> System.out.println("This should be rejected"));
        } catch (Exception e) {
            System.out.println("Expected exception on submit after shutdown: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("Demo complete.");

        System.out.println();
        System.out.println("--- forEach vs parallelStream demo ---");

    }


}