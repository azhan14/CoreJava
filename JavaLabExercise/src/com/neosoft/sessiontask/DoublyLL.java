package com.neosoft.sessiontask;

public class DoublyLL {
	class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;		
		}
	}
	
	Node head,tail = null;
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
		}
	}
	
	public void display() {
		Node current = head;
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of doubly linked list: ");
		while(current!=null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		DoublyLL dll = new DoublyLL();
		dll.addNode(10);
		dll.addNode(20);
		dll.addNode(30);
		dll.addNode(40);
		dll.addNode(50);
		
		dll.display();
	}

}
