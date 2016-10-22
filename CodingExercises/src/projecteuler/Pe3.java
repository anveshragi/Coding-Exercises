package projecteuler;

public class Pe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long n = 600851475143L;
	
		long largestPrimeFactor = 2;
		
		while(n%2==0)
			n = n/2;
		
		for(long i=3;i<=(long) Math.sqrt(n);i=i+2) {
			while(n%i == 0) {
				n = n/i;
				largestPrimeFactor = i;
			}
		}
		
		if(n > 2) {
			largestPrimeFactor = n;
		}
		
		System.out.println("Largest prime factor = " + largestPrimeFactor);
	}

}
