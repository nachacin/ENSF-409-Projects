import java.util.Scanner;
import java.util.Arrays;


public class MultiArray {
    public static String message1;
    public static String message2;
    public static String message3;

    public static String [] first_row = new String [60];
    public static String [] second_row = new String [60];
    public static String [] third_row = new String [60];
    private static String [][] finalArray = new String [3][60];


    public static String [] ReverseString(String msg)
    {
        String output = "";
        for (int i = msg.length() - 1; i >= 0; i--)
        {
            output = output + msg.charAt(i);
        }
        
        String [] temp1 = output.split(" ");
        return temp1;
    }

    public static String [] ReverseWords(String msg)
    {
        String [] temp = msg.split(" ");
        String ans = "";
        for (int i = temp.length - 1; i >= 0; i--)
        { 
            ans += temp[i] + " "; 
        }

        String [] temp2  = ans.split(" ");
        return temp2;
    }

    public static String [] ForceUpperCase(String msg)
    {
        String [] output = msg.split("");
        for(int i = 0; i < msg.length(); i++)
        {
            if( (i % 5) == 0)
            {
                output[i] = output[i].toUpperCase();
            }
            
        }
        return output;

    }
    public static void main(String args[])
    {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a sentence: ");

        for(int i = 0; i < 3; i++)
        {
            if(i == 0){
                message1 = scanner.nextLine();
                if (message1.length()>60) {
                    String cutName = message1.substring(0, 60);
                    message1 = cutName;
                }
                first_row = ReverseString(message1);
                
                //System.out.print("Hello " +message1+"!");
            }
            if(i == 1){
                message2 = scanner.nextLine();
                if (message2.length()>60) {
                    String cutName = message2.substring(0, 60);
                    message2 = cutName;
                }
                second_row = ReverseWords(message2);
            }
            if(i == 2){
                message3 = scanner.nextLine();
                if (message3.length()>60) {
                    String cutName = message3.substring(0, 60);
                    message3 = cutName;
                }
                third_row = ForceUpperCase(message3);
            }
        }

        for(int i = 0; i < finalArray.length; i++)
        {
            if(i == 0)
                finalArray[i] = first_row;
            if(i == 1)
                finalArray[i] = second_row;
            if(i == 2)
                finalArray[i] = third_row;
            
        }
        //I like programming!
        
        System.out.println();
        for (int i = 0; i < finalArray.length; i++)
        {
            for (int j = 0; (finalArray[i] != null && j < finalArray[i].length); j++) {
                System.out.print(finalArray[i][j] + " ");
            }
 
            System.out.println();
        }
    }
}
