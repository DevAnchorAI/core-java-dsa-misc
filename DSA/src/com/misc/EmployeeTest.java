package DSA.src.com.misc;

import com.misc.Employee;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//	findLowestSalaryEmployee(employeeList());
//		findHighestSalaryEmployee(employeeList());
//		groupEmployeesByDepartment(employeeList());
//		salaryAndGradePay(employeeList());
		partitionEmployeesBySalary(employeeList());
	}

	private static List<Employee> employeeList() {
		return new ArrayList<Employee>() {{
			add(new Employee(1, "suman", 3000, "A", "IT"));
			add(new Employee(2, "vishwa", 4000, "B", "ADMIN"));
			add(new Employee(3, "sunil", 8000, "C", "HR"));
			add(new Employee(4, "vikash", 2000, "A", "FLM"));
			add(new Employee(4, "raja", 6000, "A", "IT"));
		}};
	}



	public static void salaryAndGradePay(List<Employee> employees) {
		         employees.stream()
				.filter(e -> e.getSalary() > 5000 && e.getGrade().equals("A")).
				collect(Collectors.toList()).forEach((employee -> System.out.println(employee.getName())));

	}

	public static void findLowestSalaryEmployee(List<Employee> employees) {
	Optional<Employee>	employee= employees.stream().min(Comparator.comparingInt(Employee::getSalary));
	employee.ifPresent(System.out::println);
//             int lowestSalary=    employees.stream().
//				collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
//						.firstEntry().getValue().stream().findFirst().get().getSalary();
		//System.out.println("Lowest Salary: "+lowestSalary);

	}

	public static void findHighestSalaryEmployee(List<Employee> employees) {
		Optional<Employee> employee =	employees.stream().max(Comparator.comparingInt(Employee::getSalary));
		employee.ifPresent(System.out::println);
		//             int highestSalary=    employees.stream().
//				collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
//				.lastEntry().getValue().stream().findFirst().get().getSalary();
		//System.out.println("Lowest Salary: "+highestSalary);

	}


	private static void groupEmployeesByDepartment(List<Employee> employees) {

		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()))
				.entrySet().stream().forEach(entry -> {
					System.out.println(entry.getKey() + "::" + entry.getValue());
				});

	}

	private static void partitionEmployeesBySalary(List<Employee> employees){

		Map<Boolean,List<Employee>> partitioning=
				employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary()>4000));

		partitioning.forEach((key,value)->{
			System.out.println(key);
			value.forEach(System.out::println);
		});
	}

}
