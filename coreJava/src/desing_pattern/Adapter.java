package desing_pattern;

/*
 * The Adapter design pattern is a structural pattern that allows incompatible interfaces to work together. 
 * It acts as a bridge between two incompatible interfaces by converting the interface into another interface that a client expects. 
 * This pattern is particularly useful when integrating new functionalities or systems that have different interfaces.
 */
public class Adapter {
	
	// Create the interface that the client expects to work with.
	public interface Target {
	    void request();
	}
	
	public interface AdapteeI{
		void specificRequest();
	}

	// Implement the class with the incompatible interface (AdapteeI).
	public class Adaptee implements AdapteeI {
	    public void specificRequest() {
	        System.out.println("Adaptee's specific request");
	    }
	}
	
	// Implement the adapter class that implements the target interface and wraps an instance of the adaptee.
	public class AdapterR implements Target {
	    private AdapteeI adaptee;

	    public AdapterR(AdapteeI adaptee) {
	        this.adaptee = adaptee;
	    }

	    @Override
	    public void request() {
	        adaptee.specificRequest();
	    }
	}

	// The client interacts with the target interface without being aware of the underlying implementation.
	public static void main(String[] args) {
        Target target = new Adapter().new AdapterR(new Adapter().new Adaptee());
	    target.request();
    }
	
	/*
	 * Key Points
	 * => The Adapter pattern allows existing classes to work with new classes without modifying their code.
	 * => There are two variations of the Adapter pattern: class adapter (using inheritance) and object adapter (using composition). 
	 * 		In the example above, the object adapter approach is used.
	 * => Adapters can be one-way or two-way. One-way adapters only adapt from adaptee to target, while two-way adapters adapt in both directions.
	 * => The Adapter pattern is commonly used in scenarios where third-party libraries or legacy code need to be integrated into a system 
	 * 		with a different interface.
	 */

	// Legacy class
	public class LegacySystem {
	    public void specificRequest() {
	        System.out.println("Legacy System's specific request");
	    }
	}
	
	// This way, the new system can interact with the Adapter class, which in turn uses the LegacySystem to fulfill the request.

	// Adapter for integrating with the new system
	public class Adapter2 implements Target {
	    private LegacySystem legacySystem;

	    public Adapter2(LegacySystem legacySystem) {
	        this.legacySystem = legacySystem;
	    }

	    @Override
	    public void request() {
	        legacySystem.specificRequest();
	    }
	}
	
	/*
	 * Used in java?
	 * => The java.sql package provides interfaces like Connection, Statement, and ResultSet. 
	 * 		Different database vendors provide their own implementations (adaptees) of these interfaces, 
	 * 		and JDBC drivers act as adapters to make them work with the standard JDBC interfaces.
	 * => the @RequestMapping annotation in Spring MVC can be adapted to different HTTP methods using the method attribute.
	 * => If you have an array and want to treat it as a list, you can use the asList method, which returns a List view of the array. 
	 * 		The returned list is actually an adapter.
	 * 
	 * Applications?
	 * => When integrating new systems with existing legacy systems that have different interfaces, 
	 * 		the Adapter pattern can be applied to make the new system compatible with the legacy interfaces.
	 * => When working with third-party libraries or APIs that have interfaces incompatible with your application, 
	 * 		the Adapter pattern allows you to create adapters that make these libraries seamlessly integrate with your code.
	 */

}
