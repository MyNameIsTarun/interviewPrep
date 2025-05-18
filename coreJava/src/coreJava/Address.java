package coreJava;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5481763676820338856L;
	
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public Address(int houseNo, String street, String city, String state, String country, String zipCode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	// Copy constructor
	public Address(Address address) {
			this(address.getHouseNo(), address.getStreet(), address.getCity(), address.getState(), 
					address.getCountry(), address.getZipCode());
	}

	public Address() {
		super();
	}
	
	public Address(String city) {
		this.city = city;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, houseNo, state, street, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country) && houseNo == other.houseNo
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}
}
