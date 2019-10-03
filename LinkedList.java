
public class LinkedList {
	
	Node head;
	int count;
	
	public LinkedList() {
		head = null;
		count = 0;
	}
	
	public LinkedList(Node head) {	
		this.head = head;
		count = 1;
	}
	
	//Adds a node with data in it.
	public void add(int data) {		
		Node temp = new Node(data);
		if(head == null) {
			head = temp;
		}else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			
			current.setNext(temp);
		}
		
		count++;		
	}
	
	//Gets data inside a node of a given index. (Indexes start at 0)
	public int get(int index) {
		if(index < 0 || head == null || index >= count) {
			return -1;
		}
		
		Node current = head;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		if(current == null) {
			return -1;
		}else {
			return current.getData();	
		}
		
	}
	
	//Gives the size of the list.
	public int size() {
		return count;
	}
	
	//Tells is if the list is empty.
	public boolean isEmpty() {
		return head == null;
	}
	
	//Checks if a given number exists in any of the nodes in the list.
	public boolean search(int data) {
		if(head == null) {
			return false;
		}else {
			if(head.getData() == data) {
				return true;
			}
			
			Node current = head;
			while(current.getNext() != null && current.getData() != data) {
				current = current.getNext();
			}
			
			if(current.getData() == data) {
				return true;
			}else {
				return false;
			}
			
		}
		
	}
	
	//Removes a node of a given index from the list. (Indexes start at 0)
	public void remove(int index) {
		
		if(index < 0 || index >= size()) {
			System.out.println("Index can not be less than 0 or more than the linked list size");
			return;
		}
		
		if(index == 0) {
			head = head.getNext();
			System.out.println("Node has been removed successfully");
			count--;
			return;
		}
		
		Node prev = head;
		Node temp = prev.getNext();
		for(int i = 0; i < index - 1; i++) {
			prev = prev.getNext();
			temp = prev.getNext();
		}
			
			prev.setNext(temp.getNext());
			System.out.println("Node has been removed successfully");
			count--;
	}
	
	//Prints all the elements inside the linked list.
	public void print() {
		if(head == null) {
			System.out.println("The list is empty.");
		}else {
			Node current = head;
			while(current != null) {
				System.out.print(current.getData() + " ");
				current = current.getNext();
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.search(2));
		list.print();
		list.remove(1);
		System.out.println(list.search(2));
		System.out.println(list.get(1));
		list.print();
	}
	
}

class Node{
	
	Node next;
	int data;
	
	public Node (int data) {		
		this.data = data;
		next = null;
	}
	
	public Node(int data, Node next) {		
		this.data = data;
		this.next = next;
	}
	
	public void setData(int data) {		
		this.data = data;
	}
	
	public void setNext(Node next) {		
		this.next = next;
	}
	
	public int getData() {	
		return data;
	}
	
	public Node getNext() {		
		return next;
	}
	
}
