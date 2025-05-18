package solid;

/*
 * Open/Closed Principle
 * Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. 
 * This means that you should be able to add new functionality without changing existing code.
 */
public class OCP {
	
	// Before
	// Here we created a separate Rectangle class and separate AreaCalculator class for calculating its area
	// now if we want to add similar functionality for Circle we either need to rewrite these classes or make 
	// separate classes for it
	class Rectangle {
	    int width;
	    int height;
	}

	class AreaCalculator {
	    int calculateArea(Rectangle rectangle) {
	        return rectangle.width * rectangle.height;
	    }
	}
	
	//----------------------------------------------------------------------------------------------------------------

	// After
	// As a good design here we created a generic interface called Shape having calculateArea() abstract method
	// now this can be easily extended by Rectangle and Circle classes to provide their own implementation without
	// modifying existing or each others code
	interface Shape {
	    int calculateArea();
	}

	class Rectangle1 implements Shape {
	    int width;
	    int height;

	    @Override
	    public int calculateArea() {
	        return width * height;
	    }
	}

	class Circle implements Shape {
	    int radius;

	    @Override
	    public int calculateArea() {
	        return (int) (Math.PI * radius * radius);
	    }
	}

}
