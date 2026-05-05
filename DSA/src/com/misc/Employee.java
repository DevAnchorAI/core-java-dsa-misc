package com.misc;

public class Employee {
private String name;
private int salary;
private String grade;

public Employee(String name, int salary, String grade) {
	super();
	this.name = name;
	this.salary = salary;
	this.grade = grade;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}


}
