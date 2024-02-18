package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.Identity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day2PartTwo {

    public static void main(String[] args) {
        String[] dat = read();

        System.out.println(serchForPosible(dat));
    }

    // copys stuff to arreylist to string arrey
    static String[] read() {
        ArrayList<String> games = new ArrayList<String>();
        File file = new File("Day2PartOne.txt");
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

    // ! ne steje prov
    static int serchForPosible(String[] dat) {
        //
        int red = 12;
        int green = 13;
        int blue = 14;
        int ids = 0;
        //
        boolean yes = false;
        for (int i = 0; i < dat.length; i++) {
            yes = false;
            dat[i] = dat[i].replace("Game " + (i + 1) + (": "), "");
            // System.out.println(dat[i]); //!dela
            String[] striped = dat[i].split(";");
            // !nardimo has map za kontroliranje vsot
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < striped.length; j++) {
                striped[j] = striped[j].trim();
                // System.out.println(striped[j]);
            }
            // !mamo loceno po setih
            for (int j = 0; j < striped.length; j++) {
                String[] pair = striped[j].split(",");
                for (int k = 0; k < pair.length; k++) {
                    pair[k] = pair[k].trim();
                    // System.out.println(pair[k]);
                } // !loceno na pare
                for (int k = 0; k < pair.length; k++) {
                    String[] ind = pair[k].split(" ");// !locemo na cifre in oznake
                    // System.out.printf("%s %s \n", ind[0], ind[1]);
                    map.put(ind[1], Integer.valueOf(ind[0]));
                }
                if (map.containsKey("blue")) {
                    if (map.get("blue") > blue) {
                        yes = false;
                        break;
                    }
                }
                if (map.containsKey("green")) {
                    if (map.get("green") > green) {
                        yes = false;
                        break;
                    }
                }
                if (map.containsKey("red")) {
                    if (map.get("red") > red) {
                        yes = false;
                        break;
                    }
                }
                yes = true;
            }

            if (yes) {
                ids = ids + i + 1;
                //System.out.println(i+1);
                yes = false;
            }

        }

        return ids;
    }

}
