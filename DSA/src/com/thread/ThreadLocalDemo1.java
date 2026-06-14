package DSA.src.com.thread;

public class ThreadLocalDemo1 {

	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal() {
		
			protected Object initialValue() {
				return "abc";
			}
		};
		System.out.println(tl.get());
		tl.set("suman");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());

	}
}
