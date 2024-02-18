import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day2PartTwo {

    public static void main(String[] args) {
        String[] dat = read();

        System.out.println(parseTxt(dat));

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

    static int parseTxt(String[] dat) {
        int sumTmp = 0;
        int red = 0;
        int blue = 0;
        int green = 0;
        int sum = 0;
        for (int i = 0; i < dat.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();// !nardim HasMap zato da se reseta pa vsaki igri
            /*********************************************************************************************/
            dat[i] = dat[i].replace("Game " + (i + 1) + ": ", "");
            String[] sets = dat[i].split(";|,");
            for (int j = 0; j < sets.length; j++) {
                sets[j] = sets[j].trim();
                // System.out.println(sets[j]);
                // !kle so seti
                String[] sepret = sets[j].split(" ");
                // !mogl bi dt not sam najvecjo vrednost

                for (int k = 0; k < sepret.length - 1; k += 2) {
                    // System.out.println(sepret[k+1]);
                    if (map.containsKey(sepret[k + 1])) {
                        if (map.get(sepret[k + 1]) < Integer.valueOf(sepret[k])) {
                            map.put(sepret[k + 1], Integer.valueOf(sepret[k]));
                        }
                    } else {
                        map.put(sepret[k + 1], Integer.valueOf(sepret[k]));
                    }

                }

            }
            if (map.containsKey("red")) {
                red = map.get("red");
            }
            if (map.containsKey("blue")) {
                blue = map.get("blue");
            }
            if (map.containsKey("green")) {
                green = map.get("green");
            }

            sumTmp = ((green != 0) && (blue != 0) && (red != 0)) ? green * blue * red
                    : (green == 0) ? blue * red : (blue == 0) ? red : 0;
            sum += sumTmp;
            green = 0;
            blue = 0;
            red = 0;
            sumTmp = 0;
            // System.out.println(sumTmp);

            sum += sumTmp;
            // System.out.println();
        }
        return sum;
    }
}
