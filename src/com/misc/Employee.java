package src.com.misc;

public class Employee {
	private int id;
	private String name;
private int salary;
private String grade;
private  String department;

	public Employee(int id, String name, int salary, String grade, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				", grade='" + grade + '\'' +
				", department='" + department + '\'' +
				'}';
	}
}
