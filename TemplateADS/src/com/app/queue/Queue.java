package com.app.queue;

import com.app.entity.Employee;

public class Queue {
	private Node head;
	private Node tail;

	private class Node {
		Employee employee;
		Node next;

		Node(Employee employee) {
			this.employee = employee;
			this.next = null;
		}
	}

	// Enqueue a new employee to the queue
	public void enqueue(Employee employee) {
		Node newNode = new Node(employee);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Dequeue the front employee from the queue
	public Employee dequeue() {
		if (head == null) {
			return null;
		}
		Employee dequeuedEmployee = head.employee;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return dequeuedEmployee;
	}

	// Peek at the front employee in the queue
	public Employee peek() {
		if (head == null) {
			return null;
		}
		return head.employee;
	}

	// Print all employees in the queue
	public void printQueue() {
		if (head == null) {
			System.out.println("Queue is empty.");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.employee);
			temp = temp.next;
		}
	}
}
