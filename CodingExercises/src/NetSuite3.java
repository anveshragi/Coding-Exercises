//QUESTION 3
//
//
//
//Given a non-negative real number a, its square root is a number x, such that x * x = a.
//
//One way to compute a square root is via successive approximation, where one estimate
//
//yields a better estimate.
//
//
//
//For example, let's say you are trying to find the square root of 2, and you have
//
//an estimate of 1.5. We'll say a = 2, and x = 1.5. To compute a better estimate,
//
//we'll divide a by x. This gives a new value y = 1.333333... However, we can't just
//
//take this as our next estimate (why not?). We need to average it with the previous
//
//estimate. So our next estimate, xx will be (x + y) / 2, or 1.416666...
//
//
//
//   Write a function that takes a non-negative real number a, and an epsilon (a
//
//   small real number), and returns an approximation of the square root of a.
//
//
//
//    double square_root(double a, double epsilon) ...
//
//
//
//   Epsilon determines how accurate the approximation needs to be. The function
//
//   should return the first approximation x it obtains that satisfies abs(x*x - a) < epsilon,
//
//   where abs(x) is the absolute value of x.
//
//
//
//   Questions (answer these):
//
//   1. Why can't the next estimate, xx, be computed as a / x, where x is the
//
//      previous estimate?
//
//   2. What happens, in your implementation, if a = 0?
//
//   3. What value does your program give for square_root(2, 1e-6)?



public class NetSuite3 {

	 static double square_root(double a, double epsilon) {
		
		 double estimate_x = 1.5;
		 double estimate_y = 1.5;
		 
		 
		 while(!(Math.abs(((estimate_x*estimate_x)-a)) < epsilon)) {
			 estimate_y = a/estimate_x;
			  double temp = (estimate_y + estimate_x)/2;
			  estimate_x = temp;
		 }
		 
		 return estimate_x;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ans = square_root(15,1e-6);
		System.out.println(ans);
	}

}
