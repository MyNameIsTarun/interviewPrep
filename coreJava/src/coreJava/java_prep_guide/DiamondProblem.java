package coreJava.java_prep_guide;

// Using Interfaces we can solve the diamond problem
public class DiamondProblem implements Interface1, Interface2, Interface3, Interface4 {

	public static void main(String[] args) {
		new DiamondProblem().display();
		new DiamondProblem().defaultDisplay();
	}

	@Override
	public void display() {
		System.out.println("Overrided display");
	}
	
	@Override
	public void defaultDisplay() {
		System.out.println("Overrided defaultDisplay");
		
		Interface3.super.defaultDisplay();
		Interface4.super.defaultDisplay();
	}

}

interface Interface1 {
	void display();
}

interface Interface2{
	void display();
}

interface Interface3 {
	default void defaultDisplay() {
		System.out.println("dispaly in interface3");
	}
}

interface Interface4{
	default void defaultDisplay() {
		System.out.println("dispaly in interface4");
	}
}

/*
 On the other hand, Java does not allow interfaces to extend classes. This design choice is based on the fundamental difference in the 
 nature and purpose of interfaces and classes:

Interfaces Define Contracts:
Interfaces in Java are primarily used to define contracts or sets of abstract methods that concrete classes must implement. They serve as a 
way to specify what functionality a class should provide without dictating the implementation details.

Multiple Inheritance of Interfaces:
By allowing interfaces to extend other interfaces, Java supports a form of multiple inheritance for interface types. This enables a class 
to implement multiple interfaces, inheriting and providing implementations for the abstract methods declared in those interfaces.

Class Inheritance Represents Implementation:
Classes in Java, on the other hand, represent concrete implementations of behavior. When a class extends another class, it is inheriting 
both the structure (fields and methods) and the implementation details of the parent class.

Diamond Problem:
Allowing a class to extend multiple classes could lead to the "diamond problem," where ambiguity arises if two superclasses have a method 
with the same signature. Java avoids this issue by allowing a class to extend only one class.
 */
