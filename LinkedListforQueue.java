
public class LinkedListforQueue {
	
	Node head;
	int count;
	
	public LinkedListforQueue() {
		head = null;
		count = 0;
	}
	
	public LinkedListforQueue(Node head) {	
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
	
	//Removes a node of a given index from the list. (Indexes start at 0)
	public void remove(int index) {
		
		if(index < 0 || index >= size()) {
			return;
		}
		
		if(index == 0) {
			head = head.getNext();
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
			count--;
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
