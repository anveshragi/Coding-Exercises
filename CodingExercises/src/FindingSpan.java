
public class FindingSpan {

	static int[] array = {6,3,4,5,2};
	static int[] result = new int[array.length];

	public static int[] findingSpan(int[] array) {

		ArrayStack stack = new ArrayStack(array.length); 
		int p = 0;

		for(int i = 0;i<array.length;i++) {
			while(!stack.isEmpty() && array[i] > array[stack.top()])
				stack.pop();
			if(stack.isEmpty())
				p = -1;
			else {
				p = stack.top();
			}
			result[i] = i - p;
			stack.push(i);
		}

		return result;
	}

	public static int[] findingSpan2(int[] array) {

		ArrayStack stack = new ArrayStack(array.length); 

		for(int i = 0;i<array.length;i++) {
			result[i] = 1;
		}		

		for(int i = 0;i<array.length;i++) {

			while(!stack.isEmpty() && array[i] >= array[stack.top()]) {
				result[i] += result[stack.top()];
				stack.pop();
			}
			stack.push(i);
		}

		return result;
	}

	static void printArray(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {

		findingSpan(array);

		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);

	}

}
