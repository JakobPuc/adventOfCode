import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3PartOne {
    static ArrayList<String> arr = new ArrayList<String>();
    static File file = new File("test.txt");

    public static void main(String[] args) {
        
    }




    static char[][] read() {
        try {
            //! naredis Scanner objekt, ki 
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                arr.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        // System.out.println(arr.size());
        char[][] char2d = new char[arr.size()][];
        // System.out.println(char2d.length);
        for (int i = 0; i < arr.size(); i++) {
            char2d[i] = arr.get(i).toCharArray();
        }
        return char2d;
    }

}