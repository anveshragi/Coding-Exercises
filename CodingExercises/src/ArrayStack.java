
public class ArrayStack {

	private int top;
	private int capacity;
	private int[] array;
		
	public ArrayStack() {
		this.capacity = 1;
		this.array = new int[capacity];
		this.top = -1;
	}

	public ArrayStack(int capacity) {
		this.top = -1;
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	
	public int size(){
		return capacity;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top==capacity-1);
	}
	
	public void push(int data) {
		if(!isFull())
			array[++top] = data;
		else
			System.out.println("Stack is full!");
	}
	
	public int pop(){
		if(!isEmpty())
			return array[top--];
		else
			System.out.println("Stack is empty");
		return 0;
	}
	
	public int top() {
		if(!isEmpty())
			return array[top];
		else
			System.out.println("Stack is empty");
		return 0;
	}
	
	public void deleteStack() {
		top = -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayStack stack = new ArrayStack(5);
		
		System.out.println("stack size : " + stack.size());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("current stack top : " + stack.top());
		stack.push(6);
		System.out.println("popped value : " + stack.pop());
		stack.push(6);
		System.out.println("popped value : " + stack.pop());
		System.out.println("popped value : " + stack.pop());
		System.out.println("popped value : " + stack.pop());
		System.out.println("popped value : " + stack.pop());
		System.out.println("popped value : " + stack.pop());
		stack.pop();
		stack.deleteStack();
		System.out.println("top value after deleting stack : " + stack.top());
	}

}
