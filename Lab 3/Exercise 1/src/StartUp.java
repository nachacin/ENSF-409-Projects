import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StartUp {
    private static BufferedReader br;

    public static ArrayList<Tool> getInventory(){
        getToolsFileName();
        return fillTools();
    }

    private static void getToolsFileName() {
        boolean fileFound = false;
        String fileName;
        Scanner kb = new Scanner(System.in);
        while(!fileFound) {

            try {
                System.out.println("Please enter the filename of a .txt file containing the current itemized inventory.");
                fileName = kb.nextLine();
                File itemsFile = new File("database\\" + fileName);
                br = new BufferedReader(new FileReader(itemsFile));
                fileFound = true;
            } catch (FileNotFoundException e) {
                System.out.println("That filename does not exist. Try Again!");
            } catch (Exception e) {
                System.err.println("Unknown error. Try Again?");
            }
        }

    }

    private static ArrayList<Tool> fillTools() {
        ArrayList<Tool> toolList = new ArrayList<Tool>();
        String line;
        String[] fields;
        
        try {
            while ((line = br.readLine()) != null) {
                fields = line.split(";");
                var aTool = new Tool(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]),
                                        Double.parseDouble(fields[3]), fields[4]);
                toolList.add(aTool);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number formats in file are invalid");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("readLine() failed to read the file");
            e.printStackTrace();
        }
        return toolList;
    }



        
        

}
