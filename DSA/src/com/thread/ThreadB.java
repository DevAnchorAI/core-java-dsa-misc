package DSA.src.com.thread;

public class ThreadB extends Thread{

	int total =0;
	public void run() {
		synchronized (this) {
			
		
		System.out.println("Child thread start calculation");
		for (int i = 0; i < 100; i++) {

			total = i+total;
			
		}
		this.notify();
		System.out.println("Child thread send notification to main");
		}
	}
}
