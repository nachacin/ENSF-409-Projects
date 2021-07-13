/**
 * This class acts as a calculator that gathers the average of a set of numbers input by a user. 
 * 
 * @author Nasih Mohamed Nazeem
 * @version 16.0.1
 * @since July 3, 2021
 */

public class AverageCalculator {
    /**
     * Initializes a variable to hold the average value of the numbers being input.
     */
    
    private static double average;

    /**
     * Initializes a variable to hold the sum value of the numbers being input.
     */

    private static double sum;
    
    /**
     * Calculations to find the average value happen in this function.
     * @param args an array of Strings being input by a user.
     */

    public static void main(String[] args){

        /**
         * Initializes an array of doubles with the same amount of indices as String args.
         */
        
         double [] myDoubles = new double[args.length];
        

        System.out.print("The 4 numbers are: ");
        
        /**
         * For loop to gather convert String args into double myDoubles. This will make it easy to find the sum as well as the average.
         */
        
         for(int i = 0; i < args.length; i++){
            myDoubles[i] = Double.parseDouble(args[i]);
            sum += myDoubles[i];
            average = sum/myDoubles.length;
            System.out.printf("%.3f",myDoubles[i]);
            System.out.print(" ");
        }
        
        System.out.println("\n");
        System.out.print("And their average is: ");
        System.out.printf("%.3f", average);
    }
}
