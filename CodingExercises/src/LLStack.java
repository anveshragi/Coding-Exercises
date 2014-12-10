import java.util.EmptyStackException;


public class LLStack {

	private LLNode headNode;

	public LLStack(){
		this.headNode = null;
	}

	public void push(int data) {

		if(headNode == null) {
			headNode = new LLNode(data);
		} else {
			LLNode temp = new LLNode(data);
			temp.setNext(headNode);
			headNode = temp;
		}		
	}

	public int pop() {
		if(headNode == null) 
			throw new EmptyStackException();
		else {
			LLNode temp = headNode;
			headNode = headNode.getNext();
			return temp.getData();
		}
	}
	
	public int top() {
		if(headNode == null)
			return -1;
		else
			return headNode.getData();
	}
	
	public boolean isEmpty() {
		if(headNode == null) 
			return true;
		else 
			return false;
	}
	
	public void deleteStack(){
		headNode = null;
	}
	
	
	public static void main(String[] args) {

		LLStack stack = new LLStack();
		
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		System.out.println(stack.top());
	}

}
