
public class MergeTwoSortedArrays {

	/* Write your custom functions here */
	static void mergeArray(int []a, int []b, int M ){

		int i = M - 1;
		int j = M - 1;
		int result_pos = (2*M) - 1;
		
		while (i >= 0 || j >= 0) {
			 if (j < 0 || (i >= 0 && a[i] >= b[j])) {
			        b[result_pos--] = a[i--];
			    } else {
			        b[result_pos--] = b[j--];
			    }
		}
		
//		int x = 0;
//		int y = (2*M)-1;
//
//		for(x = (2*M)-1;x>=0;x--) {
//			b[y] = b[x];
//			y--;
//		}
//
//		int i = M;
//		int j = 0;
//		int k = 0;
//
//		while(k<(2*M)) {
//
//			if((i<(2*M) && b[i] <= a[j]) || j==M) {
//				b[k] = b[i];
//				k++;
//				i++;
//			} else {
//				b[k] = a[j];
//				k++;
//				j++;
//			}
//
//		}

	}
	
	
	public static void main(String[] args) {

		int[] _a = new int[5];
		
		_a[0] = 3;
		_a[1] = 5;
		_a[2] = 6;
		_a[3] = 9;
		_a[4] = 12;
		
		int[] _b = new int[10];
		_b[0] = 30;
		_b[1] = 32;
		_b[2] = 34;
		_b[3] = 36;
		_b[4] = 38; 
		
		mergeArray(_a ,_b,5);
		for( int i = 0;i < 10;i++ ){
			System.out.print(_b[i] + " ");		
		}
		
//		Scanner sc = new Scanner(System.in);
//		int _a_cnt = 0;
//		int[] _a = new int[100001];
//		int[] _b = new int[200002];
//
//		try {
//			_a_cnt = sc.nextInt();
//		}catch (Exception e) {
//			System.out.println("Here: " + e.getMessage()); 
//		} 

//		for( int i = 0;i < _a_cnt;i++ ){			
//			_a[i] = sc.nextInt();		
//		}
//		for( int i = 0;i < _a_cnt;i++ ){
//			_b[i] = sc.nextInt();		
//		}	
//		
//		mergeArray(_a ,_b,_a_cnt);
//		for( int i = 0;i < 2 * _a_cnt;i++ ){
//			System.out.print(_b[i] + " ");		
//		}
	}
}


//Consider the 1st array: {3,5,6,9,12,14,18,20,25,28,30,32,34,36,38,40,42,44,46,48}
//2nd array: {30,32,34,36,38,40,42,44,46,48 }
//
//Sample Output:
//{3,5,6,9,12,14,18,20,25,28,30,32,34,36, 38,40,42,44,46,48}