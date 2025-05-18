package desing_pattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import coreJava.Employee;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Singleton instance = Singleton.getInstance();
		instance.setName("Tarun");
		System.out.println("instance: " + instance);
		
		Singleton instance2 = Singleton.getInstance();
		System.out.println("instance2: " + instance2);
		
		instance2.setName("Chetan");
		System.out.println("instance after setting to Chetan: " + instance);
		System.out.println("instance2: " + instance2);
		
		System.out.println("instance == instance2: " + (instance == instance2));
		
		Singleton serialized = serializeObject(instance);
		System.out.println("serialized == instance : " + (serialized == instance));
		
		Singleton cloned = (Singleton) instance.clone();
		System.out.println("cloned == instance : " + (cloned == instance));
	}
	
	private static Singleton serializeObject(Serializable singleton) {
		byte []data;
		
		try(ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
				ObjectOutputStream output = new ObjectOutputStream(byteArray)){
			
			output.writeObject(singleton);
			data = byteArray.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try(ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))){
			
			return (Singleton) input.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
