package src.com.messaging;

import java.util.LinkedList;
import java.util.Queue;

public class MyMessagingQueue<T> {

    private  final Queue<T> queue = new LinkedList<>();

    public  void publish(T message){
        queue.offer(message);
    }
    public T consume(){
        return queue.poll();
    }
    public int  size(){
       return queue.size();
    }

    @Override
    public String toString() {
        return "MyMessagingQueue{" +
                "queue=" + queue +
                '}';
    }
}

class Main{
    public static void main(String[] args) {
        MyMessagingQueue<String> myMessagingQueue = new MyMessagingQueue<>();
        myMessagingQueue.publish("Order Created");
        myMessagingQueue.publish("Payment-1 Received");
        myMessagingQueue.publish("Payment-2 Received");
        System.out.println(myMessagingQueue.size());

        System.out.println(myMessagingQueue.consume());
        System.out.println(myMessagingQueue.consume());
        System.out.println(myMessagingQueue.consume());
    }
}
