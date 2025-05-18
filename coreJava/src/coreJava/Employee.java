package coreJava;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable, Comparable<Employee> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8740213626545110155L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	public Employee(){}

	public Employee(int id, String firstName, String lastName, String email, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		if(address == null) {
			this.address = null;
		}
		else {
			this.address = new Address(address);
		}
				
	}
	
	// Copy Constructor
	public Employee(Employee employee) {
		this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getAddress());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		if(address == null) {
			return null;
		}
		else {
			return new Address(address);
		}
	}

	public void setAddress(Address address) {
		if(address == null) {
			this.address = null;
		}
		else {
			this.address = new Address(address.getHouseNo(), address.getStreet(), address.getCity(), address.getState(), 
					address.getCountry(), address.getZipCode());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Employee e) {
		int result = this.id - e.getId();
		if(result == 0) {
			result = this.firstName.compareTo(e.getFirstName());
		}
		if(result == 0) {
			result = this.lastName.compareTo(e.getLastName());
		}
		if(result == 0) {
			result = this.email.compareTo(e.getEmail());
		}
		return result;
	}

}
