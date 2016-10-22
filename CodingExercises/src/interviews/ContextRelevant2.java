package interviews;

public class ContextRelevant2 {
	
	// Calculate Rolling Average for a given array of numbers, a window size, previous average and a current upper index value of the rolling window
	// Returns 0 when a value is not available
	// Performs one-time average calculation when window size meets rolling window upper index
	// In all other cases, performs new average calculation based from previously saved average and new number being added to the window
	int improvedCalculateRollingAverage(int arr[], int upperIndex, int windowSize, int previousAverage) {
		
		if(upperIndex < windowSize-1) {
			return 0;
		} else if (upperIndex == windowSize-1) {
			int sum = 0;
			for(int i = 0;i<=upperIndex;i++) {
				//Calculate Sum 
				sum += arr[i];
			}
			// Calculate Average
			int average = sum/windowSize;

			return average;
		} else {
			
			int newAverage = previousAverage;
			newAverage-= newAverage/windowSize;
			newAverage+=arr[upperIndex]/windowSize;
			
			return newAverage;
		}
	}

	// Calculate Rolling Maximum for a given array of numbers, a window size, previous maximum and a current upper index value of the rolling window
	// Returns 0 when a value is not available
	// Performs one-time comparisons between all elements in the rolling window when window size meets rolling window upper index
	// In all other cases, the comparison is only between the previous saved maximum value of rolling window and new number being added to the window
	int improvedCalculateRollingMaximum(int arr[], int upperIndex, int windowSize, int previousMax) {
		
		if(upperIndex < windowSize-1) {
			return 0;
		} else if (upperIndex == windowSize-1) {
			int max = Integer.MIN_VALUE;
			for(int i = upperIndex-windowSize+1;i<=upperIndex;i++) {
				// Find maximum 
				if(arr[i] > max) {
					max = arr[i];
				}
			}		
			return max;
		} else {
			if(arr[upperIndex] > previousMax) 
				return arr[upperIndex];
			else
				return previousMax;
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
		// Time Complexity : O(n + m) - m : windowSize n : stream size and optimal 
		// Improvements : 
		// 1. Given time, I can make this more user-friendly by taking input from console or from a remote client using socket-programming
		// 2. We can apply the same logic to floating or double or any other data type
		// If we want to generalize this or scale this to bigger window size, above improvement is a better solution
		// Extension :  We can use a max heap on left side to represent elements that are less than current effective median, and a min heap on right side to represent elements that are greater than current effective median. Sizes of min-heap + max-heap will always be equal to the window size.
		// After processing an incoming element, the number of elements in heaps differ utmost by 1 element. When both heaps contain same number of elements, we pick average of heaps root data as effective median. When the heaps are not balanced, we select effective median from the root of heap containing more elements.		

		
		ContextRelevant2 cr = new ContextRelevant2();
		
		// Stream of numbers
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		
		// Saving previous calculated values
		int previousRollingAverage1 = 0;
		int previousRollingAverage2 = 0;
		int previousRollingMaximum1 = 0;
		int previousRollingMaximum2 = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			int RollingAverage1 = cr.improvedCalculateRollingAverage(arr,i,3,previousRollingAverage1);
			previousRollingAverage1 = RollingAverage1;
			
			int RollingMaximum1  = cr.improvedCalculateRollingMaximum(arr,i,3,previousRollingMaximum1);
			previousRollingMaximum1 = RollingMaximum1;
			
			int RollingAverage2  = cr.improvedCalculateRollingAverage(arr,i,20,previousRollingAverage2);
			previousRollingAverage2 = RollingAverage2;
			
			int RollingMaximum2 = cr.improvedCalculateRollingMaximum(arr,i,20,previousRollingMaximum2);
			previousRollingMaximum2 = previousRollingAverage2;
			
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

