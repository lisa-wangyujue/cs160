// P2 Assignment
// Author: Bobby (Robert) Signor
// Date:   8/30/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

public class P2 {
    public static void main(String args[]) {
        byte b1 = 48;
        short s1 = 21478;
        long l1 = 8777666555L;  //Long Literals end with 'L'.
        int int1 = 123456;

        float f1 = (float) 0.1; //Look! Type casting!
        double d1 = 13.579;

        char c1 = '%', c2 = 'G', c3 = '6';
        String st1 = "Computer", st2 = "Science", st3 = "Excellent";

        System.out.println(b1 + "," + s1 + "," + int1 + "," + l1);
        System.out.println(f1 + "," + d1);
        System.out.println((b1 + s1 + l1 + int1) / 1000000);
        System.out.println(Math.sqrt(f1 * d1));
        System.out.println(int1 / d1);
        System.out.println(c1 + ":" + c2 + ":" + c3);
        System.out.println((char)(c1 + 1) + ";" + (char)(c2 + 1) + ";" + (char)(c3 + 1));
        System.out.println(st1 + " " + st2 + " is " + st3 + "!");
        System.out.println(st1.length() + "," + st2.length() + "," + st3.length());
        System.out.println(st1.toUpperCase());
        System.out.println(st2.substring(1,5));
        System.out.println(st3.indexOf('l'));
        System.out.println(st1.charAt(3));
    }
}