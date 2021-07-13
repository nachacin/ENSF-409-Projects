import java.util.Scanner;
/**
 * Takes 3 lines that are entered by the user, the lines are stored as 3 seperate strings
 * that are manipulated as required by lab 1 - ex 4. The lines are stored into a 3X60 char array
 * and later printed for the user.
 * 
 * @author Nestor Chacin and Nasih Nazeem
 * @version 1.0
 * @since July 11, 2021
 */
public class MDArray {
    /**
     * Takes 3 strings and stores them in a 3X60 char array. Each character is
     * is rearranged/formatted as required by lab 1 - ex 4
     * @param str1
     * @param str2
     * @param str3
     * @return 3X60 char array
     */
    private static char [][] deepArray(String str1, String str2, String str3) {
        int i, j, k;
        String[] str2Split = str2.split(" ");
        char[][] charArray = new char [3][60];
        for(i = 0, j = str1.length() - 1; (i < 60 && j >= 0); i++, j--) {
            charArray [0][i] = str1.charAt(j);
        }
        i = 0;
        
        for(j = str2Split.length - 1; j >= 0; j--) {
            for(k = 0; k < str2Split[j].length(); k++) {
                charArray [1][i] = str2Split[j].charAt(k);
                i++;
            }
            charArray [1][i + 1] = ' ';
            i += 2;
        }

        for(i = 0, j = 0; (i < 60 && j < str3.length()); i++, j++) {
            if (i % 5 == 0)
                charArray [2][i] = Character.toUpperCase(str3.charAt(j));
            else
                charArray [2][i] = str3.charAt(j);
        }
        return charArray;
    }
    /**
     * Collects lines inputted by the user and calls deepArray for testing
     * @param args 
     */
    public static void main(String[] args) {
        String first, second, third;
        int i;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first sentence");
        first = scan.nextLine();
        System.out.println("Please enter the second sentence");
        second = scan.nextLine();
        System.out.println("Please enter the third and last sentence");
        third = scan.nextLine();
        char [][] threeBy60 = deepArray(first, second, third);

        for(i = 0; i < threeBy60.length; i++) {
            System.out.println(String.valueOf(threeBy60[i]));
        }
    }


}
