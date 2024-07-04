package com.app.linkedlist;

import com.app.entity.Employee;

public class SinglyLinkedList {
	//Head And Tail Reference 
	private Node head;
	private Node tail;

	// Nested Node class
	private  class Node {
		Employee employee;
		Node next;

		Node(Employee employee) {
			this.employee = employee;
			this.next = null;
		}
	}

	// Add a new employee
	public void addEmployee(Employee employee) {
		Node newNode = new Node(employee);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Print all employees
	public void printEmployees() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.employee);
			temp = temp.next;
		}
	}

	// Delete an employee by first name and last name
	public void deleteEmployee(String firstName, String lastName) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		if (head.employee.getFirstName().equals(firstName) && head.employee.getLastName().equals(lastName)) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.employee.getFirstName().equals(firstName)
					&& temp.next.employee.getLastName().equals(lastName)) {
				temp.next = temp.next.next;
				if (temp.next == null) {
					tail = temp;
				}
				return;
			}
			temp = temp.next;
		}
		System.out.println("Employee not found.");
	}

	// Search for an employee by first name and last name
	public Employee searchEmployee(String firstName, String lastName) {
		Node temp = head;
		while (temp != null) {
			if (temp.employee.getFirstName().equals(firstName) && temp.employee.getLastName().equals(lastName)) {
				return temp.employee;
			}
			temp = temp.next;
		}
		return null;
	}

	// Reverse the employee list
	public void reverseList() {
		Node prev = null;
		Node current = head;
		Node next;
		tail = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
}
