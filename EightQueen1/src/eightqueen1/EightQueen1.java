/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueen1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template

/**
 *
 * @author vinhvo
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * This class represents each solution of the problem. Basically it wraps the board Array.
 */
class Solution {
	private int[] board;

	public Solution(int[] board) {
		this.board = board;
	}

	public void setBoard(int[] board) {
		this.board = board;
	}

	public int[] getBoard() {
		return this.board;
	}
}

class EightQueen {

	private final int[] board;
	private final int size;
	private ArrayList allSolutions = null;

	/**
	 * Each element of the board[] represents a row and the value of each element
	 * specifies the column number where the queen is placed on that particular row.
	 * This method is used to retrieve the board array.
	 *
	 * @return
	 */
	public int[] getBoard() {
		return board;
	}

	/**
	 * The ArrayList allSolutions store all possible solutions. External classes use
	 * this method to retrieve the solutions.
	 *
	 * @return
	 */
	public ArrayList getAllSolutions() {
		return this.allSolutions;
	}

	/**
	 * Constructor of EightQueen. Perform initialization operation.
	 *
	 * @param size
	 */
	public EightQueen(int size) {
		this.size = size;
		board = new int[this.size];
		this.allSolutions = new ArrayList();
	}

	/**
	 * Place a queen in a row and check its validity. If valid then place it in the
	 * next row else backtrack.
	 *
	 * @param row
	 */
	public void place(int row) {
		if (row == size) {
			int[] temp = new int[8];
			System.arraycopy(board, 0, temp, 0, 8);
			allSolutions.add(new Solution(temp));
			//return;
		} else {
			for (int i = 0; i < size; i++) {
				board[row] = i;
				if (valid(row)) 
                            place(row + 1);
			}
		}
	}

	/**
	 * Checks the validity of a position. If valid returns true else returns false.
	 *
	 * @param row
	 * @return
	 */
	public boolean valid(int row) {
		for (int i = 0; i < row; i++) {
			if ((board[i] == board[row]) || Math.abs(board[row] - board[i]) == (row - i)) {
				return false;
			}
		}
		return true;
	}
}

class MyCanvas extends Canvas {

	private Solution solution;

	/**
	 * The calling class use to set the solution and thereby repainting the board by
	 * subsequently calling repaint.
	 *
	 * @param solution
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	/**
	 * This method is called by the graphics thread. Depending on the board values it
	 * calls the drawQueen method.
	 *
	 * @param g
	 */
      @Override
	public void paint(Graphics g) {
		super.paint(g);
		drawGraph(g);
		int[] board = this.solution.getBoard();
            int i, j;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				if (j == board[i]) drawQueen(i, j);
			}
		}
	}

	/**
	 * This method draws the cells on the screen.
	 *
	 * @param g
	 */
	public void drawGraph(Graphics g) {
		g.setColor(Color.WHITE);
		int height = getHeight();
		int width = getWidth();
		int side = height / 8;
		int spacing = 0;
		for (int i = 0; i < 7; i++) {
			spacing += side;
			g.drawLine(0, spacing, width, spacing);
		}
		side = width / 8;
		spacing = 0;
		for (int i = 0; i < 7; i++) {
			spacing += side;
			g.drawLine(spacing, 0, spacing, height);
		}
		colorWhite(g);
	}

	/**
	 * Color alternate cells with white color so as to give the appearance of a chess
	 * board. Coloring black is not required as the background itself is black.
	 *
	 * @param g
	 */
	private void colorWhite(Graphics g) {
		g.setColor(Color.WHITE);
		int side = getWidth() / 8;
		int spacing;
		int alternate = 1;
		for (int i = 0; i < 8; i++) {
			spacing = 0;
			for (int j = 0; j < 4; j++) {
				if (alternate == 1) {
					g.fillRect(spacing, i * getHeight() / 8, side, getHeight() / 8);
				}
				if (alternate == 0) {
					g.fillRect(spacing + side, i * getHeight() / 8, side, getHeight() / 8);
				}
				spacing = spacing + 2 * side;
			}
			alternate = (++alternate) % 2;
		}
	}

	/**
	 * The parameters denotes the cell in which the queen will be placed. Subsequently
	 * the queen is drawn in the cell. The queen is represented as a circle.
	 *
	 * @param row
	 * @param column
	 */
	public void drawQueen(int row, int column) {
		int side = (getHeight() / 8 + getWidth() / 8) / 2;
		int center_x = column * getWidth() / 8 + side / 4;
		int center_y = row * getHeight() / 8 + side / 4;
		Graphics g = getGraphics();
		g.setColor(Color.PINK);
		g.fillOval(center_x, center_y, side / 2, side / 2);
	}
}

class EightQueenProblem extends JFrame implements KeyEventDispatcher {

	private MyCanvas canvas;
	private final EightQueen queen;
	private ArrayList list = null;
	private int count = 0;

	/**
	 * Creates the canvas that will be added to the frame.
	 *
	 * @return
	 */
	private MyCanvas createCanvas() {
		this.canvas = new MyCanvas();
		this.canvas.setBackground(Color.GRAY);
		return this.canvas;
	}

	/**
	 * Creates borderlayout for the frame.
	 *
	 * @return
	 */
	private LayoutManager createLayout() {
		LayoutManager bl = new BorderLayout();
		return bl;
	}

	/**
	 * Called when the frame is getting initialized.
	 */
      @Override
	protected void frameInit() {
		super.frameInit();
		Container cp = getContentPane();
		cp.setLayout(createLayout());
		canvas = createCanvas();
		cp.add(canvas, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 610);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Constructor of the class. The solutions are retrieved and stored in an ArrayList.
	 */
	public EightQueenProblem() {
		KeyboardFocusManager manager;
		manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(this);
		queen = new EightQueen(8);
		queen.place(0);
		list = queen.getAllSolutions();
	}

	/**
	 * This is the method from the KeyEventDispatcher interface. The code
	 * is called whenever a key is pressed. It checks for up arrow and down arrow.
	 * These keys are used for navigating through the solutions. If any of these
	 * keys are pressed then it notifies the halted thread to proceed.
	 *
	 * @param e
	 * @return
	 */
      @Override
	public synchronized boolean dispatchKeyEvent(KeyEvent e) {
		//Use the "up" and "down" buttons from the keyboard to see different solutions
            //There are total 91 solutions for this 8-Queen Problem
            
            if (e.getKeyCode() == 38 && e.getID() == 402) {//Capture the up arrow key
			if (count >= 1) count--;
			notifyAll();
		}
		if (e.getKeyCode() == 40 && e.getID() == 402 && count < 90) {//Capture the down arrow key
		    count++;	
                notifyAll();
		}
		return false;
	}

	/**
	 * Method to draw the queens on the board. This method just sets the value
	 * of the board and calls repaint of the canvas.Then it waits until it receives
	 * notification to proceed.
	 */
	public synchronized void display() {
		while (true) {
			try {
				canvas.setSolution((Solution) list.get(count + 1));
				setTitle("Welcome to the Eight Queen Problem: Solution " + (count + 1));
				canvas.repaint();
				wait();
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws Exception {
		EightQueenProblem queenFrame = new EightQueenProblem();
		queenFrame.display();
	}
}


