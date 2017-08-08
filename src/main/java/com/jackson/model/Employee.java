package com.jackson.model;

import java.util.Arrays;


public class Employee {

	private int id;
	private String name;
	private int age;
	private Address address;
	private long[] phoneNumbers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(long[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***** Employee Details *****\n");
		sb.append("ID=" + getId() + "\n");
		sb.append("Name=" + getName() + "\n");
		sb.append("age=" + getAge() + "\n");
		sb.append("Address=" + getAddress() + "\n");
		sb.append("Phone Numbers=" + Arrays.toString(getPhoneNumbers()) + "\n");
		sb.append("*****************************");

		return sb.toString();
	}

}