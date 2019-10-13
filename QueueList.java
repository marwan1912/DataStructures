
public class Queue {

	LinkedListforQueue queue;
	
	public Queue() {
		queue = new LinkedListforQueue();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public int size() {
		return queue.size();
	}
	
	public void enqueue(int n) {
		queue.add(n);
	}
	
	public int dequeue() {
		int n = queue.get(0);
		queue.remove(0);
		return n;
	}
	
	public int peek() {
		return queue.get(0);
	}
	
	public void print() {
	int c = queue.size();
	for(int i = 0; i < queue.size(); i++) {
			System.out.println(dequeue());
		}
		
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("First out: " + q.dequeue());
		System.out.println("Peek: " + q.peek());
		System.out.println("Size: " + q.size());
		System.out.println("isEmpty: " + q.isEmpty());
		System.out.println("Secound out: " + q.dequeue());
		System.out.println("Third out: " + q.dequeue());
	}
	
	
}
