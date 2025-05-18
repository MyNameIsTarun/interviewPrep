package coreJava;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ImmutableMain {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("Hi");
		list.add("How");
		
		List<List<String>> nestedList = new ArrayList<>();
		nestedList.add(list);
		nestedList.add(list);
		nestedList.add(list);
		
		
		Instant date = Instant.now();
		Employee emp = new Employee();
		emp.setAddress(new Address("Kashmir"));
		
		Immutable immutable = new Immutable("id", "name", list, nestedList, emp, date);

		System.out.println(immutable.getGroups());
		
		System.out.println(immutable.getTags());
		list.add("Are");
		immutable.getTags().add("adfasfasdf");
		immutable.getTags().add("Tarun");
		System.out.println(immutable.getTags());
		
		immutable.getGroups().get(1).add("Something new");

		System.out.println(immutable.getGroups());
		
		
		System.out.println(immutable.getDate());
		date = date.plusSeconds(1000);
		System.out.println("date: " + date);
		
		System.out.println(immutable.getDate() + " --------------------------");
		Instant date2 = date.plusSeconds(1000);
//		imm.getDate().plusSeconds(1000);
		System.out.println(immutable.getDate());
		
		Field dateField = immutable.getClass().getDeclaredField("date");
		dateField.setAccessible(true);
		dateField.set(immutable, date2);
		
		System.out.println(immutable.getDate());
		
		// ---------------------- testing Employee ---------------------------- //
		System.out.println("\n============ Testing Employee ===============\n");
		System.out.println(immutable.getEmployee());
		emp.setFirstName("Tarun");
		
		Employee e2 = immutable.getEmployee();
		System.out.println(e2);
		
		e2.setFirstName("Tarun");
		System.out.println("e2 : " + e2);
		System.out.println("imm.getEmployee() : " + immutable.getEmployee());
		
		// ---------------------- testing Employee Including Address ---------------------------- //
		System.out.println("\n============ Testing Employee Including Address ===============");
		
		System.out.println("\nUsing local employee object");
		
		System.out.println(immutable.getEmployee().getAddress() + " -> without any updation");
		if(emp.getAddress() == null) {
			emp.setAddress(new Address());
		}
		emp.getAddress().setCity("Mumbai");
		immutable.getEmployee().getAddress().setCountry("China");
		immutable.getEmployee().setAddress(new Address("Bangalore"));
		System.out.println(immutable.getEmployee().getAddress() + " -> after updating address's city and country");
		
		/*
		 * ========================== OUTPUT ==========================
		 * 
		 * ============ Without Serialization/Deep copy ===============
		 * 
		 * Using local employee object
		 * Address [houseNo=0, street=null, city=Kashmir, state=null, country=null, zipCode=null] -> without any updation
		 * Address [houseNo=0, street=null, city=Mumbai, state=null, country=China, zipCode=null] -> after updating address's city and country
		 * 
		 * ============ With Serialization ===============
		 * 
		 * Address [houseNo=0, street=null, city=Kashmir, state=null, country=null, zipCode=null] -> without any updation
		 * Address [houseNo=0, street=null, city=Kashmir, state=null, country=null, zipCode=null] -> after updating address's city and country
		 * 
		 * ============ With deep copy inside every Mutable object constructor ===============
		 * 
		 * Address [houseNo=0, street=null, city=Kashmir, state=null, country=null, zipCode=null] -> without any updation
		 * Address [houseNo=0, street=null, city=Kashmir, state=null, country=null, zipCode=null] -> after updating address's city and country
		 */
		

	}

}
