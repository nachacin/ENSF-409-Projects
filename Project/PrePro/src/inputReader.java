import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class inputReader {
    private inputReader() {}
    
    private static BufferedReader br;

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Data d: dataArray) {
            tree.insert(d.id, d.faculty, d.major, d.year);
        }
        return tree;
    }


}
