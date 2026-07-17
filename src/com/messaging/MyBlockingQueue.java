package src.com.messaging;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MyBlockingQueue  {
    //will consume messages in order of their createdAt time (earliest first), rather than the order they were produced.
    //private  static final PriorityBlockingQueue<MessageData> queue = new PriorityBlockingQueue<>();

    // If you want FIFO behavior instead, use:
    // This removes the need for MessageData to implement Comparable.
    private static final BlockingQueue<MessageData> queue = new LinkedBlockingQueue<>();

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
                  MessageData data = new MessageData("message-"+num);
                  queue.put(data);// waits if queue is full
                  System.out.println("Produced:"+data);
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
                    MessageData message = queue.take();// waits if queue is empty
                    System.out.println("Consume:"+message);
                    Thread.sleep(500);
                }
            }catch (InterruptedException ex){
                System.out.println("Consumer Interrupted:"+ex.getMessage());
            }
        }
    }
}

//class MessageData implements Comparable<MessageData> {
class MessageData{
    private final String id;
    private final String payload;
    private final LocalDateTime createdAt;

    public MessageData(String payload) {
        this.id = UUID.randomUUID().toString();
        this.payload = payload;
        this.createdAt = LocalDateTime.now();
    }

//    @Override
//    public int compareTo(MessageData other) {
//        // Compare by creation time (earlier messages have higher priority)
//        return this.createdAt.compareTo(other.createdAt);
//    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", payload='" + payload + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}




