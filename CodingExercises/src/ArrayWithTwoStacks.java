import java.util.EmptyStackException;


public class ArrayWithTwoStacks {

	private int[] array;
	private int size;
	private int topOne;
	private int topTwo;
	
	public ArrayWithTwoStacks(int size) {
		if(size < 2) throw new IllegalStateException("Size less than 2 is not permissable!");
		this.array = new int[size];
		this.size = size;
		this.topOne = -1;
		this.topTwo = size;
	}
	
	public void push(int stackID,int data) {
		if(topOne == topTwo - 1) throw new StackOverflowError("Stack is full");
		if(stackID == 1) {
			array[++topOne] = data;
		} else if(stackID == 2) {
			array[--topTwo] = data;
		} else
			return;
	}
	
	public int pop(int stackID) {
		if(stackID == 1) {
			if(topOne == -1) throw new EmptyStackException();
			else
				return array[topOne--];
		} else if(stackID == 2) {
			if(topTwo == size) throw new EmptyStackException();
			else
				return array[topTwo++];
		} else 
			return -2;			
	}
	
	public int top(int stackID) {
		if(stackID == 1) {
			if(topOne == -1) throw new EmptyStackException();
			else
				return array[topOne];
		} else if(stackID == 2) {
			if(topTwo == size) throw new EmptyStackException();
			else
				return array[topTwo];
		} else 
			return -2;	
	}
	
	public boolean isEmpty(int stackID) {
		if(stackID == 1) {
			if(topOne == -1) return true;
		} else if(stackID == 2) {
			if(topTwo == size) return true;
		} 
			return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayWithTwoStacks stack = new ArrayWithTwoStacks(10);
		
		stack.push(1, 1);
		stack.push(1, 2);
		stack.push(1, 3);
		stack.push(1, 4);
		stack.push(1, 5);
		
		stack.push(2, 6);
		stack.push(2, 7);
		stack.push(2, 8);
		stack.push(2, 9);
		stack.push(2, 10);
		
//		stack.push(1, 11);
		
		System.out.println(stack.top(1));
		System.out.println(stack.top(2));
		
		stack.pop(1);
		stack.pop(2);
		
		System.out.println(stack.top(1));
		System.out.println(stack.top(2));
	}
}
