import java.util.Scanner;

public class VigenereCipher {

	public static void main(String[] args) {
		
		System.out.println("Enter the keyword");
		
		Scanner scanner = new Scanner(System.in);
		String keyword = scanner.nextLine();
		keyword = keyword.toUpperCase();
		
		char letter; //will be used later inside the do-while loop
		
		boolean emptyInput=true; //flag conditional for loop
		
		//vigenere cipher algorithm for inputted keyword
		do {
			System.out.println("Enter your source text (or enter an empty line to end the program)");
			String input = scanner.nextLine();
			String output = "";
			
			int[] keyNumbers = new int[input.length()]; //will store the offsets from the keyword
			
			/*turn all letters in the keyword string from a letter A-Z to a number 0-25 respectively
			and then stores them in an array */
			for (int i = 0; i < keyword.length(); i++) {
				letter = keyword.charAt(i);
				letter -= 'A';
				keyNumbers[i] = letter; 
			}
			
			//extends the keyword through repetition if it is shorter than the input
			if (keyword.length() < input.length()) {
				for (int i = (keyword.length()-1); i < input.length(); i++) {
					for (int j = 0; j < keyword.length(); j++) {
						letter = keyword.charAt(j);
						letter -= 'A';
						keyNumbers[i] = letter; 
					}
				}
			}
			
			/*for (int i = 0; i < keyNumbers.length; i++) {
				System.out.print(keyNumbers[i]);
				System.out.print(" ");
			}*/
			
			int i = 0;
			int offset = 0;
			int g = 1;
			
			while (i < input.length()) {
				char inputtedLetter = input.charAt(i);
				i++;
				
				if ((inputtedLetter >= 'a') && (inputtedLetter <= 'z')) {
					inputtedLetter -= 'a';
					offset = keyNumbers[i-1];
					int encrypted = (inputtedLetter + offset + 26*g) % 26;
					char newLetter = (char) (encrypted + 'a');
					output += newLetter;
					if (Math.abs(offset)/26 >= g ) {
						g++;
					}
				}
				else if ((inputtedLetter >= 'A') && (inputtedLetter <= 'Z')) {
					inputtedLetter -= 'A';
					offset = keyNumbers[i-1];
					int encrypted = (inputtedLetter + offset + 26*g) % 26;
					char newLetter = (char) (encrypted + 'A');
					output += newLetter;
					if (Math.abs(offset)/26 >= g ) {
						g++;
					}
				}
				else {
					char newLetter = inputtedLetter;
					output += newLetter;
					offset = keyNumbers[i-1];
					if (Math.abs(offset)/26 >= g ) {
						g++;
					}
				}
					
			}
			if (!input.isEmpty()) {
				System.out.println("Input   :" + input);
				System.out.println("Processed:" + output.toUpperCase());
				emptyInput = false;
			}
			else if (input.isEmpty()) {
				System.out.println("Program Ended.");
				break;
			}
		} while (!emptyInput);
		scanner.close();
	}
}