package coreJava;

class Parent {

	static void staticMethod() {
		System.out.println("Static method in Parent");
	}
}

class Child extends Parent {
	static void staticMethod() {
		System.out.println("Static method in Child");
	}
}

public class StaticMethodTest {
	public static void main(String[] args) {
		Parent.staticMethod();
		Child.staticMethod();
		Child parent = new Child();
		parent.staticMethod();
	}
}
