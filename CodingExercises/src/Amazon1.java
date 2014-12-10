public class Amazon1 
{
	// Checks if a char input 'c' is vowel or not, returns true if 'c' is a vowel; false if 'c' is a consonant
	static boolean isVowel(char c) {

		if (c == 'a') {
			return true;
		} else if (c == 'e') {
			return true;
		} else if (c == 'i') {
			return true;
		} else if (c == 'o') {
			return true;
		} else if (c == 'u') {
			return true;
		} else if(c == 'A'){
			return true;
		} else if(c == 'E'){
			return true;
		} else if(c == 'I'){
			return true;
		} else if(c == 'O'){
			return true;
		} else if(c == 'U'){
			return true;
		}
		return false;
	}

	public static String eliminateVowelString(String string){
		// Eliminate all the vowels from the input string
		// Return the string without vowels
		
		if(string == "") return string;
		
		String result = "";

		for(int i = 0; i<string.length();i++) {
			boolean bool = isVowel(string.charAt(i));

			if (!bool) {
				char x = string.charAt(i);
				result = result + x;
			}
		}    	

		return result;
	} 

	public static void main(String[] args) 
	{
		String string="abcde";
		String result; 
		result=eliminateVowelString(string);
		System.out.println(result);
	}
}
