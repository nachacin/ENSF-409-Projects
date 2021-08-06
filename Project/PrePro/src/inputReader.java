import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utility class with static factory methods related to reading files and
 * filling tree objects with data fields within the files
 * 
 * @author Nestor Chacin
 * @since 2021 - 08 - 06
 * @version 1.0
 */
public class inputReader {
    /**
     * Suppresses default constructor, ensuring non-instantiability
     */
    private inputReader() {}
    
    private static BufferedReader br;
    /**
     * Creates {@code BinSearchTree} object and fills it through repeated 
     * {@code insert()}. Arguments passed in {@code insert()} are Strings
     * (trimmed and split lines) that corresponding to the line format of 
     * {@code input.txt}.
     * @param pathName the pathname to the file to filled
     * @return the newly filled BinSearchTree object
     */
    public static BinSearchTree fillTree(String pathName) {
        var tree = new BinSearchTree();
        File source = new File(pathName);
        String inputLine;
        String[] dataFields;
        var dataArray = new ArrayList<Data>();
        try {
            br = new BufferedReader(new FileReader(source));
            while ((inputLine = br.readLine()) != null) {
                dataFields = inputLine.trim().split("\\s+");
                var student = new Data(dataFields[0], dataFields[1], dataFields[2], dataFields[3]);
                dataArray.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A file with that pathname does not exist");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unknown error ocurred in fillTree!");
            e.printStackTrace();
        }
        for (Data d: dataArray) {
            tree.insert(d.id, d.faculty, d.major, d.year);
        }
        return tree;
    }


}
