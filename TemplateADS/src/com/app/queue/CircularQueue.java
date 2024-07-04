package com.app.queue;

import com.app.entity.Employee;

public class CircularQueue {
	 private Node tail; // Use tail for circular nature
     private int size;

     private class Node {
         Employee employee;
         Node next;

         Node(Employee employee) {
             this.employee = employee;
             this.next = null;
         }
     }

     // Constructor
     public CircularQueue() {
         this.tail = null;
         this.size = 0;
     }

     // Enqueue a new employee to the circular queue
     public void enqueue(Employee employee) {
         Node newNode = new Node(employee);
         if (isEmpty()) {
             newNode.next = newNode; // Point to itself for circularity
             tail = newNode;
         } else {
             newNode.next = tail.next; // New node points to the head of the circle
             tail.next = newNode; // Tail points to the new node
             tail = newNode; // Update tail to the new node
         }
         size++;
     }

     // Dequeue the front employee from the circular queue
     public Employee dequeue() {
         if (isEmpty()) {
             System.out.println("Queue is empty. Cannot dequeue.");
             return null;
         }
         Node head = tail.next; // Head is the node after tail
         if (head == tail) { // If only one element in the queue
             tail = null;
         } else {
             tail.next = head.next; // Tail points to the new head
         }
         size--;
         return head.employee;
     }

     // Peek at the front employee in the circular queue
     public Employee peek() {
         if (isEmpty()) {
             System.out.println("Queue is empty. Cannot peek.");
             return null;
         }
         return tail.next.employee; // Head is the node after tail
     }

     // Print all employees in the circular queue
     public void printQueue() {
         if (isEmpty()) {
             System.out.println("Queue is empty.");
             return;
         }
         System.out.println("Circular Queue content:");
         Node current = tail.next; // Start from head
         do {
             System.out.println(current.employee);
             current = current.next;
         } while (current != tail.next);
     }

     // Check if the circular queue is empty
     public boolean isEmpty() {
         return tail == null;
     }
}
