public class SortStack {

	public static LLStack sortStackAscending(LLStack stack) {
		
		if(stack.isEmpty()) return stack;
		
		LLStack result = new LLStack();
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			
			while(!result.isEmpty() && temp > result.top()) {
				stack.push(result.pop());				
			}			
			result.push(temp);
		}
		
		
		return result;		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LLStack stack = new LLStack();
		
		stack.push(6);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(2);
		
		LLStack result = sortStackAscending(stack);
		System.out.println(result.pop());
		System.out.println(result.pop());
		System.out.println(result.pop());
		System.out.println(result.pop());
		System.out.println(result.pop());
	}

}
