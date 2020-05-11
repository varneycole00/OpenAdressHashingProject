import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // creation of the table that will hold every word
        LinearProbingHashST<Integer, String> table = new LinearProbingHashST<>(8*321165);

        // Scanner to take in the dicionary
        Scanner sc = new Scanner(new File("words.english.txt"));

        // adding each word to the table
        int key = 0;
        while(sc.hasNext()) {
            String s = sc.next();
            table.put(key, s);
            key++;
        }
        System.out.println("The LinearProbingHashST has been filled with " +
                "the english dictionary");
        System.out.println("The size of the table: " + table.size());
        Scanner sc2 = new Scanner(new File("words.english.txt"));
        key = 0;

        Stopwatch timer = new Stopwatch();

        while(sc2.hasNext()) {
            String s = sc2.next();
            if(table.contains(key)) {
                String word = table.get(key);
                if(!s.equals(word)) {
                    System.out.println("Did not return correct word");
                }
            }
            key++;
        }
        double time = timer.elapsedTime();
        System.out.println("The amount of time it took to find each object in the table: " + time);
    }
}
