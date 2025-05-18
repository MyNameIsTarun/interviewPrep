package solid;

/*
 * Interface Segregation Principle
 * A class should not be forced to implement interfaces it does not use. In other words, 
 * a class should only implement the methods that are relevant to its behavior.
 * A Interface should only be responsible to provide a single functionality.
 */
public class ISP {
	
	// Here worker implementing class has to provide implementation to the eat() method although he only wanted to work, 
	// forcing implementing class to provide implementation of the methods that it will not use.
	// Before
	interface Worker {
	    void work();
	    void eat();
	}

	class SuperWorker implements Worker {
	    @Override
	    public void work() {
	        // logic for working
	    }

	    @Override
	    public void eat() {
	        // logic for eating
	    }
	}
	
	// -----------------------------------------------------------------------------------------------------

	// Here we segregated the interfaces to provide only one functionality so that the implementing class can choose,
	// what functionality they want to provide/extend
	// After
	interface Workable {
	    void work();
	}

	interface Eatable {
	    void eat();
	}

	class SuperWorker1 implements Workable {
	    @Override
	    public void work() {
	        // logic for working
	    }
	}


}
