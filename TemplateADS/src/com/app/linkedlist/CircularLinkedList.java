package com.app.linkedlist;

import com.app.entity.Employee;

public class CircularLinkedList {
	 private Node head;
	    private Node tail;

	    // Non-static nested Node class
	    private class Node {
	        Employee employee;
	        Node next;
	        Node prev;

	        Node(Employee employee) {
	            this.employee = employee;
	            this.next = null;
	            this.prev = null;
	        }
	    }

	    // Add a new employee
	    public void addEmployee(Employee employee) {
	        Node newNode = new Node(employee);
	        if (head == null) {
	            head = tail = newNode;
	            head.next = head.prev = head;
	        } else {
	            tail.next = newNode;
	            newNode.prev = tail;
	            newNode.next = head;
	            head.prev = newNode;
	            tail = newNode;
	        }
	    }

	    // Print all employees
	    public void printEmployees() {
	        if (head == null) {
	            System.out.println("List is empty.");
	            return;
	        }
	        Node temp = head;
	        do {
	            System.out.println(temp.employee);
	            temp = temp.next;
	        } while (temp != head);
	    }

	    // Delete an employee by first name and last name
	    public void deleteEmployee(String firstName, String lastName) {
	        if (head == null) {
	            System.out.println("List is empty.");
	            return;
	        }
	        Node temp = head;
	        do {
	            if (temp.employee.getFirstName().equals(firstName) && temp.employee.getLastName().equals(lastName)) {
	                if (temp == head && temp == tail) {
	                    head = tail = null;
	                } else {
	                    if (temp == head) {
	                        head = head.next;
	                    }
	                    if (temp == tail) {
	                        tail = tail.prev;
	                    }
	                    temp.prev.next = temp.next;
	                    temp.next.prev = temp.prev;
	                }
	                return;
	            }
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println("Employee not found.");
	    }

	    // Search for an employee by first name and last name
	    public Employee searchEmployee(String firstName, String lastName) {
	        if (head == null) {
	            return null;
	        }
	        Node temp = head;
	        do {
	            if (temp.employee.getFirstName().equals(firstName) && temp.employee.getLastName().equals(lastName)) {
	                return temp.employee;
	            }
	            temp = temp.next;
	        } while (temp != head);
	        return null;
	    }

	    // Reverse the employee list
	    public void reverseList() {
	        if (head == null) {
	            return;
	        }
	        Node current = head;
	        Node temp;
	        do {
	            temp = current.next;
	            current.next = current.prev;
	            current.prev = temp;
	            current = temp;
	        } while (current != head);
	        temp = head;
	        head = tail;
	        tail = temp;
	    }

}
