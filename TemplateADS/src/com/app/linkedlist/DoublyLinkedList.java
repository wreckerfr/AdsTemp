package com.app.linkedlist;

import com.app.entity.Employee;

public class DoublyLinkedList {
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
	        } else {
	            tail.next = newNode;
	            newNode.prev = tail;
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
	            if (head != null) {
	                head.prev = null;
	            } else {
	                tail = null;
	            }
	            return;
	        }
	        Node temp = head;
	        while (temp != null) {
	            if (temp.employee.getFirstName().equals(firstName) && temp.employee.getLastName().equals(lastName)) {
	                if (temp.prev != null) {
	                    temp.prev.next = temp.next;
	                }
	                if (temp.next != null) {
	                    temp.next.prev = temp.prev;
	                }
	                if (temp == tail) {
	                    tail = temp.prev;
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
	        Node current = head;
	        Node temp = null;
	        while (current != null) {
	            temp = current.prev;
	            current.prev = current.next;
	            current.next = temp;
	            current = current.prev;
	        }
	        if (temp != null) {
	            head = temp.prev;
	        }
	    }

}
