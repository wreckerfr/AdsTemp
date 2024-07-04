package com.app.entity;

import java.time.LocalDate;

public class Employee {
	private String firstName;
	private String lastName;
	private int age;
	private double salary;
	private LocalDate joiningDate;

	// Constructor
	public Employee(String firstName, String lastName, int age, double salary, LocalDate joiningDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Age must be positive.");
		}
	}

	public void setSalary(double salary) {
		if (salary >= 0) {
			this.salary = salary;
		} else {
			throw new IllegalArgumentException("Salary must be non-negative.");
		}
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age
				+ ", salary=" + salary + ", joiningDate=" + joiningDate + '}';
	}
}