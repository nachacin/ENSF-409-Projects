
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in) throws NumberFormatException, IOException{ 
        // takes a sequence of integers as inputs, and outputs their sum

	int s, nextInt;
	s = 0;
	nextInt = 0;

	System.out.println("Please input the sequence of integers to sum, terminated by a 0");
        try {
			nextInt = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Please enter a number");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                //Read next datum in input. An integer is expected

	while (nextInt!=0) {
	    s = s + nextInt;
	    try {
			nextInt = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Please enter a number");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
	String c = null;
 
	System.out.println("Do you wish to calculate a sum? (y/n)");

	try {
		c = in.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         //Read next datum in input. A string "y" or "n" is expected

	while (!c.equals("y") && !c.equals("n")) {
	    System.out.println("Please answer y or n");
	    try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	while (c.equals("y")) {
	    try {
			sum(in);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    System.out.println("Do you wish to calculate another sum? (y/n)");
	    try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	}

	System.out.println("Goodbye");
    }
}
