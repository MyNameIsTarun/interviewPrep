package solid;

/*
 * Liskov Substitution Principle
 * Subtypes must be substitutable for their base types without altering the correctness of the program.
 * A Child class should be able to be used at the place of their parent class providing similar functionality
 * without altering the code
 */
public class LSP {
	
	// Before
	// Here Penguin can't be used at the place of its parent Bird, because it does not provide all the functionalities
	// of its parent in the expected fashion
	class Bird {
	    void fly() {
	        // logic for flying
	    }
	}

	class Penguin extends Bird {
	    @Override
	    void fly() {
	        // Penguins cannot fly, so this method does nothing or throws an exception
	    }
	}
	
	// --------------------------------------------------------------------------------------------------

	// After
	// Here Bird and Penguin can be easily used at the place of their parent as they provide similar functionality
	// in the expected manner
	interface Flyable {
	    void fly();
	}
	
	interface Swimable{
		void swim();
	}

	class Bird1 implements Flyable {
	    @Override
	    public void fly() {
	        // logic for flying
	    }
	}

	class Penguin1 implements Swimable {
	    @Override
	    public void swim() {
	        // logic for swimming
	    }
	}

}
