public class TowersOfHanoi
{
	public static String hanoi(int nDisks, int fromPeg, int toPeg)
	{
		int helpPeg;
		
		String Sol1, Sol2, MyStep, mySol;   // Contains moves

		if ( nDisks == 1 )
		{
			return fromPeg + " -> " + toPeg + "\n";
		}
		else
		{
			helpPeg = 6 - fromPeg - toPeg;    // Because fromPeg + helpPeg + toPeg = 6    

			Sol1 = hanoi(nDisks-1, fromPeg, helpPeg);    

			MyStep = fromPeg + " -> " + toPeg + "\n";    

			Sol2 = hanoi(nDisks-1, helpPeg, toPeg);      

			mySol = Sol1 + MyStep + Sol2;     // + = String concatenation !

			return mySol;
		}
	}



	public static void main (String[] args)
	{
		int n = 5;

		String StepsToSolution;

		StepsToSolution = hanoi(n, 1, 3);

		System.out.println(StepsToSolution);
	}
}