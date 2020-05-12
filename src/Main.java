import com.sun.jdi.Value;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        // testing for LinearProbingHashSymbol tables of different sizes(MF * number of words in the dictionary)
        System.out.println("All words in the dictionary performance: ");

        // testing for LinearProbingHashSymbol tables of different sizes(MF * number of words in the dictionary)
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Performance of table including " + j + " words:");
            for (double i = 8; i > .6; i = i / 2) {
                if (i == .625) {
                    i = 1.125;
                }
                if (i == .75) {
                    i = 1.25;
                }
                if (i == 1) {
                    i = 1.5;
                }
                LinearProbingHashST<String, String> table = new LinearProbingHashST<>((int) i * 321165);
                Scanner sc = new Scanner(new File("words.english.txt"));
                while (sc.hasNext()) {
                    String s = sc.next();
                    table.put(s, s);
                }
                Scanner checker = new Scanner(new File("words.english.txt"));
                Stopwatch timer = new Stopwatch();
                int checked = 0;
                while (checked < j) {
                    String next = checker.next();
                    String keyValues = table.get(next);
                    checked++;
                }
                double time = timer.elapsedTime();
                System.out.println("\t Time to complete table search with mf " + i + " is: " + time);
            }
        }


    }
}
