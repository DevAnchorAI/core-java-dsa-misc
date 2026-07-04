package src.com.thread;

class ParentThread extends Thread{
	
	public static InheritableThreadLocal itl =new InheritableThreadLocal() {
	
		public Object childValue(Object p) {
			return "xyz/child value";
		}
	};
	public void run() {
		itl.set("Parent Thread");
		System.out.println("Parent thread:"+itl.get());
		
		ChildThread ct = new ChildThread();
		ct.start();
	}
}

class ChildThread extends Thread{
	
	public void run() {
		System.out.println("Child thread:"+ParentThread.itl.get());
	}
}


public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		ParentThread pt = new ParentThread();
		pt.start();

	}

}
