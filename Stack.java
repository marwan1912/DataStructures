
public class Stack {

	int[] stack;
	int size = 0;
	int elementsInside = 0;
	public Stack(int size) {
		this.size = size;
		stack = new int[size];
	}
	
	public boolean isEmpty() {
		return elementsInside == 0;
	}
	
	public int length() {
		return elementsInside;
	}
	
	public void push(int n) {
		if(elementsInside == size) {
			System.out.println("You can't put more elements in the stack");
			return;
		}
		
		int[] newArray = new int[size];
		/*Copy the current stack from index 0 till the end of the stack to a new queue and start
		putting elements in the new stack starting from index 1.*/
		System.arraycopy(stack, 0, newArray, 1, size - 1);
		newArray[0] = n;
		stack = newArray;
		elementsInside++;
	}
	
	public int pop() {
		if(elementsInside == 0) {
			System.out.println("The stack is empty.");
			return 0;
		}
		
		int n = stack[0];
		int[] newArray = new int[size];
		/*Copy the current stack from index 1 till the end of the queue to a new stack and start
		putting elements in the new stack starting from index 0.*/
		System.arraycopy(stack, 1, newArray, 0, size - 1);
		stack = newArray;
		elementsInside--;
		return n;
	}
	
	public int top() {
		return stack[0];
	}
	
	public void print() {
		int c = elementsInside;
		for (int i = 0; i < c; i++){
			System.out.println(pop());
		}
		
	}
	
	public static void main(String[] args) {
		Stack s = new Stack(3);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("First out: " + s.pop());
		System.out.println("Top: " + s.top());
		System.out.println("Size: " + s.length());
		System.out.println("isEmpty: " + s.isEmpty());
		System.out.println("Secound out: " + s.pop());
		System.out.println("Third out: " + s.pop());
	}
	
}
