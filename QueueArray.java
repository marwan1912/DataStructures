
public class Queue {

	int[] queue;
	int size = 0;
	int elementsInside = 0;
	public Queue(int size) {
		this.size = size;
		queue = new int[size];
	}
	
	public boolean isEmpty() {
		return elementsInside == 0;
	}
	
	public int length() {
		return elementsInside;
	}
	
	public void enqueue(int n) {
		queue[elementsInside] = n;
		elementsInside++;
	}
	
	public int dequeue() {
		if(elementsInside == 0) {
			System.out.println("The queue is empty.");
			return 0;
		}
		
		int n = queue[0];
		int[] newArray = new int[size];
		System.arraycopy(queue, 1, newArray, 0, size - 1);
		queue = newArray;
		elementsInside--;
		return n;
	}
	
	public int peek() {
		return queue[0];
	}
	
	public void print() {
		for (int i = 0; i < elementsInside; i++){
			System.out.println(dequeue());
		}
		
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("First out: " + q.dequeue());
		System.out.println("Peek: " + q.peek());
		System.out.println("Size: " + q.length());
		System.out.println("isEmpty: " + q.isEmpty());
		System.out.println("Secound out: " + q.dequeue());
		System.out.println("Third out: " + q.dequeue());
	}
}
