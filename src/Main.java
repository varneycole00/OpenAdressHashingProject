
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // This first segment of for loops handle the creation of the table with different numbers of entries and
        // different multiplication factors
        System.out.print("Table Creation Performance: ");
        System.out.println();

        // This loop changes the number of words from the dictionary will be added to the table
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Creation of tables size " + j + ": "); // Marker for the creation of tables with each j
            // For loop that changes the mf for each successive table
            for(double i = 8; i > .5; i = i/2) {
                if (i == .625) { // These if statements are just so we can use the right mf's in the same loop
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

                Stopwatch timer = new Stopwatch(); // Creation of the timer just before the table creation commences

                // Creation of the table, stopping when the number of added words is equal to j
                while(progress < j) {
                    String next = sc.next();
                    table.put(next,next);
                    progress++;
                }
                double time = timer.elapsedTime(); // The elapsed time it took to create each iteration of the table
                System.out.println("\t Time to complete table creation with mf " + i + " is: \t" + time);
            }
        }
        System.out.println();

        System.out.println("Table Searching Performance: ");
        System.out.println();
        // testing search times for LinearProbingHashSymbol tables of different sizes
        // (MF * number of words in the dictionary)
        for(int j = 321165; j > 40144; j = j/2) { // Number of words to be added from the dictionary
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
                // Creation of the tables
                int added = 0; // Making sure we don't add more than the j value for each iteration
                while (added < j) {
                    String s = sc.next();
                    table.put(s, s);
                    added++;
                }
                // There will be a new scanner that is just the words from the dictionary in order
                Scanner checker = new Scanner(new File("words.english.txt"));
                Stopwatch timer = new Stopwatch(); // Timer for each search
                int checked = 0;
                //Checking each time until checked reaches the number of words in the table
                while (checked < j) {
                    String next = checker.next();
                    String keyValues = table.get(next);
                    checked++;
                }
                double time = timer.elapsedTime(); // Elapsed time in seconds it takes to search for every word added
                System.out.println("\t Time to complete table search with mf " + i + " is:   \t" + time);
            }
        }
        System.out.println();

        // Testing how long it takes to delete every added value in each tables
        System.out.println("Full Table Deletion Performance: ");
        System.out.println();
        for(int j = 321165; j > 40144; j = j/2) {
            System.out.println("Deletion of tables size " + j + ": ");
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
                // Creation of the table
                int progress = 0; // Keeps track of how many words have been added
                while(progress < j) {
                    String next = sc.next();
                    table.put(next,next);
                    progress++;
                }
                progress = 0; // keeps track of how many words have been deleted
                Scanner wordsToDelete = new Scanner(new File("words.english.txt"));
                Stopwatch deletionTimer= new Stopwatch(); // Timing how long each deletion takes
                //Deleting values until we have deleted j values
                while(progress < j) {
                    String next = wordsToDelete.next();
                    table.delete(next);
                    progress++;
                }
                double time = deletionTimer.elapsedTime();
                System.out.println("\t Time to complete table creation with mf " + i + " is: \t" + time);
            }
        }

    }
}
