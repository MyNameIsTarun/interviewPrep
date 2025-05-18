package streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo1 {
    static List<Employee> employeelist = new ArrayList<>();
    public static void main(String[] args) {
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
        Map<String, Long> maleAndFemaleCount = employeelist.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.counting())
        );
        employeelist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("maleAndFemaleCount:" +maleAndFemaleCount);

        //2. Print the name of all departments in the organization
        List<String> deptartmentNameList = employeelist.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        employeelist.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("deptartmentNameList: "+deptartmentNameList);

        //3. What is the average age of male and female employees
        Map<String, Double> avgAgeOfMaleAndFemale = employeelist.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))
        );
        System.out.println("avgAgeOfMaleAndFemale:" +avgAgeOfMaleAndFemale);

        //4. Get the details of highest paid employee in the organisation
        Optional<Employee> highestPaidEmp = employeelist.stream().max(Comparator.comparingDouble(Employee::getSalary));
        employeelist.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("highestPaidEmp: "+highestPaidEmp.get().getSalary() + ", "+highestPaidEmp.get().getName());

        //5. Get the names of all employees who have joined after 2015
        List<String> empNameWhoJoinedAfter2015 = employeelist.stream().filter(e -> e.getYear() > 2015)
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println("empNameWhoJoinedAfter2015: "+ empNameWhoJoinedAfter2015);

        //6. Count the number of employees in each department
        Map<String, Long> noOfEmpInEachDept = employeelist.stream().collect(
          Collectors.groupingBy(Employee::getDepartment, Collectors.counting())
        );
        System.out.println("noOfEmpInEachDept: "+noOfEmpInEachDept);

        //7. What is the avg salary of each department
        Map<String, Double> avgSalaryOfEachDept = employeelist.stream().collect(
            Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))
        );
        System.out.println("avgSalaryOfEachDept: "+avgSalaryOfEachDept);

        //8. Get the details of youngest male employee in the product and development dept:
        String youngestMaleEmpInPDDept = employeelist.stream().filter(e ->
                        ("Product development").equals(e.getDepartment()) && ("male").equals(e.getGender())).
                min(Comparator.comparingInt(Employee::getAge)).get().getName();
        System.out.println("youngestMaleEmpInPDDept: "+youngestMaleEmpInPDDept);

        //9. Who has the most working experience in the organization
        String mostWorkingExpEmp = employeelist.stream().min(Comparator.comparingInt(Employee::getYear)).get().getName();
        System.out.println("mostWorkingExpEmp: "+mostWorkingExpEmp);

        //10. How many male and female employees are there in sales and marketing team:
        Map<String, Long> maleAndFemaleCountInSalesDept = employeelist.stream().filter(e -> ("sales and marketing").equals(e.getDepartment()))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("maleAndFemaleCountInSalesDept:" +maleAndFemaleCountInSalesDept);

        //11. What is the avg salary of male and female employees:
        Map<String, Double> avgSalaryOfMaleAndFemale = employeelist.stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("avgSalaryOfMaleAndFemale:"+avgSalaryOfMaleAndFemale );

        //12. List down the names of all employees in each department:
        Map<String, String> nameOfAllEmpInEachDept =
                employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.joining(","))));
        System.out.println("nameOfAllEmpInEachDept: "+nameOfAllEmpInEachDept);

        //13. What is the avg salary and total salary of the whole organization:
        System.out.println(employeelist.stream().collect(
                Collectors.summarizingDouble(Employee::getSalary)
        ));

        //14. Separate the employees who are younger or equal to 25 years from those who are older than 25 years:
        System.out.println(employeelist.stream().collect(
                Collectors.partitioningBy(e -> e.getAge()>25, Collectors.mapping(Employee::getName, Collectors.joining(","))))
        );

        //15. Who is the oldest employee in the organization. What is his age and which departments he belongs to:
        employeelist.stream().min(Comparator.comparingInt(Employee::getAge));

        //16.find out the highest salary of each dept
        Map<String, Optional<Employee>> highestSalOfEachDept = employeelist.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                )
        );
        highestSalOfEachDept.forEach((dept, emp) -> System.out.println(emp.get().getDepartment() +": "+emp.get().getName()));
        //System.out.println("highestSalOfEachDept:"+highestSalOfEachDept);

        //17.find out the highest salary of each dept
        System.out.println(employeelist.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collector.of(
                                ArrayList::new,
                                (list, emp) -> {
                                   list.add(emp.getSalary());
                                   Collections.sort(list, Collections.reverseOrder());
                                   if(list.size() > 2){
                                       list.remove(2);
                                   }
                                },
                                (list1, list2) -> {
                                    list1.addAll(list2);
                                    return list1;
                                }
                        )
                )
        ));

        //18. sort it in dec order of frequency
        //ip: 1,2,3,4,1,2,3,4,1,4,1
        //op: 1,4,3,2

        List<Integer> list = Arrays.asList(1,2,3,4,1,2,3,4,1,4,1);
        //without stream:
        System.out.println(sortBasedOnFreq(list));

        //using stream:
        list.stream().collect(
                Collectors.groupingBy(e -> e, Collectors.counting())
        ).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for(int i=0; i<entry.getValue(); i++){
                        System.out.print(entry.getKey()+", ");
                    }
                });
        System.out.println("");

        //19. Write a Java 8 program to find the first element in a list using streams.
        List<Integer> list1 = Arrays.asList(53,1,2,3,4,1,2,3,4,1,4,1);
        System.out.println(list1.stream().findFirst());

        //20. Write a Java 8 program to remove duplicate elements from a list using streams.
        System.out.println(list1.stream().distinct().collect(Collectors.toList()));

        //21. Write a Java 8 program to find the average of a list of integers using streams.
        System.out.println(list1.stream().collect(Collectors.averagingInt(e -> e)));

        //22. Write a Java 8 program to group a list of students by their grades using streams.
        List<Student> studentList = Arrays.asList(
                new Student(1, "Nirmal", 90),
                new Student(1, "Kirti", 23),
                new Student(1, "nirmal1", 34),
                new Student(1, "Priti", 90),
                new Student(1, "Tripti", 34)
        );
        System.out.println(studentList.stream().collect(Collectors.groupingBy(
                Student::getGrades, Collectors.mapping(Student::getName, Collectors.joining(","))
        )));

        //23. Write a Java 8 program to sort a list of strings in alphabetical order using streams.
        List<String> listOfStrings = Arrays.asList("Nirmal", "Tripti", "Kirti", "Priti", "nirmal1", "Priti1");
        System.out.println(listOfStrings.stream().sorted(Comparator.comparing(e -> e)).collect(Collectors.toList()));

        //24. Write a Java 8 program to concatenate all the strings in a list using streams.
        System.out.println(listOfStrings.stream().collect(Collectors.joining(",")));

        //25.Write a Java 8 program to find the maximum and minimum values in a list of integers using streams.
        System.out.println(list1.stream().collect(Collectors.summarizingDouble(e -> e)));

        //26. Write a Java 8 program to convert a list of strings to uppercase using streams.
        System.out.println(listOfStrings.stream().map(e -> e.toUpperCase()).collect(Collectors.toList()));

        //27. Write a Java 8 program to find the sum of all the integers in a list using streams.
        System.out.println(list1.stream().collect(Collectors.summarizingInt(e -> e)));

        //28. Write a Java 8 program to filter out all the even numbers from a list of integers using streams.
        System.out.println(list1.stream().filter(e -> e%2 == 0).collect(Collectors.toList()));

        //29. Write a Java 8 program to find the number of words in a list of sentences using streams
        //"Nirmal1", "Tripti", "Kirti", "Priti", "nirmal1", "Priti1"
        System.out.println(listOfStrings.stream().map(e -> e.length()).collect(Collectors.toList()));

        //30. Write a Java 8 program to find the length of the longest string in a list of strings using streams.
        System.out.println(listOfStrings.stream().mapToInt(String::length).max());

        //31.Write a Java 8 program to partition a list of integers into two lists of even and odd numbers using streams.
        System.out.println(list1.stream().collect(Collectors.partitioningBy(e -> (e%2 == 0))));

        //32. Write a Java 8 program to find the frequency of each element in a list using streams.
        System.out.println(list1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())));

        //33.Write a Java 8 program to find the second-highest element in a list of integers using streams.
        List<Integer> list33 = Arrays.asList(11,10,92,91,34,22,32);
        System.out.println(list33.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());

        //34. Write a Java 8 program to find the sum of the squares of all the odd numbers in a list using streams.
        System.out.println(list.stream().filter(e -> e%2!=0).mapToInt(e -> e*e).sum());

        //35. Write a Java 8 program to find the maximum value of a list of objects using streams.
        System.out.println(list33.stream().sorted(Comparator.reverseOrder()).findFirst());

        //Student with max grades
        System.out.println(studentList.stream().max(Comparator.comparingInt(Student::getGrades)).get().getName());

        //36. Write a Java 8 program to convert a list of objects to a map using streams.
        System.out.println(studentList.stream().collect(Collectors.toMap(Student::getName, Student::getGrades)));

        //37. Write a Java 8 program to find the number of times a word appears in a list of sentences using streams.
        List<String> sentences = Arrays.asList(
                "The quick brown fox jumps over the lazy dog",
                "The quick brown foxaaaa",
                "The lazy dog"
        );
        System.out.println(sentences.stream().flatMap(line -> Arrays.stream(line.split("\\s+"))).collect(Collectors.toList()));
        System.out.println(sentences.stream().flatMap(line -> Arrays.stream(line.split("\\s+"))).
                filter(word -> word.equals("fox")).count());

        //38. Write a Java 8 program to filter out all the strings that contain a particular character from a list of strings using streams.
        System.out.println(listOfStrings.stream().filter(s -> s.contains("a")).collect(Collectors.toList()));

        //39. Write a Java 8 program to flatten a list of lists into a single list using flatMap.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        System.out.println(listOfLists.stream().flatMap(List::stream).collect(Collectors.toList()));

        //40. Write a Java 8 program to find all the unique words in a list of sentences using flatMap.
        List<String> sentences40 = Arrays.asList(
                "The quick brown fox jumps over the lazy dog",
                "The quick brown fox",
                "The lazy dog"
        );
        System.out.println(sentences40.stream().flatMap(line -> Arrays.stream(line.split("\\s+"))).distinct().collect(Collectors.toList()));
        //or
        System.out.println(sentences40.stream().flatMap(line -> Arrays.stream(line.split("\\s+"))).collect(Collectors.toSet()));

        //41. Write a Java 8 program to find the maximum value in a list of lists using flatMap.
        System.out.println(listOfLists.stream().flatMap(e -> e.stream()).sorted(Comparator.reverseOrder()).findFirst());

        //42. Write a Java 8 program to find the product of all the numbers in a list of lists using flatMap.
        System.out.println(listOfLists.stream().flatMap(Collection::stream).reduce(1, (a,b) -> a*b));

        //43. Write a Java 8 program to find the longest word in a list of sentences using flatMap.
        System.out.println(sentences.stream().flatMap(line -> Arrays.stream(line.split("\\s+")))
                .max(Comparator.comparingInt(String::length)));

        //44. Write a Java 8 program to find the average value of each sublist in a list of lists using flatMap.
        //listOfLists.stream().flatMap(Collection::stream);
        //listOfLists.stream().flatMap(List::stream).mapToInt(Integer::intValue).average();


        //45. Write a Java 8 program to find the first non-repeated character in a string using streams.
        String str = "aabbcddee";
        System.out.println(str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst());



        //46. Write a Java 8 program to find the common elements between two arrays of integers.
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {3, 5, 7, 9};
//        System.out.println(Arrays.stream(array1).boxed().collect(Collectors.toSet())
//                .stream().filter(i -> {
//                    Set<Integer> set = Arrays.stream(array2).boxed().collect(Collectors.toSet());
//                    return set.contains(i);
//                }).collect(Collectors.collect(Collectors.toList())));


        System.out.println(Arrays.stream(array1).filter(e -> Arrays.asList(array2).contains(e)).collect(Collectors.toList()));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 200);
        map.put(2, 4);
        map.put(3, 498);
        map.put(49090, 5);

        map.keySet().stream().filter(
              key -> map.get(key)%2 != 0
        ).forEach(System.out::println);


        String s= "abc123%d236";
        System.out.println(s.chars().mapToObj(c -> (char)c).filter(e -> Character.isDigit(e)).collect(Collectors.groupingBy(e->e, Collectors.counting())));
        System.out.println(s.chars().mapToObj(c -> (char)c).filter(e -> Character.isDigit(e)).collect(Collectors.groupingBy(e->e, Collectors.counting())));

        s.chars().map(c -> (char)c).forEach(System.out::print);
        System.out.println("");
        s.chars().mapToObj(c -> (char)c).forEach(System.out::print);


                //System.out.println(s.chars().mapToObj(c-> (char)c).filter(e->Character.isDigit(e)).collect(Collectors.groupingBy(e->e,Collectors.counting())));
        System.out.println("====");
        //finding elements in an integer array with a frequency greater than one
        int[] array = {1, 2, 1, 3, 4, 4};

        List<Integer> elementsWithFrequencyGreaterThanOne = new ArrayList<>();

        for (int num : array) {
            if (Collections.frequency(elementsWithFrequencyGreaterThanOne, num) > 1) {
                elementsWithFrequencyGreaterThanOne.add(num);
            }
        }
        System.out.println("elementsWithFrequencyGreaterThanOne:"+elementsWithFrequencyGreaterThanOne);


        employeelist.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();



    }

    private static List<Integer> sortBasedOnFreq(List<Integer> list){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            if(hm.containsKey(list.get(i))){
                hm.put(list.get(i), hm.get(list.get(i)) + 1);
            }else{
                hm.put(list.get(i), 1);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freq1 = hm.get(o1);
                int freq2 = hm.get(o2);
                if(freq1 != freq2){
                    return freq2 - freq1;
                } else {
                    return o2 - o1;
                }
            }
        });
        return list;

    }


}
