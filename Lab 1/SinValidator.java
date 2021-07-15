import java.util.Scanner;
/**
 * Breaks the input into tokens using a delimiter which is whitespace by default. It provides many methods to read and parse various primitive values.
 * 
 * SinValidator takes in a string, converts it into an array of integers and gets tested through multiple steps before attempting to mention whether 
 * the SIN number is valid or invalid.
 * 
 * @author Nasih Mohamed Nazeem
 * @version 16.0.1
 * @since July 4, 2021
 */

public class SinValidator {

/**
 * Initialize the SIN array that will hold the SIN number digits in integer form.
 */
private int[] SIN;

/**
 * Initializing the step variables that will hold values to verify the SIN number's validity.
 */
private int step1;
private int step4;
private int step5;
private int step6;

/**
 * Initializing the variables to test the second, fourth, sixth, and eighth digits in step 4.
 */
private int second;
private int fourth;
private int sixth;
private int eighth;

/**
 * This method is used to add the digits of the resultant product together.
 * 
 * @param x The resultant received after multiplying the SIN digit by 2.
 * @return An integer value that is the addition of the resultant digits in steps 2 and 3.
 */
private int sumDigit(int x)
{
	int result = 0;
	
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
		int i = 0;
		int counter = 0;
		
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
	 * The process of validating a SIN number happens in this method and at the end, we return a true or false value as to whether the SIN number is valid or not.
	 * 
	 * @return True if the last digit of the SIN number matches with the resultant of step 6. False if not.
	 */
	public boolean validateSin()
	{
		for(int i = 0; i < SIN.length; i++)
		{
			if(i == 0 || i == 2 || i == 4 || i == 6)
			{
				step1 += SIN[i];
				
			}
			if(i == 1)
			{
				second = SIN[i] * 2;
				step4 += sumDigit(second);
			}
			if(i == 3)
			{
				fourth = SIN[i] * 2;
				step4 += sumDigit(fourth);
			}
			if(i == 5)
			{
				sixth = SIN[i] * 2;
				step4 += sumDigit(sixth);
			}
			if(i == 7)
			{
				eighth = SIN[i] * 2;
				step4 += sumDigit(eighth);
			}
			
		}

		step5 = step1 + step4;
		step6 = 10 - (step5 % 10);

		if(step6 == SIN[SIN.length - 1]){
			return true;
		}

		return false;
	}

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
