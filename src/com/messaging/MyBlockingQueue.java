package src.com.messaging;

import java.util.concurrent.PriorityBlockingQueue;

public class MyBlockingQueue  {
    private  static final PriorityBlockingQueue queue = new PriorityBlockingQueue<>(5);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    static class   Producer implements Runnable{

        @Override
        public void run() {
          int num=1;
          try {
              while (true){
                  queue.put(num);// waits if queue is full
                  System.out.println("Produced:"+num);
                  num++;
                  Thread.sleep(500);
              }
          }catch (InterruptedException ex){
              System.out.println("Producer Interrupted:"+ex.getMessage());
          }

        }
    }

    static class   Consumer implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                   int num= (Integer) queue.take();// waits if queue is empty
                    System.out.println("Consume:"+num);
                    Thread.sleep(500);
                }
            }catch (InterruptedException ex){
                System.out.println("Consumer Interrupted:"+ex.getMessage());
            }
        }
    }
}





