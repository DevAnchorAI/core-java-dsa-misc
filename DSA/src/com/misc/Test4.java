package com.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//findLowestSalaryEmployee();
		findHighestSalaryEmployee();
		//salaryAndGradePay();
		//findMatch();
		//countOccurances();
		//reverseString();
		
	}
	
	public static void reverseString() {
		String str = "hello";

		String reverse = "";


		for (int i = 0; i < str.length(); i++) {
		     reverse = str.charAt(i) + reverse;//h
		     
		}

		System.out.println(reverse);
	}
	
	public static void countOccurances() {
		
		Integer[] numArr = {2,5,8,2,9,8,7,9};

		Map<Integer, Integer> hMap= new HashMap<>();

		int count=1;
		for(int i=0; i<numArr.length-1;i++)
		{

			
			  if(hMap.containsKey(numArr[i])){ 
				  count++; 
				  hMap.put(numArr[i],count); 
				  }else{
			  hMap.put(numArr[i],count); 
			  }
			 
		}

		for(Map.Entry entry: hMap.entrySet())
		{
		System.out.println("Number:"+entry.getKey()+" Count:"+entry.getValue());
		}

	
		
	}
	
	public static void  findMatch() throws IOException {
		PrintWriter pw = new PrintWriter("src\\output.txt");
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\input.txt")));

		String line =br.readLine();
		while(line!=null) {
			Matcher m = p.matcher(line);
			if(m.find()) {
				pw.println(m.group());
				pw.flush();			
				
			}
			line=br.readLine();
		}
		
		br.close();
		pw.close();
	}
	
	public static void  salaryAndGradePay() {
		List<Employee> employees = new ArrayList<Employee>(){{
		    add(new Employee( "suman",30000,"A"));
		    add(new Employee( "vishwa",40000,"B"));
		    add(new Employee( "sunil",80000,"C"));
		    add(new Employee( "vikash",60000,"A"));
		}};
		
		List<Employee> empList=employees.stream().filter(e->e.getSalary()>50000).
				filter(e->e.getGrade().equals("A")).collect(Collectors.toList());
		
		for(Employee emp:empList) {
			System.out.println(emp.getName());
		}
	}
	
	public static void  findLowestSalaryEmployee() {
		
		List<Employee> employees = new ArrayList<Employee>(){{
		    add(new Employee( "suman",30000,"A"));
		    add(new Employee( "vishwa",40000,"B"));
		    add(new Employee( "sunil",50000,"C"));
		    add(new Employee( "vikash",60000,"A"));
		}};
		
		List<Employee> employeeWithLowestSalary =employees.stream().
				collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
				.firstEntry().getValue();
		

		for( Employee emp: employeeWithLowestSalary) {
			System.out.println("LowestSalary:"+emp.getSalary());
		}
 
	}
	
   public static void  findHighestSalaryEmployee() {
		
	List<Employee> employees = new ArrayList<Employee>(){{
	    add(new Employee( "suman",30000,"A"));
	    add(new Employee( "vishwa",40000,"B"));
	    add(new Employee( "sunil",80000,"C"));
	    add(new Employee( "vikash",60000,"A"));
	}};
		
		List<Employee> employeeWithLowestSalary =employees.stream().
				collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
				.lastEntry().getValue();
		System.out.println("HighestSalary:"+employeeWithLowestSalary.get(0).getSalary());
	}

}
