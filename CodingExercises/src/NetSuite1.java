//QUESTION 1
//
//For programming questions use programming language Java or C#.
//
//
//
//Given a sorted array of integers, write a method to remove the duplicates. Use pure
//
//arrays and access individual items via indexes. Don't use any dynamic data structures,
//
//i.e. do not use any classes from the java.util package, or the equivalent library for
//
//your language.
//
//
//
//Example: [ 1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 ] ->
//
//         [ 1, 2, 3, 4, 10, 13, 15, 17 ]
//
//
//
//Solution template:
//
//
//
//    int[] removeDuplicates(int[] values)
//
//    {
//
//        // your code here
//
//    }
//
//
//
//   Questions (answer these):
//
//   1. Did you write that as if you were writing production code?
//
//   2. What assumptions does your implementation make about the input parameter?
//
//   3. What is removeDuplicates(x).length, in your implementation?
//
//   4. Are you using all the information you have about the input array?
//
//   5. What is the algorithmic complexity ("big O") of your function?
		   
		   

public class NetSuite1 {
	
	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 

		int B[] = new int[j+1];
		
		for(int a = 0;a< j+1 ;a++){
			B[a] = A[a];
		}
		
		return B;

	}
	 
	
	public static void main(String[] args) {
		
		int[] arr = { 1, 2, 2, 3, 3 };
		arr = removeDuplicates(arr);
		
		for(int a : arr) {
			System.out.println(a);

		}
	}
}
