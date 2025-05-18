package desing_pattern;

import java.util.ArrayList;
import java.util.List;

/*
 * The Observer design pattern is a behavioral pattern that defines a one-to-many dependency between objects so that when one object changes state, 
 * all its dependents (observers) are notified and updated automatically. 
 * 
 * The Observer pattern promotes loose coupling between components. Subjects and observers can be developed independently, and new observers 
 * can be added or removed without modifying the subject. This enhances the maintainability and flexibility of the software.
 */
public class Observer {
	
	public interface ObserverI {
	    void update(String message);
	}

	public interface Subject {
	    void attach(ObserverI observer);
	    void detach(ObserverI observer);
	    void notifyObservers(String message);
	}

	public class ConcreteObserver implements ObserverI {
	    private String name;

	    public ConcreteObserver(String name) {
	        this.name = name;
	    }

	    @Override
	    public void update(String message) {
	        System.out.println(name + " received message: " + message);
	    }
	}

	public class ConcreteSubject implements Subject {
	    private List<ObserverI> observers = new ArrayList<>();

	    @Override
	    public void attach(ObserverI observer) {
	        observers.add(observer);
	    }

	    @Override
	    public void detach(ObserverI observer) {
	        observers.remove(observer);
	    }

	    @Override
	    public void notifyObservers(String message) {
	        for (ObserverI observer : observers) {
	            observer.update(message);
	        }
	    }
	}
	
	    public static void main(String[] args) {
	    	Observer obs = new Observer();
	        ConcreteSubject subject = obs. new ConcreteSubject();

	        ObserverI observer1 = obs.new ConcreteObserver("Observer 1");
	        ObserverI observer2 = obs.new ConcreteObserver("Observer 2");
	        ObserverI observer3 = obs.new ConcreteObserver("Observer 3");
	        ObserverI observer4 = obs.new ConcreteObserver("Observer 4");

	        subject.attach(observer1);
	        subject.attach(observer2);
	        subject.attach(observer3);
	        subject.attach(observer4);

	        subject.notifyObservers("State change message");
	        subject.detach(observer3);
	        subject.notifyObservers("Tarun");
	    }
	   
	    /*
	     * Used in java?
	     * => GUI event handlers
	     * => Java Message Service (JMS)
	     * => Spring Framework
	     * 
	     * Applications?
	     * => Distributed and Messaging systems
	     * => Database triggers
	     * => System monitoring and alarming (stock market)
	     */
}
