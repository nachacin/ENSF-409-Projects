/**
 * Provides data fields and methods to identify the lowest time spent in the marathon.
 * 
 * @author Nasih Mohamed Nazeem
 * @version 1.0
 * @since July 11, 2021
 */

public class Marathon {

    /**
     * Returns the index of the smallest value in an array of int
     * @param timeArray is used to access the array elements for parsing
     */
    static int fastestIndex(int[] timeArray){
        int fastest = 0;
        for (int i = 1; i < timeArray.length; ++i) {
            if (timeArray[i] < timeArray[fastest])
                fastest = i;
        }
        return fastest;
    }

    /**
     * main method stores the data to test the Marathon class
     * @param args
     */
    public static void main (String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie",
        "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane",
        "Emily", "Daniel", "Neda", "Aaron", "Kate" };

        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243,
            334, 412, 393, 299, 343, 317, 265};
        
        int winner = fastestIndex(times);
        System.out.println(names[winner] + " was the fastest runner with a time of " + times[winner] + " minutes.");
    }
}