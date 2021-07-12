/**
 * This class acts as a calculator that gathers the average of a set of numbers input by a user. 
 * 
 * @authors Nasih Mohamed Nazeem, Nestor Chacin
 * @version 1.0
 * @since July 11, 2021
 */

public class AverageCalculator {
    /**
     * Entire class is implemented within the main method
     */
    public static void main(String[] args){
        double x = 0;
        System.out.printf("The %s numbers are: ", args.length);
        for (int i = 0; i <args.length; ++i) {
            System.out.printf("%.3f ", Double.parseDouble(args[i]));
            x += Double.parseDouble(args[i]);
        }
        System.out.printf("\n\nAnd their average is: %.3f\n", x / args.length);
    }
}