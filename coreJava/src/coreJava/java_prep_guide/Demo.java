package coreJava.java_prep_guide;

import java.sql.SQLException;

public class Demo implements Comparable<Demo> {

	private int employeeId;
	
	public Demo(int id) {
		this.employeeId = id;
	}
	
	public Demo() {
		System.out.println("Demo no-arg constructor called");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		this.employeeId = id;
	}
	
	public static void staticMethod() {
		System.out.println("Demo.staticMethod() called");
	}
	
	public int methodToBeOverriden() {
		return 2;
	}
	
	public void throwsException() throws SQLException {
		System.out.println("Parent method");
	}

	@Override
	public String toString() {
		return "Demo [employeeId=" + employeeId + "]";
	}

	@Override
	public int compareTo(Demo o) {
		return this.getEmployeeId() - o.getEmployeeId();
	}
}
