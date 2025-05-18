package coreJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFirstName("Tarun");
		
		emp.setAddress(new Address("Mumbai"));
		
		Employee cloned = cloneObject(emp);
		
		System.out.println("emp == cloned : " + (emp == cloned));
		System.out.println("emp.getAddress() == cloned.getAddress() : " + (emp.getAddress() == cloned.getAddress()));
		
		System.out.println("emp.equals(cloned) : " + emp.equals(cloned));
		System.out.println("emp.getAddress().equals(cloned.getAddress()) : " + emp.getAddress().equals(cloned.getAddress()));

	}
	
	private static Employee cloneObject(Serializable employee) {
		byte []data;
		
		try(ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
				ObjectOutputStream output = new ObjectOutputStream(byteArray)){
			
			output.writeObject(employee);
			data = byteArray.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try(ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))){
			
			return (Employee) input.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
