// P3 Assignment
// Author: Bobby (Robert) Signor
// Date:   9/07/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

import java.util.Scanner;
import java.text.DecimalFormat;

public class P3 {
    public static void main(String args[]) {
    	DecimalFormat dollaBillzYall = new DecimalFormat("0.00");
    	Scanner keys = new Scanner(System.in);

    	System.out.print("Gross Salary: ");
    	double salary = keys.nextDouble();

    	System.out.print("Number of Exemptions: ");
    	int exemptions = keys.nextInt();

    	System.out.print("Interest Income: ");
    	double interest = keys.nextDouble();

    	System.out.print("Capital Gains: ");
    	double gains = keys.nextDouble();

    	System.out.print("Charitable Contributions: ");
    	double contributions = keys.nextDouble();

        double income = salary + interest + gains;
    	System.out.println("Total Income: $" + dollaBillzYall.format(income));
    	double adjIncome = income - (exemptions * 1500.00) - contributions;
    	System.out.println("Adjusted Income: $" + dollaBillzYall.format(adjIncome));

    	double allTax = totalTaxMath(adjIncome, 0.16, 25000,  12000) + totalTaxMath(adjIncome, 0.23, 45000,  25000) + totalTaxMath(adjIncome, 0.28, 45000);
    	System.out.println("Total Tax: $" + dollaBillzYall.format(allTax));

    	System.out.println("State Tax: $" + dollaBillzYall.format(adjIncome * 0.05));
    }

    public static double totalTaxMath(double n, double tax, double top, double floor) {
    	if (n - floor <= 0)
    		return 0;
    	if (n >= top)
    		return tax * (top - floor);
    	return tax * (n - floor);
    }

    public static double totalTaxMath(double n, double tax, double floor) {
    	if (n - floor <= 0)
    		return 0;
    	return tax * (n - floor);
    }
}