// P6 Assignment
// Author: Bobby (Robert) Signor
// Date:   11/11/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class P6 {
    //Pie Chart Variables
    private static String pieTitle = "Pie Chart";
    private static int numPieElements;
    private static String[] pieLabels;
    private static double[] pieElements;

    //Bar Chart Variables
    private static String barTitle = "Bar Chart";
    private static int numBarElements;
    private static double[] barData1;
    private static double[] barData2;

    //Line Graph Variables
    private static String lineTitle = "Line Graph";
    private static int numLineElements;
    private static double[] lineData1;
    private static double[] lineData2;
    private static double[] lineData3;

    private void readFile(String inputFile) throws IOException {
        Scanner in = new Scanner(new File(inputFile));

        //Gather Pie Information
        numPieElements = in.nextInt();
        pieLabels = new String[numPieElements];
        pieElements = new double[numPieElements];
        for (int i = 0; i < numPieElements; i++)
            pieLabels[i] = in.next();
        for (int i = 0; i < numPieElements; i++)
            pieElements[i] = in.nextDouble();

        //Gather Bar Information
        numBarElements = in.nextInt();
        barData1 = new double[numBarElements];
        barData2 = new double[numBarElements];
        for (int i = 0; i < numBarElements; i++)
            barData1[i] = in.nextDouble();
        for (int i = 0; i < numBarElements; i++)
            barData2[i] = in.nextDouble();

        //Gather Line Information
        numLineElements = in.nextInt();
        lineData1 = new double[numLineElements];
        lineData2 = new double[numLineElements];
        lineData3 = new double[numLineElements];
        for (int i = 0; i < numLineElements; i++)
            lineData1[i] = in.nextDouble();
        for (int i = 0; i < numLineElements; i++)
            lineData2[i] = in.nextDouble();
        for (int i = 0; i < numLineElements; i++)
            lineData3[i] = in.nextDouble();
    }

    private void displayCharts() {
        //Plot Pie Chart
        Plotter pies = new Plotter(pieTitle);
        pies.pieChartData(numPieElements, pieElements);
        pies.pieChartLabels(numPieElements, pieLabels);
        pies.drawGraph(Plotter.eType.PIECHART);

        //Plot Bar Chart
        Plotter bars = new Plotter(barTitle);
        bars.barChartData(0, numBarElements, barData1);
        bars.barChartData(1, numBarElements, barData2);
        bars.drawGraph(Plotter.eType.BARCHART);

        //Plot Line Graph
        Plotter lines = new Plotter(lineTitle);
        lines.lineGraphData(0, numLineElements, lineData1);
        lines.lineGraphData(1, numLineElements, lineData2);
        lines.lineGraphData(2, numLineElements, lineData3);
        lines.drawGraph(Plotter.eType.LINEGRAPH);
    }

    public static void main(String args[]) {
        try {
            P6 p6 = new P6();
            p6.readFile(args[0]);
            p6.displayCharts();
        } catch (IOException e) {
            System.out.println("File Read Error!");
            e.printStackTrace();
            System.out.println("\nProgram execution halted!");
        }
    }
}
