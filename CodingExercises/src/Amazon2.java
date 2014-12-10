
public class Amazon2
{
	public static boolean[] convert(byte term) {
		 boolean[] result = new boolean[Byte.SIZE];
		  for (int i=0; i<Byte.SIZE; i++) 
			  result[i] = (term >> i & 0x1) != 0x0;
		 return result;
		}
	

 public static int grayCheck(byte term1, byte term2){
	 
	 if(term1 == term2) return 0;
	 
	 if(Math.abs(term1 - term2) == 1) return 1;
	 
	 boolean[] t1 = new boolean[Byte.SIZE];
	 boolean[] t2 = new boolean[Byte.SIZE];
	 
	 int count = 0;
	 
	 for (int i=0; i<Byte.SIZE; i++) {
		 
		 t1[i] = (term1 >> i & 0x1) != 0x0;
		 
		 if(t1[i])
			 System.out.print("1 ");
		 else 
			 System.out.print("0 ");
		 
		 t2[i] = (term2 >> i & 0x1) != 0x0;
		 
		 if(t2[i])
			 System.out.print("1 ");	 
		 else
			 System.out.print("0 ");
		 
		 System.out.println();
		 if(t1[i] != t2[i])
			 count++;
		 
		 if(count > 1)
			 return 0;
	}
		 if(count == 1) 
			 return 1;
		 else
			 return 0;
 }
 

 public static void main(String[] args) 
 {
      byte term1=(byte)0xaa,term2=(byte)0xff;
      int out;
      out = grayCheck(term1,term2);
      System.out.println(out);
 }
}