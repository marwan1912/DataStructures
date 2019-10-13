
public class Stack {

	LinkedListforStack stack;
	
	public Stack() {
		stack = new LinkedListforStack();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.size();
	}
	
	public void push(int n) {
		stack.add(n);
	}
	
	public int pop() {
		int n = stack.get(0);
		stack.remove(0);
		return n;
	}
	
	public int top() {
		return stack.get(0);
	}
	
	public void print() {
		int c = stack.size();
		for(int i = 0; i < c; i++) {
			System.out.println(pop());
		}
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("First out: " + s.pop());
		System.out.println("Top: " + s.top());
		System.out.println("Size: " + s.size());
		System.out.println("isEmpty: " + s.isEmpty());
		System.out.println("Secound out: " + s.pop());
		System.out.println("Third out: " + s.pop());
	}
	
}
