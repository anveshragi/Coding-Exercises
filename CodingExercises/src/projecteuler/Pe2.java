package projecteuler;

public class Pe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 2;
		int fib1 = 1;
		int fib2 = 2;
		int fibnext = 0;
		
		while(fibnext<=4000000) {
			fibnext = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibnext;
			
			if(fibnext%2==0) 
				sum += fibnext;
		}
		System.out.println("Sum = " + sum);
	}
}
