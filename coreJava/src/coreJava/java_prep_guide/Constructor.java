package coreJava.java_prep_guide;

import java.sql.SQLException;

/*
 * Constructor declarations look like method declarations—except that they use the name of the class and have no return type.
 * if a return type added to them then they will be considered as normal instance methods.
 * 
 * The compiler automatically provides a no-argument, default constructor for any class without constructors. 
 * This default constructor will call the no-argument constructor of the superclass. In this situation, 
 * the compiler will complain if the superclass doesn't have a no-argument constructor so you must verify that it does. 
 * If your class has no explicit superclass, then it has an implicit superclass of Object, which does have a no-argument constructor.
 * 
 * Parents no-arg constructor is always called automatically from all the constructors of the base class.
 * it will not be called if the constructor we are invoking of the child class explicitly calls some argumented constructor of parent using super(...).
 */
public class Constructor extends Demo {
	
	private String name;
	private int id;

	private static int i = 10;
	
	{
		System.out.println("Hello in initializer block + " + name + " " + id);
	}
	
	static {
		System.out.println("In static block");
		System.out.println("i = " + i);
		i = 20;
	}
	
	public Constructor() {
		name = "default";
		id = 0;
	}
	
	public Constructor(String name, int id) {
		super(23);
		this.name = name;
		this.id = id;
		
		{
			System.out.println("Hello in constructor");
		}
	}
	
	
	public Constructor(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	// hides the staticMethod() of parent (Demo)
	public static void staticMethod() {
		System.out.println("Constructor.staticMethod() called");
	}
	
	// compile time error as parent and child return types are of diff families
//	@Override
//	public String methodToBeOverriden() {
//		return "Hello";
//	}
	
	/*
	 * if the parent class method throws checked(compile time) exception then child method can only throw same, child or unchecked exceptions
	 * or no exception at all
	 */
	@Override
	public void throwsException() throws NullPointerException {
		System.out.println("child method");
		
		{
			System.out.println("Hello in method");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Constructor cons = new Constructor("Tarun", 100);
		Demo demo = new Constructor("Tarun", 100);
		
		System.out.println(cons.getEmployeeId());
		
		staticMethod();
		cons.staticMethod();
		demo.staticMethod();
		
		cons.throwsException();
		
		System.out.println("In main method, i = " + Constructor.i);
	}

}
