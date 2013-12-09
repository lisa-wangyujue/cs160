// P8 Assignment
// Author: Bobby (Robert) Signor
// Date:   12/8/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P8 {
    private final int NUM_NOTES = 13, PLAY_LENGTH = 11025;
    private GuitarString[] strings = new GuitarString[13];
    private final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "H"};

    public P8() {
        for (int i = 0; i < NUM_NOTES; i++) {
            double frequency = 440.0 * Math.pow(1.05956, i - 9);
            strings[i] = new GuitarString(frequency);
        }
    }

    public static void main(String[] args) {
        // Instantiate object
        P8 p8 = new P8();

        // Play keyboard
        if (args.length >= 2)
            p8.playKeyboard(args[1]);
        else
            p8.playKeyboard();

        // 	Play file
        if (args.length >= 1)
            p8.playFile(args[0]);
    }

    // Play from keyboard
    public void playKeyboard() {
        String keyboard = "Q2W3ER5T6Y7UI";
        System.out.println("Press keys to play music, 'X' exits).");
        int keyInt;
        char key;

        // Processing loop
        while (true) {
            // Has user has typed a key?
            if (StdDraw.hasNextKeyTyped()) {
                // Which key has been typed
                key = Character.toUpperCase(StdDraw.nextKeyTyped());
                System.out.println("Key pressed: " + key);

                if (key == 'X')
                    break;

                // Pluck string
                keyInt = keyboard.indexOf(key);
                if (keyInt >= 0) {
                    pluckGuitar(NOTES[keyInt]);
                }
            }

            // Play guitar
            playGuitar();
        }
    }

    // Play from keyboard and record to file
    public void playKeyboard(String inFile) {
        try {
            String keyboard = "Q2W3ER5T6Y7UI";
            System.out.println("Press keys to play music, 'X' exits).");
            PrintWriter out = new PrintWriter(new File(inFile));
            int keyInt;
            char key;

            // Processing loop
            while (true) {
                // Has user has typed a key?
                if (StdDraw.hasNextKeyTyped()) {
                    // Which key has been typed
                    key = Character.toUpperCase(StdDraw.nextKeyTyped());
                    System.out.println("Key pressed: " + key);

                    if (key == 'X')
                        break;

                    // Pluck string
                    keyInt = keyboard.indexOf(key);
                    if (keyInt >= 0) {
                        out.println(NOTES[keyInt]);
                        pluckGuitar(NOTES[keyInt]);
                    }
                }

                // Play guitar
                playGuitar();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Play from file
    public void playFile(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            String cur;
            while (in.hasNext()) {
                cur = in.next();
                pluckGuitar(cur);
                for (int i = 0; i < PLAY_LENGTH; i++)
                    playGuitar();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Pluck guitar strings
    public void pluckGuitar(String note) {
        if (note.equals("C"))
            strings[0].pluck();
        else if (note.equals("C#"))
            strings[1].pluck();
        else if (note.equals("D"))
            strings[2].pluck();
        else if (note.equals("D#"))
            strings[3].pluck();
        else if (note.equals("E"))
            strings[4].pluck();
        else if (note.equals("F"))
            strings[5].pluck();
        else if (note.equals("F#"))
            strings[6].pluck();
        else if (note.equals("G"))
            strings[7].pluck();
        else if (note.equals("G#"))
            strings[8].pluck();
        else if (note.equals("A"))
            strings[9].pluck();
        else if (note.equals("A#"))
            strings[10].pluck();
        else if (note.equals("B"))
            strings[11].pluck();
        else if (note.equals("H"))
            strings[12].pluck();
    }

    // Play guitar strings
    public void playGuitar() {
        double sample = 0;

        // Combine the samples
        for (int i = 0; i < NUM_NOTES; i++)
            sample += strings[i].sample();

        // Send sample to standard audio
        StdAudio.play(sample);

        // Advance the guitar simulation
        for (int i = 0; i < NUM_NOTES; i++)
            strings[i].tic();
    }
}