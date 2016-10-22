package interviews;

public class ContextRelevant {
	
	// Calculate Rolling Average for a given array of numbers, a window size and current upper index value of the rolling window
	// Returns 0 when a value is not available
	int calculateRollingAverage(int arr[], int upperIndex, int windowSize) {
		
		if(upperIndex < windowSize-1) {
			return 0;
		} else {
			int sum = 0;
			for(int i = upperIndex-windowSize+1;i<=upperIndex;i++) {
				//Calculate Sum 
				sum += arr[i];
			}
			// Calculate Average
			int average = sum/windowSize;

			return average;
		}
	}
	
	// Calculate Rolling Maximum for a given array of numbers, a window size and current upper index value of the rolling window
	// Returns 0 when a value is not available
	int calculateRollingMaximum(int arr[], int upperIndex, int windowSize) {
		
		if(upperIndex < windowSize-1) {
			return 0;
		} else {
			int max = Integer.MIN_VALUE;
			for(int i = upperIndex-windowSize+1;i<=upperIndex;i++) {
				// Find maximum 
				if(arr[i] > max) {
					max = arr[i];
				}
			}
						
			return max;
		}
	}
	
	// Check if a non-zero value is available for the number
	void printvaluesAfterNaNcheck(int num) {
		
		if(num !=0)
			System.out.print(num);
		else System.out.print("None");
		
	}
	
	public static void main(String[] args) {

		// Assumption : Numbers in the stream are non-zero integers (positive or negative) without any ordering
		// Space Complexity : O(n) - Size of the stream itself with no extra space and optimal
		// Time Complexity : O(n*m) - m : windowSize n : stream size
		// Improvements : 
		// 1. We can improve this by saving previous averages or previous maximums. So the number of comparisons/calculation are only between outgoing element and incoming element from/to the stream of numbers  
		// 2. Also given time, I can make this more user-friendly by taking input from console or from a remote client using socket-programming
		// 3. We can apply the same logic to floating or double or any other data type
		// If we want to generalize this or scale this to bigger window size, above improvement is a better solution
		// Extension :  We can use a max heap on left side to represent elements that are less than current effective median, and a min heap on right side to represent elements that are greater than current effective median. Sizes of min-heap + max-heap will always be equal to the window size.
		// After processing an incoming element, the number of elements in heaps differ utmost by 1 element. When both heaps contain same number of elements, we pick average of heaps root data as effective median. When the heaps are not balanced, we select effective median from the root of heap containing more elements.//		

		
		ContextRelevant cr = new ContextRelevant();
		
		// Stream of numbers
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		
		for(int i=0;i<arr.length;i++) {
			
			int RollingAverage1 = cr.calculateRollingAverage(arr,i,3);
			
			int RollingMaximum1  = cr.calculateRollingMaximum(arr,i,3);
			
			int RollingAverage2  = cr.calculateRollingAverage(arr,i,20);
			
			int RollingMaximum2 = cr.calculateRollingMaximum(arr,i,20);
			
			System.out.print("(");
			
			cr.printvaluesAfterNaNcheck(RollingAverage1);
			
			System.out.print(",");
			
			cr.printvaluesAfterNaNcheck(RollingMaximum1);
			
			System.out.print(",");
			
			cr.printvaluesAfterNaNcheck(RollingAverage2);
			
			System.out.print(",");
			
			cr.printvaluesAfterNaNcheck(RollingMaximum2);
			
			System.out.print(")");
			
			System.out.println();
		}
		
	}

}
