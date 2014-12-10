class StackElement {
	private int height;
	private int index;

	public StackElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StackElement(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}	
}

class MyStack {

	private int top;
	private int capacity;
	private StackElement[] array;

	public MyStack() {
		this.capacity = 1;
		this.array = new StackElement[capacity];
		this.top = -1;
	}

	public MyStack(int capacity) {
		this.top = -1;
		this.capacity = capacity;
		this.array = new StackElement[capacity];
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

	public void push(StackElement data) {
		if(!isFull())
			array[++top] = data;
		else
			System.out.println("Stack is full!");
	}

	public StackElement pop(){
		if(!isEmpty())
			return array[top--];
		else
			System.out.println("Stack is empty");
		return null;
	}

	public StackElement top() {
		if(!isEmpty())
			return array[top];
		else
			System.out.println("Stack is empty");
		return null;
	}

	public void deleteStack() {
		top = -1;
	}
}	

public class LargestRectangleHistogram {


	public static long maxAreaRectangle(int A[],int n){

		long maxArea = 0;

		if(n == 0 || A.length == 0) return maxArea;

		MyStack stack = new MyStack(n);

		//		stack.push(new StackElement(Integer.MIN_VALUE,-1));
		//		int flag = 0;

		for(int i=0;i<n;i++) {

			if(stack.isEmpty()) {
				stack.push(new StackElement(A[i],i));
			} else if(stack.top().getHeight()<=A[i]) {
				stack.push(new StackElement(A[i],i));
				continue;
			} else {
				while(!stack.isEmpty()) {
					StackElement temp = stack.top();
					long area = temp.getHeight() * (i - temp.getIndex());

					if(area > maxArea) 
						maxArea = area;

					if(temp.getHeight()<A[i])
						break;

					stack.pop();
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {3,2,5,6,1,4,4};

		long maxArea = maxAreaRectangle(A,A.length);

		System.out.println("Maximum Area : " + maxArea);
	}

}
