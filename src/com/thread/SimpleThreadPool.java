package ThreadApp.src;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionException;

public class SimpleThreadPool {
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final Thread[] workers;
    private volatile boolean isShutdown = false;

    public SimpleThreadPool(int nThreads) {
        if (nThreads <= 0) throw new IllegalArgumentException("nThreads must be > 0");
        workers = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            final int idx = i;
            workers[i] = new Thread(() -> {
                try {
                    while (!isShutdown || !queue.isEmpty()) {
                        Runnable task = queue.poll(200, TimeUnit.MILLISECONDS);
                        if (task != null) {
                            try {
                                task.run();
                            } catch (Throwable t) {
                                // keep worker alive on task exception
                                t.printStackTrace();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    // restore interrupt flag and exit
                    Thread.currentThread().interrupt();
                }
            }, "SimpleThreadPool-worker-" + idx);
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        if (task == null) throw new NullPointerException("task");
        if (isShutdown) throw new RejectedExecutionException("ThreadPool is shutdown");
        queue.offer(task);
    }

    public void shutdown() {
        isShutdown = true;
        // interrupt workers to speed up shutdown if they're blocked
        for (Thread t : workers) {
            t.interrupt();
        }
    }

    public boolean awaitTermination(long millis) {
        long deadline = System.currentTimeMillis() + millis;
        boolean allTerminated = true;
        for (Thread t : workers) {
            long timeLeft = deadline - System.currentTimeMillis();
            if (timeLeft <= 0) {
                allTerminated = false;
                break;
            }
            try {
                t.join(timeLeft);
                if (t.isAlive()) allTerminated = false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                allTerminated = false;
                break;
            }
        }
        return allTerminated;
    }
}

