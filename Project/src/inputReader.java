import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println(dataArray);
        for (Data d: dataArray) {
            tree.insert(d.id, d.faculty, d.major, d.year);
        }
        return tree;
    }

    public static void main(String[] args) {
        var aTree = inputReader.fillTree(".\\database\\input.txt");
        try {
            aTree.print_tree(aTree.root, new PrintWriter(System.out));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
