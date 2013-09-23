// Maze class
// Author: Chris Wilcox
// Date:   8/2/2013
// Class:  CS160
// Email:  wilcox@cs.colostate.edu

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends JFrame { 

	private static final long serialVersionUID = 1L;
	
	// Size and position
    private int numberRows, numberCols;
    private int currentRow,  currentCol;
    private int previousRow, previousCol;

    // User interface
    private JPanel panel;
    private Image player;
    private ArrayList<JButton> buttons;

    // Maze constructor
    public Maze(int numRows, int numCols, int curRow, int curCol) {

    	// Check parameters
    	if ((numRows < 4) || (numCols < 4)) { System.out.println("Number of rows and columns must be >= 4!"); System.exit(-1); }
    	if ((numRows > 8) || (numCols > 8)) { System.out.println("Number of rows and columns must be <= 8!"); System.exit(-1); }
    	if ((curRow < 0)  || (curRow >= numRows)) { System.out.println("Initial row outside maze!"); System.exit(-1); }
    	if ((curCol < 0)  || (curCol >= numCols)) { System.out.println("Initial column outside maze!"); System.exit(-1); }

    	// Store parameters
        numberRows = numRows;
        numberCols = numCols;
        currentRow = curRow;
        currentCol = curCol;
        previousRow = 0;
        previousCol = 0;
        
        // Create panel and grid
        panel = new JPanel();
        panel.setLayout(new GridLayout(numberRows, numberCols, 0, 0));
        add(panel, BorderLayout.CENTER);

        // Load and scale image
		ImageIcon icon = new ImageIcon("Chihiro.jpg");
		player = icon.getImage();
 
        // Build panel of buttons
        buttons = new ArrayList<JButton>(); 
        for (int Row = 0; Row < numberRows; Row++) {
            for (int Col = 0; Col < numberCols; Col++) {

            	// Initialize and add button
            	JButton button = new JButton();
                button.setText(Row + "," + Col);
                button.setIcon(null);
                panel.add(button);
                buttons.add(button);
            }
        }
 
        // Configure window
        setSize(new Dimension(numberCols * 100, numberRows * 100));
        setTitle("Maze");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        redraw();
    }

    // Move robot
    public void moveTo(int newRow, int newCol)
    {
    	// Check parameters
    	if ((newRow < 0) || (newRow >= numberRows) || (newCol < 0) || (newCol >= numberCols)) {
    		System.out.println ("Move to " + newRow + "," + newCol + " is out of bounds!");
    	}
    	else {
    		
    		// Store parameters
    		previousRow = currentRow;
    		previousCol = currentCol;
    		currentRow = newRow;
    		currentCol = newCol;

    		System.out.println ("Chihiro moved to " + newRow + "," + newCol);

    		// Redraw maze
    		redraw();
    	}
    }
    
    // Redraw maze
    private void redraw()
    {
        // Wait for awhile
        try {
            Thread.sleep(500);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Compute index and remove icon
        int index = (previousRow * numberCols) + previousCol;
        buttons.get(index).setIcon(null);
        buttons.get(index).setText(previousRow + "," + previousCol);
        
        // Compute index and add icon
        index = (currentRow * numberCols) + currentCol;
        buttons.get(index).setIcon(new ImageIcon(player));
        buttons.get(index).setText("");
    }
}
