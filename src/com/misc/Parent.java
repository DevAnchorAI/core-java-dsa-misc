package src.com.misc;

public class Parent {

	int i=10;
	//instance block-1
	{
		m1();
		System.out.println("FIB");
	}
	Parent(){
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println("main(-) Method");

	}
	public void m1() {
		System.out.println(j);
	}
	//instance block-2
	{
		System.out.println("SIB");
	}
	int j=20;

}
