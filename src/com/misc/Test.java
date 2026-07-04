package com.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface IntrefA{
	public void add(int a, int b);

}



public class Test {

	 static void addMe(int a, int b)
	    {
	        System.out.println("HELLO....");
	    }
	public static void main(String[] args) {
		

		
		
		/*
		 * IntrefA intrefA = (a,b)-> System.out.println("Sum= "+(a+b)); intrefA.add(10,
		 * 20); intrefA.add(100, 200); intrefA.add(1000, 2000);
		 */
		 
		
		//method reference example
		/*
		 * IntrefA intrefAB = Test :: addMe; intrefAB.add(10, 20);
		 */
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		System.out.println(list);	
		
		List<Integer> list2 =list.stream().filter(i->i%4==0).collect(Collectors.toList());
		System.out.println(list2);
		
		List<Integer> marks = new ArrayList<>();
		marks.add(40);
		marks.add(50);
		marks.add(30);
		marks.add(31);
		marks.add(20);
		System.out.println(marks);
		List<Integer> updatedMarks = marks.stream().map(i->i=i+5).collect(Collectors.toList());
		System.out.println(updatedMarks);
	}

}
