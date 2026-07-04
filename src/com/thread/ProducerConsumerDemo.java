package src.com.thread;

import java.util.concurrent.PriorityBlockingQueue;


//put() blocks when the queue is full.
//take() blocks when the queue is empty.
//No need for synchronized, wait(), or notifyAll().
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(5);

        new  Thread(new Producer(queue)).start();
        new Thread((new Consumer(queue))).start();
    }

    static class Producer implements  Runnable{

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        public Producer(PriorityBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int num =1;
            try{
            while (true){
                queue.put(num); // waits if queue is full
                System.out.println("Produced: "+num);
                num++;
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){
            System.out.println("Producer  Interrupted."+ex.getMessage());
        }
        }
    }

    static  class Consumer implements Runnable{
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        public Consumer(PriorityBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            while (true){
                try {
                   int num =  queue.take(); // waits if queue is empty
                    System.out.println("Consumed: "+num);
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    System.out.println("Consumer  Interrupted."+ex.getMessage());
                }

            }
        }
    }
}
