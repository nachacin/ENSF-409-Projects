import java.util.Arrays;
/**
 * Provides data fields and methods to identify the lowest time spent in the marathon.
 * 
 * @author Nasih Mohamed Nazeem
 * @version 16.0.1
 * @since July 3, 2021
 */
class Marathon {
    
    /**
     * Array of strings to hold the names of the students.
     */
    private String [] names = new String[11];
    
    /**
     * Array of strings to hold the times of the students.
     */
    private String [] times = new String[11];
    
    /**
     * Initialization of an integer array to hold the times of the students in ascending order.
     */
    public static int [] ascendingtimes;

    /**
     * Initialization of an integer to hold the lowest time of all the students.
     */
    static int lowest_time;

    /**
     * In the main method:
     * 1) We fill in the names and times of the students in the given arrays.
     * 2) Call a method to help identify the lowest time in the marathon.
     * 3) Print the name of the student with the lowest time.
     * @param args Array of strings being input using the console. This is optional.
     */

    
    public static void main (String[] args) {
    
    /**
     * Names of all the students.
     */
    String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane",
    "Emily", "Daniel", "Neda", "Aaron", "Kate" };
    
    /**
     * Times of all the students.
     */
    int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243,
    334, 412, 393, 299, 343, 317, 265};
    
    /**
     * Fill a new array that will eventually be manipulated to sort the array in ascending order.
     */
    ascendingtimes = new int[times.length];
    System.arraycopy(times, 0, ascendingtimes, 0, times.length);

    /**
     * Calling "fastest" to sort the ascendingtimes array and return the first index, which is the lowest time in the marathon.
     */
    Marathon Obj = new Marathon();
    Obj.fastest(ascendingtimes);

    /**
     * Printing the name and the time of the fastest student.
     */
        for(int i = 0; i < times.length; i++){
            if(lowest_time == times[i]){
                System.out.println("The fastest student is " + names[i] + " with a speed of " + times[i]);
            }
        }
    }

    /**
     * Finds the lowest time from a student in the marathon.
     * @param args Array that is manipulated to be sorted in ascending order.
     * @return 243 will be the lowest time after the sorting of the ascendingtimes array and outputting the first index into the lowest_time integer.
     */
    public int fastest(int [] args){ 
        Arrays.sort(args);
        lowest_time = args[0];
        return lowest_time;
    }
}