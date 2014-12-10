
public class GoogleBrahmiQuestion {

	public static void order(int array[]) {
		
		if(array.length<1) System.out.println("Array is empty!");
		
		for(int i=0;i<array.length-1;i++) {
			if(i%2==0) {
				if(array[i]>array[i+1]) {
					array[i] = array[i] + array[i+1];
					array[i+1] = array[i] - array[i+1];
					array[i] = array[i] - array[i+1];
				}
			} else {
				if(array[i]<array[i+1]) {
					array[i] = array[i] + array[i+1];
					array[i+1] = array[i] - array[i+1];
					array[i] = array[i] - array[i+1];
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {9,8,7,6,5,4,3,2,1}; //1,9,2,8,3,7,4,6,5	// 1,2,3,4,5,6,7,8,9	// 9,8,7,6,5,4,3,2,1
		
		order(array);
		
		for(int i=0;i<array.length;i++)
			System.out.print(array[i] + " ");
		
	}

}
