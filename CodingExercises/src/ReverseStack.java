
public class ReverseStack {

	LLStack stack;
	
	public ReverseStack(){
		this.stack = new LLStack();
	}
	
	public static void reverseStack(LLStack stack) {
		
		if(stack.isEmpty()) return;
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack,temp);
	}
	
	public static void insertAtBottom(LLStack stack, int data) {
		
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack,data);
		stack.push(temp);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LLStack stack = new LLStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.top());
		
		reverseStack(stack);
		
		System.out.println(stack.top());
		
	}

}
