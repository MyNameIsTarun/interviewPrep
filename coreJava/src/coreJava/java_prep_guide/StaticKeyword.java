package coreJava.java_prep_guide;

/*
 * When we create a static variable or method it is stored in the special area on heap: PermGen(Permanent Generation), 
 * where it lays down with all the data applying to classes(non-instance data). Starting from Java 8 the PermGen became - Metaspace.
 * 
 * A static variable is initialised only, when the class is first loaded into the JVM, which happens the first time it is referenced in code, 
 * not when the instance is created.
 * 
 * Static methods are stored in Metaspace space of native heap as they are associated to the class in which they reside not to the objects of that class. 
 * But their local variables and the passed arguments are stored in the stack.
 */
public class StaticKeyword {
	
	private int id;
	
	/*
	 * Fields that have the static modifier in their declaration are called static fields or class variables. 
	 * They are associated with the class, rather than with any object. Every instance of the class shares a class variable, 
	 * which is in one fixed location in memory. Any object can change the value of a class variable, but class variables 
	 * can also be manipulated without creating an instance of the class.
	 * 
	 * Class variables are referenced by the class name itself
	 * 		- This makes it clear that they are class variables.
	 * You can also refer to static fields with an object reference
	 * 		- but this is discouraged because it does not make it clear that they are class variables.
	 * 
	 * Constants:
	 * The static modifier, in combination with the final modifier, is also used to define constants. 
	 * The final modifier indicates that the value of this field cannot change.
	 * Constants defined in this way cannot be reassigned, and it is a compile-time error if your program tries to do so.
	 * 
	 * Note: If a primitive type or a string is defined as a constant and the value is known at compile time, 
	 * the compiler replaces the constant name everywhere in the code with its value. This is called a compile-time constant. 
	 * If the value of the constant in the outside world changes (for example, if it is legislated that pi actually should be 3.975), 
	 * you will need to recompile any classes that use this constant to get the current value.
	 * 
	 * static blocks are also used to initialize static variables or to do some work when the class is loaded into the JVM memory.
	 */
	public static int staticField = 0;
	
	
	/*
	 * Static methods, which have the static modifier in their declarations, should be invoked with the class name, 
	 * without the need for creating an instance of the class
	 * 
	 * You can also refer to static methods with an object reference
	 * 		- but this is discouraged because it does not make it clear that they are class methods.
	 * 
	 * A common use for static methods is to access static fields. otherwise for writing utility functions
	 * 
	 * Not all combinations of instance and class variables and methods are allowed:
	 * 		- Instance methods can access instance variables and instance methods directly.
	 * 		- Instance methods can access class variables and class methods directly.
	 * 		- Class methods can access class variables and class methods directly.
	 * 		- Class methods cannot access instance variables or instance methods directly—they must use an object reference. 
	 * 			Also, class methods cannot use the this keyword as there is no instance for this to refer to.
	 * 
	 * Method reference:
	 * 		MyClass::myStaticMethod starting from Java 8.
	 * 
	 * Can a static method be overriden?
	 * => No, Static methods in Java cannot be overridden. This is because static methods are not associated with the instance of a class, 
	 * 		but with the class itself. Therefore, when a subclass inherits a static method from its parent class, 
	 * 		it cannot modify the behavior of the static method in any way.
	 */
	public static void staticMethod() {
		System.out.println(staticField);
	}
	
	public static void staticMethod(int id, String name) {
		System.out.println(id);
		System.out.println(name);
	}
	
	public static void staticMethod(String name, int id) {
		System.out.println(id);
		System.out.println(name);
	}

	public static void main(String[] args) {
		StaticKeyword.staticMethod();
		StaticKeyword.staticMethod(1, "Tarun");
		StaticKeyword.staticMethod("Chetan", 2);
	}

}
