package coreJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.List;

// https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
// We make the immutable class final to save it from being extended by subclasses which can provide mutable behavior
// and can exploit immutable nature of their base class
public class Immutable {
	
	private final String itemId;
	private final String itemName;
	private final List<String> tags;
	private final List<List<String>> groups;
	private final Employee employee;
	private final Instant date;
	
	public Immutable(String itemId, String itemName, List<String> tags, List<List<String>> groups, Employee employee, Instant date) {
		this.itemId = itemId;
		this.itemName = itemName;
		
		// it returns unmodifiable "view" of the original list but changes made in original list will still reflected in this view
//		this.tags = Collections.unmodifiableList(tags);
		this.tags = new ArrayList<>(tags);
		
		List<List<String>> nestedList = new ArrayList<>();
		
//		for(List<String> alist : groups) {
//			nestedList.add(Collections.unmodifiableList(alist)); 
//		}
		for(List<String> alist : groups) {
			nestedList.add(new ArrayList<>(alist));
		}
		this.groups = nestedList;
		
		if(employee == null) {
			this.employee = null;
		}
		else {
			this.employee = new Employee(employee);
		}
//		this.employee = cloneObject(employee);
		
		this.date = date;
	}

//	private Employee cloneObject(Serializable employee) {
//		byte []data;
//		
//		try(ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//				ObjectOutputStream output = new ObjectOutputStream(byteArray)){
//			
//			output.writeObject(employee);
//			data = byteArray.toByteArray();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//		try(ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))){
//			
//			return (Employee) input.readObject();
//			
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	public String getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public List<String> getTags() {
		return new ArrayList<>(this.tags);
	}

	public List<List<String>> getGroups() {
		List<List<String>> list = new ArrayList<>();
		
		for(List<String> alist : this.groups) {
			list.add(new ArrayList<>(alist));
		}
		return list;
	}	
	
	public Employee getEmployee() {
//		return cloneObject(employee);
		if(this.employee == null) {
			return null;
		}
		return new Employee(this.employee);
	}
	
	public Instant getDate() {
		return date;
	}

}
 
/*
 * what is Immutability and immutable class?
 * => An object is considered immutable if its state cannot change after it is constructed.
 * 
 * why immutability introduced in java?
 * => Immutable objects are particularly useful in concurrent applications. Since they cannot change state, 
 * => they cannot be corrupted by thread interference or observed in an inconsistent state.
 * => An immutable class is good for caching purposes because you don’t have to worry about the value changes.
 * 
 * why it is necessary to make immutable class final?
 * => it is not necessary.
 * => https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
 * 
 * what happens if we don't make it final?
 * => It means that other classes could potentially extend it. 
 * => Extending an immutable class can introduce challenges and potential risks to the immutability guarantees. 
 * 
 * why instance variables of immutable class are declared private final?
 * => Private so that they can't be accessed from outside of the class hence their value cannot be changed.
 * => While it is technically possible to create an immutable class without marking instance variables as final, 
 * => doing so reinforces the immutability contract, enhances thread safety, and contributes to the overall clarity and predictability of the code. 
 * => Therefore, it is a recommended practice to use final for instance variables in immutable classes.
 * 
 * what happens if we try to extend immutable class?
 * => If class is final then we get compile time error.
 * 
 * Collections.unmodifiableList() internals?
 * => this method returns the object of Unmodifiable list, which acts as a wrapper of user defined list
 * => Collections class has static Unmodifiable class which has one instance variable of type list which declared as final,
 * => and in the constructor of this class it takes a list and simply assign it to its final list instance variable,
 * => this class has all the methods of a list and except for the get operation methods (eg: get(), indexOf(), lastIndexOf()) 
 * => it will throw UnSupportedException for all other methods which tries to modify the list.
 * => it does the same thing with its iterator also, that means from the iterable also we can't modify the list (ie, remove() will not work)
 * => This wrapper class delegates all read-only operations to the original list but throws exceptions for any attempts to modify the list. 
 * => The wrapper class ensures that the immutability contract is maintained.
 * 
 * Generic way of deep copying mutable and nested mutable objects?
 * => https://stackoverflow.com/questions/59906453/java-using-reflection-for-deep-copy-object
 * 
 * Other ways of deep copying?
 * => make the mutable class implement either serializable or cloneable interface.
 * => because we can serialize and then deserialize the mutable object to deep copy it, and object.clone() will also return a diff object
 * 
 * How using reflection we can access the private instance variable and change data of final variables?
 * How to save this class from reflection?
 */
