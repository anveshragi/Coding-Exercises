package arrays;

public class MinElementInSortedArray {

	public int minElement(int array[]) {
		
		int LEFT = 0;
		int RIGHT = array.length-1;
		
		while(LEFT <= RIGHT) {
			if(RIGHT-LEFT == 1) 
				return array[RIGHT];
				
			int m = LEFT + (RIGHT - LEFT)/2;
			
			if(array[m] == array[LEFT]) {
				LEFT = m +1;
			} else if(array[m] > array[RIGHT]) {
				LEFT = m;
			} else {
				RIGHT = m;
			}
		}
		
		return array[LEFT];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int array[] = {3,4,5,6,7,1,2};
		
		int array[] = {332,415,415,521,521,634,634,7432,9,12,12,12,221};
		
		MinElementInSortedArray mesa = new MinElementInSortedArray();
		
		int result = mesa.minElement(array);

		System.out.println(result);
	}

}
