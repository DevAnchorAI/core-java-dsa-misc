package com.misc;

import java.security.Identity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String args[]) {
		
		//findDuplicatesCharacter(" suman kumar"); 
		//frequencyOfEachCharInString();
		//swapNumbers();
		
		
		//long output =factorial(5);
		//System.out.println(output);
		//frequencyOfEachNumber();
		/*
		 * for(int i=0;i<=4;i++) { System.out.println(fib(i)); }
		 */
		
		fibbonaciSeries(5);
		
		
	}
	
	public static long factorial(long n) {
		
		if(n==1)return 1;
		else return n*factorial(n-1);
	}
	
	public static void fibbonaciSeries(int count) {
		//F(N) = F(N-1) + F(N-2)
		int a=0;
		int b=1;
		int c=1;
		for(int i=1; i<=count;i++) {
			System.out.println(a+",");
			a=b;
			b=c;
			c=a+b;
			
		}
	}
	public static void swapNumbers() {
		int a=10;
		int b=20;
		b=b+a;
		a=b-a;
		b=b-a;
		System.out.println("a="+a);
		System.out.println("b="+b);
				
	}
	public static int fib(int n) {
		if(n<=1) return n;
		return fib(n-1)+fib(n-2);
		
	}

	
	public static void frequencyOfEachCharInString() {
		
		String inputString="sumankumar";
		Map<Character,Long> characterCounting = inputString.chars().mapToObj(c->(char) c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(characterCounting);
	}
	public static void frequencyOfEachNumber() {
		Integer[] numArr = {1,8,5,7,5,4,6,4,1};
		List<Integer> numbers = Arrays.asList(numArr);
		Map<Integer,Long> countNumber= numbers.stream().mapToInt(i->(int)i).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(countNumber);
	}
	public static void findDuplicatesCharacter(String str) {
		
		char[] chr =str.toCharArray();
		System.out.println("Duplicate Character are:");
		for(int i=0; i<str.length();i++) {
		
			for(int j=i+1;j<str.length();j++) {
				if(chr[i]==chr[j]) {
					System.out.println(chr[j]);
					break;
				}
			}
		}
	}
}
