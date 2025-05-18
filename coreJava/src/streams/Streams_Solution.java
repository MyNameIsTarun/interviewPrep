package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
 
public class Streams_Solution {

	public static void main(String[] args) {
		
		List<Employee> employeelist = new ArrayList<>();
		
		employeelist.add(new Employee(111, "Jiya Berin", 32, "female", "HR", 2011, 25500.00));
        employeelist.add(new Employee(122, "Paul Nekin", 25, "male", "Sales and Marketing", 2015, 35500.00));
        employeelist.add(new Employee(133, "Cjiya Berin", 29, "female", "Security and transport", 2011, 45500.00));
        employeelist.add(new Employee(144, "Biya Kumar", 28, "female", "HR", 2013, 55500.00));
        employeelist.add(new Employee(155, "Jiya Berin1", 21, "male", "Account and finance", 2011, 35530.00));
        employeelist.add(new Employee(166, "Jiya Berin2", 20, "female", "Sales and Marketing", 2011, 35300.00));
        employeelist.add(new Employee(177, "Jiya Berin3", 99, "male", "Infrastructure", 2011, 45500.00));
        employeelist.add(new Employee(188, "Jiya Berin4", 33, "male", "Product development", 2000, 25500.00));
        employeelist.add(new Employee(199, "Jiya Berin5", 45, "female", "Sales and Marketing", 2022, 29500.00));
        employeelist.add(new Employee(200, "Jiya Berin6", 33, "male", "HR", 2017, 22100.00));
        employeelist.add(new Employee(211, "Niya Berin7", 64, "female", "HR", 2006, 88500.00));
        employeelist.add(new Employee(222, "Jiya Berin8", 12, "male", "Security and transport", 2011, 77500.00));
        employeelist.add(new Employee(233, "Kiya Berin9", 10, "male", "Product development", 2015, 66500.00));
        employeelist.add(new Employee(244, "Jiya Berin10", 89, "female", "Account and finance", 2023, 55500.00));
        employeelist.add(new Employee(255, "Jiya Berlin11", 65, "male", "Security and transport", 2032, 43500.00));
        employeelist.add(new Employee(266, "Ali Baig", 43, "male", "Product development", 2022, 234500.00));
        
      //1. how many males and females are there in employee
        Map<String, Long> map = employeelist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male and Female count: " + map);
        
      //2. Print the name of all departments in the organization
        List<String> list = employeelist.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("All departments: " + list);
        
      //3. What is the average age of male and female employees
        Map<String, Double> mapDouble = employeelist.stream()
        		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("Avg age of male and female: " + mapDouble);
        
      //4. Get the details of highest paid employee in the organization
        Optional<Employee> emp = employeelist.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("Employee having highest sal: " + emp.get());
        
      //5. Get the names of all employees who have joined after 2015
        list = employeelist.stream().filter(e -> e.getYear() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println("Employees joined after 2015: " + list);
        
      //6. Count the number of employees in each department
        map = employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Employees in each department: " + map);
        
      //7. What is the avg salary of each department
        mapDouble = employeelist.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Avg sal of each department: " + mapDouble);
        
      //8. Get the details of youngest male employee in the product and development dept:
        emp = employeelist.stream().filter(e -> {
        	return e.getDepartment().equals("Product development") && e.getGender().equals("male");
        }).min(Comparator.comparing(Employee::getAge));
        System.out.println("Youngest male employee in Pro&Dev dept: " + emp.get());
        
      //9. Who has the most working experience in the organization
        emp = employeelist.stream().min(Comparator.comparing(Employee::getYear));
        System.out.println("Most exp: " + emp.get());
        
      //10. How many male and female employees are there in sales and marketing team:
        map = employeelist.stream().filter(e -> e.getDepartment().equals("Sales and Marketing"))
        		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male and Females in Sales&Marketing dept: " + map);
        
      //11. What is the avg salary of male and female employees:
        mapDouble = employeelist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Avg salary of male and females: " + mapDouble);
        
      //12. List down the names of all employees in each department:
        Map<String, List<Employee>> mapList = employeelist.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(mapList);
        Map<String, String> deptNameList = employeelist.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.joining(","))));
        System.out.println(deptNameList);
        
      //13. What is the avg salary and total salary of the whole organization:
        System.out.println(employeelist.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));
        
      //14. Separate the employees who are younger or equal to 25 years from those who are older than 25 years:
        list = employeelist.stream().filter(e -> e.getAge() <= 25).map(Employee::getName).collect(Collectors.toList());
        System.out.println("Employees younger than 25 years: " + list);
        System.out.println("Employees younger than 25 years: \n" + employeelist.stream()
        .collect(Collectors.partitioningBy(e -> e.getAge() > 25, Collectors.mapping(Employee::getName, Collectors.joining(", ")))));
        
      //15. Who is the oldest employee in the organization. What is his age and which departments he belongs to:
        emp = employeelist.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println(emp.get());
        
      //16.find out the highest salary of each dept
        Map<String, Optional<Employee>> mapStrEmp = employeelist.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("Highest sal of each dept: ");
        mapStrEmp.forEach((a, b) -> System.out.println(a + ": " + b.get().getSalary()));
        
      //18. sort int list in dec order of frequency
        List<Integer> intlist = Arrays.asList(5,1,2,3,4,1,2,3,4,1,4,1);
        intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        		.entrySet().stream().sorted((Map.Entry.comparingByValue(Comparator.reverseOrder()))).collect(Collectors.toList())
        		.forEach(entry -> {
                    for(int i=0; i<entry.getValue(); i++){
                        System.out.print(entry.getKey()+", ");
                    }
                });
        System.out.println();
        
      //19. Write a Java 8 program to find the first element in a list using streams.
        System.out.println(intlist.stream().findFirst().get());
        
      //20. Write a Java 8 program to remove duplicate elements from a list using streams.
        System.out.println(intlist.stream().distinct().collect(Collectors.toList() ));
        
      //21. Write a Java 8 program to find the average of a list of integers using streams.
        System.out.println(intlist.stream().collect(Collectors.averagingInt(e -> e)));
        
      //22. Write a Java 8 program to group a list of students by their grades using streams.
        List<Student> studentList = Arrays.asList(
                new Student(1, "Nirmal", 90),
                new Student(1, "Kirti", 23),
                new Student(1, "nirmal1", 34),
                new Student(1, "Priti", 90),
                new Student(1, "Tripti", 34)
        );
        System.out.println(studentList.stream()
        		.collect(Collectors.groupingBy(Student::getGrades, Collectors.mapping(Student::getName, Collectors.joining(", ")))));
        
      //23. Write a Java 8 program to sort a list of strings in alphabetical order using streams.
        List<String> listOfStrings = Arrays.asList("Nirmal", "Tripti", "Kirti", "Priti", "nirmal1", "Priti1");
        System.out.println(listOfStrings.stream().sorted().collect(Collectors.toList()));
        
      //24. Write a Java 8 program to concatenate all the strings in a list using streams.
        System.out.println(listOfStrings.stream().collect(Collectors.joining(" ")));

        //25.Write a Java 8 program to find the maximum and minimum values in a list of integers using streams.
        System.out.println(intlist.stream().collect(Collectors.summarizingInt(e -> e)));

        //26. Write a Java 8 program to convert a list of strings to uppercase using streams.
        System.out.println(listOfStrings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()));

        //27. Write a Java 8 program to find the sum of all the integers in a list using streams.
        System.out.println(intlist.stream().reduce((a, b) -> a+b).get());

        //28. Write a Java 8 program to filter out all the even numbers from a list of integers using streams.
        System.out.println(intlist.stream().filter(a -> a%2 == 0).collect(Collectors.toList()));

        //29. Write a Java 8 program to find the number of words in a list of sentences using streams
        //"Nirmal1", "Tripti", "Kirti", "Priti", "nirmal1", "Priti1"
        List<String> listOfSent = Arrays.asList("Hello World", "How are you", "A quick brown fox", "String");
        System.out.println(listOfSent.stream().map(s -> s.split(" ").length).collect(Collectors.toList()));

        //30. Write a Java 8 program to find the length of the longest string in a list of strings using streams.
        System.out.println(listOfSent.stream().mapToInt(String::length).max().getAsInt());
        
      //31.Write a Java 8 program to partition a list of integers into two lists of even and odd numbers using streams.
        System.out.println(intlist.stream().collect(Collectors.partitioningBy(e -> e%2 == 0)));

        //32. Write a Java 8 program to find the frequency of each element in a list using streams.
        System.out.println(intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //33.Write a Java 8 program to find the second-highest element in a list of integers using streams.
        List<Integer> intlist2 = Arrays.asList(11,10,92,91,34,22,32);
        System.out.println(intlist2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        //34. Write a Java 8 program to find the sum of the squares of all the odd numbers in a list using streams.
        System.out.println(intlist.stream().filter(e -> e%2 != 0).mapToInt(e -> e*e).sum());

        //35. Write a Java 8 program to find the maximum value of a list of objects using streams.
        System.out.println(intlist2.stream().sorted(Comparator.reverseOrder()).findFirst().get());

        //Student with max grades
        System.out.println(studentList.stream().sorted((a,b) -> b.getGrades()-a.getGrades()).findFirst().get());
        System.out.println("-----" + studentList.stream().sorted(Comparator.comparing(Student::getGrades, Comparator.reverseOrder())).findFirst().get());

        //36. Write a Java 8 program to convert a list of objects to a map using streams.
        System.out.println(intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println(intlist.stream().collect(Collectors.toMap(Function.identity(), String::valueOf, (v1, v2) -> v1, LinkedHashMap::new)));

        //37. Write a Java 8 program to find the number of times a word appears in a list of sentences using streams.
        List<String> sentences = Arrays.asList(
                "The fox quick brown fox jumps over the lazy fox dog",
                "The quick brown fox aaaa",
                "The lazy dog"
        );
        System.out.println(sentences.stream().flatMap(str -> Arrays.stream(str.split(" "))).filter(s -> s.equals("fox")).count());
        sentences.forEach(str -> System.out.println(Arrays.stream(str.split(" ")).filter(s -> s.equals("fox")).count()));

        //38. Write a Java 8 program to filter out all the strings that contain a particular character from a list of strings using streams.
        System.out.println(listOfStrings.stream().filter(s -> s.indexOf('p') >= 0).collect(Collectors.toList()));

        //39. Write a Java 8 program to flatten a list of lists into a single list using flatMap.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        System.out.println(listOfLists.stream().flatMap(s -> s.stream()).collect(Collectors.toList()));

        //40. Write a Java 8 program to find all the unique words in a list of sentences using flatMap.
        System.out.println(sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().collect(Collectors.toList()));

	}

}
