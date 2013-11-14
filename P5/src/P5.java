// P5 Assignment
// Author: Bobby (Robert) Signor
// Date:   11/3/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P5 {
    private static int numberLines = 0, numberTokens = 0, numberChars = 0, numberUpper = 0,
            numberLower = 0, numberDigits = 0, numSpaces = 0, numberTabs = 0, numberSpecial = 0;

    /**
     * Reads the input file into an ArrayList line by line.
     * @param inFileStr Name of input file.
     * @return ArrayList containing file.
     * @throws IOException
     */
    private static ArrayList<String> readFile(String inFileStr) throws IOException{
        ArrayList document = new ArrayList<String>();
        Scanner inFileScan = new Scanner(new File(inFileStr));

        while (inFileScan.hasNextLine()) {
            numberLines++;
            document.add(inFileScan.nextLine());
        }

        inFileScan.close();
        return document;
    }

    /**
     * Gathers statistics about the passed in ArrayList of Strings.
     * @param document ArrayList of Strings to be analyzed.
     */
    private static void gatherStatistics(ArrayList<String> document) {
        StringTokenizer stringTokenizer;

        for (String line : document) {
            stringTokenizer = new StringTokenizer(line);
            numberTokens += stringTokenizer.countTokens();
            /*
            while (stringTokenizer.hasMoreTokens())
                System.out.println(stringTokenizer.nextToken());
            */

            char[] chars = line.toCharArray();
            numberChars += chars.length;

            for (char c : chars) {
                if (Character.isDigit(c))
                    numberDigits++;
                else if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c))
                        numberUpper++;
                    else
                        numberLower++;
                }
                else if (Character.isWhitespace(c)) {
                    if (c == ' ')
                        numSpaces++;
                    else
                        numberTabs++;
                }
                else
                    numberSpecial++;
            }
        }
    }

    /**
     * Writes previously calculated statistics to a text file.
     * @param outFileStr Name of output file.
     * @throws IOException
     */
    private static void writeFile(String outFileStr) throws IOException{
        PrintWriter outFile = new PrintWriter(new File(outFileStr));
        outFile.println("Number of Lines: " + numberLines);
        outFile.println("Number of Words: " + numberTokens);
        outFile.println("Number of Characters: " + numberChars);
        outFile.println("Number of Uppercase: " + numberUpper);
        outFile.println("Number of Lowercase: " + numberLower);
        outFile.println("Number of Digits: " + numberDigits);
        outFile.println("Number of Spaces: " + numSpaces);
        outFile.println("Number of Tabs: " + numberTabs);
        outFile.println("Number of Special: " + numberSpecial);
        outFile.close();
    }

    public static void main(String args[]) {
        try {
            gatherStatistics(readFile(args[0]));
            writeFile(args[1]);
        } catch (IOException e) {
            System.out.println("File read/write error!");
            e.printStackTrace();
        }
    }
}
