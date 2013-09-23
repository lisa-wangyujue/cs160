// P4 Assignment
// Author: Robert (Bobby) Signor
// Date: Sep 17, 2013
// Class: CS160
// Email: bobbysig@rams.colostate.edu

import java.util.Scanner;

public class P4 {

	private boolean onEdge = false, exit = false;
    private int curRow, curCol, destRow, destCol, numRows, numCols;
    private Maze board;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Check program arguments
        if (args.length != 2)
        {
            System.out.println("usage: java P4 numberRows numberCols");
            System.exit(-1);
        }

        // Store maze size
        int numberRows = Integer.parseInt(args[0]);
        int numberCols = Integer.parseInt(args[1]);

        // Print maze size
        System.err.println("Number of rows: " + numberRows);
        System.err.println("Number of columns: " + numberCols);

        // Initial position
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Starting row: ");
        int currentRow = keyboard.nextInt();
        System.out.print("Starting column: ");
        int currentCol = keyboard.nextInt();
        keyboard.close();

        // Create maze
        Maze maze = new Maze(numberRows, numberCols, currentRow, currentCol);

        P4 p = new P4();
        p.setMaze(maze, numberRows, numberCols, currentRow, currentCol);
        p.go();
	}

    public void setMaze(Maze m,int nRows, int nCols, int cRow, int cCol) {
        board = m;

        numRows = nRows;
        numCols = nCols;

        curRow = cRow;
        curCol = cCol;

        destCol = numCols + 2;
        destRow = numRows + 2;
    }

    public void setDestination() {
        if (destCol > numCols) {
            destRow = curRow;
            destCol = curCol;
        }
    }

    public int checkEdge() {
        int nR = numRows - 1, nC = numCols - 1;

        if (curRow == 0 && curCol != 0){
            onEdge = true;
            return 1;
        }

        if (curCol == 0 && curRow != nR) {
            onEdge = true;
            return 2;
        }

        if (curRow == nR && curCol != nC) {
            onEdge = true;
            return 3;
        }

        if (curCol == nC && curRow != 0) {
            onEdge = true;
            return 4;
        }

        onEdge = false;
        return 0;
    }

    public void moveTowards(int r, int c) {
        int n = curRow;
        if (curRow < r)
            curRow++;
        if (curRow > r)
            curRow--;
        if (curRow != n)
            board.moveTo(curRow, curCol);

        n = curCol;
        if (curCol < c)
            curCol++;
        if (curCol > c)
            curCol--;
        if (curCol != n)
            board.moveTo(curRow, curCol);
    }

    public void go() {
        while (!exit) {
            switch (checkEdge()) {
                case 0:
                    moveTowards(0, curCol);
                    break;
                case 1:
                    setDestination();
                    moveTowards(0, 0);
                    break;
                case 2:
                    setDestination();
                    moveTowards(numRows - 1, 0);
                    break;
                case 3:
                    setDestination();
                    moveTowards(numRows - 1, numCols - 1);
                    break;
                case 4:
                    setDestination();
                    moveTowards(0, numCols - 1);
                    break;
            }

            if (curCol == destCol && curRow == destRow)
                exit = true;
        }
    }
}
