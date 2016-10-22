package strings;

public class RemoveDuplicates {

	static int fin(int input) {
//		int input = 5346539;
		
	       int output = 0;
	       
	       for(int i=0;i<8*8;i++) {
	    	   output*=2;
	    	   output +=input%2;
	    	   input/=2;
	       }
	       return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int i = fin(64);
		System.out.println(i);
	}

}
