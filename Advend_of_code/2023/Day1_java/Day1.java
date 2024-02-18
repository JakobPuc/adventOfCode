import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    static ArrayList<String> arr = new ArrayList<String>();
    static File file = new File("test.txt");

    public static void main(String[] args) {
        char[][] tab = read();
        int num = countInt(tab);
        System.out.printf("V datoteki je %d stevil\n", num);
        // print2dArrey(tab);
    }

    // ! prebere datoteko in jo shrani v 2d arey charov
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

    static int countInt(char[][] tab) {
        int value = 0;
        for (int i = 0; i < tab.length; i++) {
            int frst = 0;
            int last = 0;
            int many = 0;
            for (int j = 0; j < tab[i].length; j++) {
                if (Character.isDigit(tab[i][j])) {
                    if (many == 0) {
                        frst = Integer.valueOf(tab[i][j]) - 48;
                        many++;
                    } else {
                        last = Integer.valueOf(tab[i][j]) - 48;
                        many++;
                    }
                }
                // System.out.println(frst + " "+ last);
            }

            if (many > 1) {
                value = value + frst * 10 + last;
            } else {
                value = value + frst * 10 + frst;
            }

        }
        return value;
    }

    

    static void print2dArrey(char[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }
}