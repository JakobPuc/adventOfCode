import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2PartTwo {
    public static void main(String[] args) {
        String[] dat = read();

        parseTxt(dat);
        // System.out.println();

    }

    static String[] read() {
        ArrayList<String> games = new ArrayList<String>();
        File file = new File("Day2PartTwo.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                games.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        String[] dat = new String[games.size()];
        for (int i = 0; i < games.size(); i++) {
            dat[i] = games.get(i);
        }
        return dat;
    }

    static void parseTxt(String[] dat) {
        int read = 0;
        int green = 0;
        int blue = 0;
        for (int i = 0; i < dat.length; i++) {
            dat[i] = dat[i].replace("Game " + (i + 1) + ": ", "");
            String [] sets = dat[i].split(";");
            for (String string : sets) {
                string = string.trim();
                System.out.println(string);
            }
        }
    }
}
