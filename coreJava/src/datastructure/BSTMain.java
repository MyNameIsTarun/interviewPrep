package datastructure;

import coreJava.Employee;

public class BSTMain {

	public static void main(String[] args) {
		BST<Employee> empBst = new BST<>();
		
		System.out.println(empBst.contains(new Employee(33, "John", "Doe", "john@doe.com", null)) + " : --- expected false");
		
		System.out.println(empBst.getList());
		System.out.println("delete: " + new Employee(4, "John", "Doe", "john@doe.com", null));
		empBst.delete(new Employee(4, "John", "Doe", "john@doe.com", null));
		System.out.println(empBst.getList());
		System.out.println();

		empBst.insert(new Employee(1, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(72, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(22, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(33, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(8, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(8, "Chetan", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(8, "Chetan", "Doe", "chetan@doe.com", null));
		empBst.insert(new Employee(4, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(28, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(32, "John", "Doe", "john@doe.com", null));
		empBst.insert(new Employee(47, "John", "Doe", "john@doe.com", null));
		
		System.out.println(empBst.insert(new Employee(9, "John", "Doe", "john@doe.com", null)) + " : --- expected true");
		System.out.println(empBst.insert(new Employee(9, "John", "Doe", "john@doe.com", null)) + " : --- expected false");
		System.out.println(empBst.insert(new Employee(8, "Johns", "Doe", "john@doe.com", null)) + " : --- expected true");
		System.out.println(empBst.insert(null) + " : --- expected false");
		
		System.out.println(empBst.getList());
		System.out.println();
		
		System.out.println(empBst.contains(new Employee(33, "John", "Doe", "john@doe.com", null)) + " : --- expected true");
		System.out.println(empBst.contains(new Employee(34, "John", "Doe", "john@doe.com", null)) + " : --- expected false");
		System.out.println(empBst.contains(new Employee(33, "Johnp", "Doe", "john@doe.com", null)) + " : --- expected false");
		System.out.println(empBst.contains(new Employee(33, "John", "Doem", "john@doe.com", null)) + " : --- expected false");
		System.out.println(empBst.contains(null) + " : --- expected false");
		System.out.println();
		
		System.out.println("delete: " + null);
		empBst.delete(null);
		System.out.println(empBst.getList());
		
		System.out.println("delete: " + new Employee(4, "John", "Doe", "john@doe.com", null));
		empBst.delete(new Employee(4, "John", "Doe", "john@doe.com", null));
		System.out.println(empBst.getList());
		
		System.out.println("delete: " + new Employee(5, "John", "Doe", "john@doe.com", null));
		empBst.delete(new Employee(5, "John", "Doe", "john@doe.com", null));
		System.out.println(empBst.getList());
		
		System.out.println("delete: " + new Employee(28, "John", "Doe", "john@doe.com", null));
		empBst.delete(new Employee(28, "John", "Doe", "john@doe.com", null));
		System.out.println(empBst.getList());
		
		System.out.println("\n ---------------------------------------------- \n");
		
		BST<Integer> intBst = new BST<>();
		intBst.insert(54);
		intBst.insert(32);
		intBst.insert(67);
		intBst.insert(2);
		intBst.insert(4);
		intBst.insert(99);
		intBst.insert(55);
		
		System.out.println(intBst.getList());
		intBst.delete(54);
		System.out.println(intBst.contains(54) + " : --- expected false");
		System.out.println(intBst.getList());
		intBst.delete(2);
		System.out.println(intBst.getList());
		
	}

}
