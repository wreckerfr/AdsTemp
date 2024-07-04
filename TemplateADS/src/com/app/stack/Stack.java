package com.app.stack;

import com.app.entity.Employee;

public class Stack {

	Node top;

	private class Node {
		Employee employee;
		Node next;

		public Node(Employee employee) {
			this.employee = employee;
			next = null;
		}
	}

	public Stack() {
		this.top = null;
	}

	// Push a new employee onto the stack
	public void push(Employee employee) {
		Node newNode = new Node(employee);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	// Pop the top employee off the stack
    public Employee pop() {
        if (top == null) {
            return null;
        }
        Employee poppedEmployee = top.employee;
        top = top.next;
        return poppedEmployee;
    }
    
 // Peek at the top employee on the stack
    public Employee peek() {
        if (top == null) {
            return null;
        }
        return top.employee;
    }
    
    // Print all employees in the stack
    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.employee);
            temp = temp.next;
        }
    }
    
 // Get the employee with the maximum age
    public Employee getMaxAgeEmployee() {
        if (top == null) {
            return null;
        }
        Node temp = top;
        Employee maxAgeEmployee = top.employee;
        while (temp != null) {
            if (temp.employee.getAge() > maxAgeEmployee.getAge()) {
                maxAgeEmployee = temp.employee;
            }
            temp = temp.next;
        }
        return maxAgeEmployee;
    }

}
