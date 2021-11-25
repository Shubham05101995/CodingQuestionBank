import java.util.Scanner;
public class ReturnSubsequencesOfInputString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which String you want to find the susequences? ");
		String inputString = sc.next();
		System.out.println("Please find the below subsequence for your entered String "+inputString);
		String[] output = findSubsequences(inputString);
		for( String s:output) {
			System.out.println(s);
		}
	}
	
	public static String[] findSubsequences(String inputString) {
		
		//Base Case --> Return empty string if input string length is 0.
		if(inputString.length() == 0) {
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		String[] smallOutput = findSubsequences(inputString.substring(1));
		String[] output = new String[2*smallOutput.length];
		
		//This loop will simply copy the smallOutput string array contents.
		for(int i = 0; i<smallOutput.length; i++) {
			output[i] = smallOutput[i];
		}
		
		//This loop will copy the smallOutput string array contents but this time it will include the 0th character of the input string..
		for(int i=0;i<smallOutput.length;i++) {
			output[smallOutput.length + i] = inputString.charAt(0) + smallOutput[i];
		}
		
		return output;
	}
}
