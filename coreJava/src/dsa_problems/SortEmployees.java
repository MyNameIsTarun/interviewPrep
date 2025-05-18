package dsa_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import coreJava.Employee;

/*
 * Given an employee list, sort the list by firstname, lastname & email using stream api
 */
public class SortEmployees {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "John", "Doe", "john@doe.com", null));
		list.add(new Employee(72, "Snow", "Doe", "snow@doe.com", null));
		list.add(new Employee(22, "John", "Doe", "john@doe.com", null));
		list.add(new Employee(33, "Snow", "Simon", "snow@doe.com", null));
		list.add(new Employee(8, "John", "Doe", "xyz@doe.com", null));
		list.add(new Employee(8, "Chetan", "Doe", "john@doe.com", null));
		list.add(new Employee(8, "Chetan", "Doe", "chetan@doe.com", null));
		list.add(new Employee(4, "John", "Doe", "john@doe.com", null));
		list.add(new Employee(28, "Deepak", "Yadav", "deepak@doe.com", null));
		list.add(new Employee(32, "Tarun", "Kanade", "tarun@doe.com", null));
		list.add(new Employee(47, "Dev", "Sharma", "dev@doe.com", null));
		list.add(new Employee(47, "Dev", "Verma", "dev@doe.com", null));
		list.add(new Employee(47, "Dev", "Verma", "abc@doe.com", null));
		
		List<Employee> sortedList = list.stream().sorted(Comparator.comparing(Employee::getFirstName)
								.thenComparing(Employee::getLastName).thenComparing(Employee::getEmail))
								.collect(Collectors.toList());
		
		for(Employee e : sortedList) {
			System.out.println(e);
		}
	}

}
