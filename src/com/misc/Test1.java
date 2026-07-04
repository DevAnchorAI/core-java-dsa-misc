package src.com.misc;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test1{

	public static void main(String[] args) throws InterruptedException {
		
		TreeSet t = new TreeSet<>(new MyComparator());
		//t.add(40);t.add(10);t.add(30);t.add(10);t.add(60);t.add(20);t.add(50);
		TreeMap<Object, Object> tmap = new TreeMap<>();
        tmap.put(1, "A");
        tmap.put(4, 10);
        tmap.put(3, "C");
        tmap.put(2, "B");
        System.out.println(tmap);
   
		
	}
}

class Temp{
	
	public String toString() {
		return "temp";
		
	}
	
	public void finalize() {
		System.out.println("finalize(-) method called");
	}
}
class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {

		/*
		 * Integer i1= (Integer)o1; Integer i2= (Integer)o2;
		 */
		/*
		 * if(i1>i2) { return -1; }else if(i1<i2) { return 1; }else { return 0; }
		 */
		//return i1.compareTo(i2);
		
		String s1 = o1.toString();
		String s2 = o2.toString();
		if(s1.length()>s2.length()) {
			return 1;
		}else if(s1.length()<s2.length()) {
			return -1;
		}else {
			return s1.compareTo(s2);
		}
		
		
	}
	
}
