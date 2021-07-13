import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
/**
 * Provides data fields and methods to identify the lowest time spent in the marathon.
 * 
 * @author Nasih Mohamed Nazeem
 * @version 1.0
 * @since July 3, 2021
 */
class Marathon {
    public static int [] ascendingtimes;
    static int lowest_time;
    

    public static void main (String[] args)
    {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> times = new ArrayList<String>();
        String sin;
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("Please enter the name of the participant"); 
            sin = scan.nextLine();
            if(sin.toUpperCase().equals("QUIT")) 
            break;
            names.add(sin);
            System.out.println("Please enter the running time of the participant"); 
            sin = scan.nextLine();
            times.add(sin);
        }

        findFastestRunner(times);

        for(int i = 0; i < times.size(); i++){
            if(lowest_time == Integer.parseInt(times.get(i))){
                System.out.println();
                System.out.println("The fastest student is " + names.get(i) + " with a speed of " + times.get(i));
            }
        }
    }
    public static void findFastestRunner(ArrayList<String> arr)
    {
        ArrayList<String> newList = new ArrayList<>(arr);
        Collections.sort(newList);
        lowest_time = Integer.parseInt(newList.get(0));
    }        // Call the function findFastestRunner and pass the running times array list to it
        // Print the name of the fastestrunner to the console
    
    
}