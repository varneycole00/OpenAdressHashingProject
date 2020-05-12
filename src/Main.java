import com.sun.jdi.Value;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Table Creation Performance: ");
        System.out.println();
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Creation of tables size " + j + ": ");
            for(double i = 8; i > .5; i = i/2) {
                if (i == .625) {
                    i = 1.125;
                }
                if (i == .75) {
                    i = 1.25;
                }
                if (i == 1) {
                    i = 1.5;
                }
                if(i == .5625) {
                    i = .75;
                }
                LinearProbingHashST<String, String> table = new LinearProbingHashST<>((int) (i * j));
                Scanner sc = new Scanner(new File("words.english.txt"));
                int progress = 0;
                Stopwatch timer = new Stopwatch();
                while(progress < j) {
                    String next = sc.next();
                    table.put(next,next);
                    progress++;
                }
                double time = timer.elapsedTime();
                System.out.println("\t Time to complete table creation with mf " + i + " is: \t" + time);
            }
        }

        System.out.println("Table Searching Performance");
        System.out.println();
        // testing for LinearProbingHashSymbol tables of different sizes(MF * number of words in the dictionary)
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Performance of table including " + j + " words:");
            for (double i = 8; i > .5; i = i / 2) {

                if (i == .625) {
                    i = 1.125;
                }
                if (i == .75) {
                    i = 1.25;
                }
                if (i == 1) {
                    i = 1.5;
                }
                if(i == .5625) {
                    i = .75;
                }
                LinearProbingHashST<String, String> table = new LinearProbingHashST<>((int) (i * j));
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
                System.out.println("\t Time to complete table search with mf " + i + " is:   \t" + time);
            }
        }

        System.out.println("Full Table Deletion Performance: ");
        System.out.println();
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Creation of tables size " + j + ": ");
            for(double i = 8; i > .5; i = i/2) {
                if (i == .625) {
                    i = 1.125;
                }
                if (i == .75) {
                    i = 1.25;
                }
                if (i == 1) {
                    i = 1.5;
                }
                if(i == .5625) {
                    i = .75;
                }
                LinearProbingHashST<String, String> table = new LinearProbingHashST<>((int) (i * j));
                Scanner sc = new Scanner(new File("words.english.txt"));
                int progress = 0;
                Stopwatch timer = new Stopwatch();
                while(progress < j) {
                    String next = sc.next();
                    table.put(next,next);
                    progress++;
                }
                double time = timer.elapsedTime();
                System.out.println("\t Time to complete table creation with mf " + i + " is: \t" + time);
            }
        }

    }
}
