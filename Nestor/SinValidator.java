import java.util.Scanner;
/**
 * Breaks the input into tokens using a delimiter which is whitespace by default. It provides many methods to read and parse various primitive values.
 * 
 * SinValidator takes in a string, converts it into an array of integers and gets tested through multiple steps before attempting to mention whether 
 * the SIN number is valid or invalid.
 * 
 * @author Nasih Mohamed Nazeem and Nestor Chacin
 * @version 1.0
 * @since July 11, 2021
 */

public class SinValidator {

	/**
	 * Initialize the SIN array that will hold the SIN number digits in integer form.
	 */
	private int[] SIN;

	/**
	 * This method is used to add the digits of the resultant product together.
	 *  
	 * @param x The resultant received after multiplying the SIN digit by 2.
	 * @return An integer value that is the addition of the resultant digits in steps 2 and 3.
	 */
	private int sumDigit(int x)
	{
		int result =0;
		
		while(x > 0){
			result += x % 10;
			x = x /10;
		}
		
		return result;
	}

	/**
	 * This checks whether the number being input is 9 digits long, after converting the string of numbers into an array of integers.
	 * 
	 * @param sin User inputs a SIN number they would like to validate.
	 */
	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	/**
	 * Determines whether the sequence of integers in SIN number is valid
	 * as outlined by algorithm in Lab 1 - ex 3
	 * 
	 * @return a boolean value true/false = valid/invalid
	 */
	public boolean validateSin()
	{
		int sum1 = 0;
		int sum2 = 0;
		int i;
		for(i = 0; i <= 6; i += 2) {
			sum1 += this.SIN[i];
		}
		for(i = 1; i <= 7; i += 2) {
			sum2 += sumDigit(2 * this.SIN[i]);
		}
		if ((this.SIN[8]) == (10 - ((sum1 + sum2)) / 10))
			return true;
		else
			return false;		
	}

	/**
	 * The main method enters a loop where SIN numbers can be tested by inputting
	 * them into the command line. The program notifies the user of the result after
	 * each SIN is inputted
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 10 digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}