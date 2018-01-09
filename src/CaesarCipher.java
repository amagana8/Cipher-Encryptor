import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] strings) { 

		System.out.println("Enter the shift value (must be between -25 and -1 or between 1 and 25)");
		
		Scanner scanner = new Scanner(System.in);
		int offset = scanner.nextInt();
		
		//loop to keep asking for offset value until a valid one is entered
		while (!((offset >= -25 && offset <= -1) || (offset>=1 && offset<=25))) {
			System.out.println(offset + " is not a valid shift value.");
			System.out.println("Enter the shift value (must be between -25 and -1 or between 1 and 25)");
			offset = scanner.nextInt();
		}
		
		boolean emptyInput=true; //flag conditional for loop
		
		//caesar cipher algorithm with inputted offset
		do {
			System.out.println("Enter your source text (or enter an empty line to end the program)");
			scanner.nextLine();
			String input = scanner.nextLine();
			String output = "";

			int i = 0;
			
			while (i < input.length()) {
				char inputtedLetter = input.charAt(i);
				i++;
				
				if ((inputtedLetter >= 'a') && (inputtedLetter <= 'z')) {
					inputtedLetter -= 'a';
					int encrypted = (inputtedLetter+26+offset) % 26;
					char newLetter = (char) ('a' + encrypted);
					output += newLetter;
				}
				else if ((inputtedLetter >= 'A') && (inputtedLetter <= 'Z')) {
					inputtedLetter -= 'A';
					int encrypted = (inputtedLetter+26+offset) % 26;
					char newLetter = (char) ('A' + encrypted);
					output += newLetter;
				}
				else {
					char newLetter = inputtedLetter;
					output += newLetter;
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