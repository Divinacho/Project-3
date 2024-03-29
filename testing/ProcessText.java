import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This file is a part of three parts application. <br><br>
 *
 * The applications purpose is to analyze text files and show statistics including: <br>
 *      - Number of lines in the file <br>
 *      - Letter count and frequency <br>
 *      - Word count and length frequency <br>
 *      - Average word length <br><br>
 *
 * ProcessText class has the main method that runs the application when executed. <br><br>
 *
 * The application will accept arguments and creates a TextStatistics object of each argument
 * if the argument file was found successfully. <br>
 * Then TextStatistics will gather statistics about the file, and the application will print it for the user. <br><br>
 *
 * Please refer to the README file for instructions on how to run the application. <br><br>
 *
 * Created by Mosaab Aljarih on 4/3/2017.
 */
public class ProcessText {
    /**
     * Main method, runs when the application is started
     *
     * @param args accepted file paths as an array
     */
    public static void main(String[] args) {
        if (args.length > 0) { // Arguments have been supplied
            for (String argument : args) { // Loop through each argument
                File fileArgument = new File(argument);

                try {
                    new Scanner(fileArgument);
                    // Create a TextStatistics object with the file
                    TextStatistics myStats = new TextStatistics(fileArgument);

                    // Print out the full report statistics of the file
                    System.out.println(myStats);
                } catch (FileNotFoundException e) { // Bad argument (Not found)
                    System.out.println("File is invalid: " + argument + "\n");
                }
            }
        } else { // Print usage
            System.out.println("Usage: java ProcessText file1 [file2 ...]");
        }
    }
}
