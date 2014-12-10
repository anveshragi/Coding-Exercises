import java.util.ArrayList;
import java.util.List;

public class ClimbingTree {
    // part a: How many ways are there to climb a mountain of size n?
    public static Number simplePathCount(int n) {

    	if(n > 50) return -1;
    	
    	long waysToClimb = 0;
    	
    	for(int i = n; i >0;i--) {
    		waysToClimb = waysToClimb + (2*(i-2) + 2);
//    		System.out.println(i + " : " + waysToClimb);
    	}
    	
        return waysToClimb;
    }

    // part b: How many ways are there to climb this 'mountain' with traps?
    // 'mountain' represents a mountain of size mountain.size(), 
    // and each element of mountain.get(i) will have exactly i+1 'O's or 'X's 
    // and the rest spaces.
    public static Number pathCountWithTraps(List<String> mountain) {

    	if(mountain.size() > 50) return -1;
    	
    	long waysToClimb = 0;
    	
    	for(int i = mountain.size()-1;i>=0;i--) {
    		
//    		waysToClimb = waysToClimb + (2*((i+1)-2) + 2);
    		
    		String level = mountain.get(i);
    		level.trim();
    		String[] tokens = level.split(" ");
    		
//    	    ["   O   ",
//    	     "  O O  ",
//    	     " O X O ",
//    	     "O O X O"]
    		
    		for(int j =0;j<tokens.length-1;j++){
    			
    			int count = 0;
    			
    			if(tokens[j].equals("X")) {
    				if(j == 0 || j == tokens.length-1)
    					waysToClimb = waysToClimb-((j+1)*1);
    				else
    					waysToClimb = waysToClimb-((j+1)*2);
    				count++;
    			}
    			
    			if(count == tokens.length)
    				return -1;
    		}
    		
    	}
    	
        return waysToClimb;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Number x = simplePathCount(5);
		System.out.println(x);
		
		List<String> mountain = new ArrayList<String>();
		
		mountain.add(" O ");
		mountain.add(" O O ");
		mountain.add(" O X O ");
		mountain.add("O O X O ");
		
		
		Number y = pathCountWithTraps(mountain);
		System.out.println(y);
	}
}