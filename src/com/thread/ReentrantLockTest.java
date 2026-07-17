package src.com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws Exception{
        Lock lock = new ReentrantLock(true);

        if(lock.tryLock()){

            try{
                System.out.println("Got the lock");

            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("Busy ReentrantLock");
        }

    }


}
