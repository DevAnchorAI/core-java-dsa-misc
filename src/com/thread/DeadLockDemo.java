package src.com.thread;

public class DeadLockDemo {

   private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {


        //Thread-1 acquires lock1 first, then tries to acquire lock2.
       // Thread-2 acquires lock2 first, then tries to acquire lock1.
        //The program never terminates because both threads are waiting indefinitely.
        Thread thread1 = new Thread(()->{

            synchronized (lock1){
                System.out.println("Thread1 acquired  Lock1");

                synchronized (lock2){
                    System.out.println("Thread1 waiting for  Lock2");
                }
            }
        });

        Thread thread2 = new Thread(()->{

            synchronized (lock2){
                System.out.println("Thread2 acquired Lock2");

                synchronized (lock1){
                    System.out.println("Thread2 waiting for Lock1");
                }
            }


        });

        thread1.start();
        thread2.start();
    }
}
