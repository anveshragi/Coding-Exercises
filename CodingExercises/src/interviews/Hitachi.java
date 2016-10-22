package interviews;

//3 -> 2 -> 5 -> 6 -> 1
//n = 2
//remove nth node from the end of the list
//
//3->2 & n=1

public class Hitachi {

	void removenthnode(LinkedList head, int n) {
	    
	    if(head ==null) {
	       return -1;
	    } // else if (n == 1) {
	     //  return head.data;
	   // }
	     else {
	    
	    LinkedListObject fp = head;
	    LinkedListObject sp = head;
	    
	    //Start first pointer
	    for(int i=0;i<n;i++) {
	       if (fp.next() != null)
	           fp = fp.next();       // 2
	       else 
	           System.out.println("Invalid n number!!");
	    }
	    
	    // start second pointer where it ends up at previous node of nth node
	    while (fp.next() != null)
	       fp = fp.next();       // 5  6  1
	       sp = sp.next();       // 3  2  5
	    } // sp = 5
	    
	    sp = sp.next(); // sp = 6
	    
	    LinkedListObject before = sp;    // before = 5
	    
	    LinkedListObject after = sp.next(); // after = 1
	    
	    // Changing the link of n-1th node to n+1th node
	    before.setNext(after);  // 5 -> 1
	   
	}
	
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	


		
}
