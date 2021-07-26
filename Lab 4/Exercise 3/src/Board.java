/**
 * Prints TicTacToe board to the Command Line. Updates
 * the state of a board through method calls. Stores
 * the state of a board with a 3X3 char array. Keeps a mark 
 * count and ends the game when it reaches 9.
 * 
 * @author ENSF 409 Teaching Staff
 * @version 1.0
 * @since A long time ago.
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	/**
	 * Creates a board object, initilialzing its {@code theBoard}
	 * field to {@code char[3][3]} filled with {@code ' '} chars.
	 * Also sets {@code markCount} field to zero.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	/**
	 * Gets a char value at a specifed cell of a TicTacToe board
	 * @param row A row number
	 * @param col A column number
	 * @return
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	/**
	 * Asserts wether a board is full of marks.
	 * <p>
	 * Warning: Assumes that no illegal/overwriting moves
	 * have been made.
	 * @return True if {@code markCount} = 9, False otherwise
	 */
	public boolean isFull() {
		return markCount == 9;
	}
	/**
	 * Checks if the x-player has won by parsing
	 * through 'x' chars in {@code theBoard} field
	 * @return True if a line of 'x' chars is detected
	 * on {@code theBoard}, false otherwise.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Checks if the o-player has won by parsing
	 * through 'o' chars in {@code theBoard} field
	 * @return True if a line of 'o' chars is detected
	 * on {@code theBoard}, false otherwise.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Prints a TicTacToe board to the command line
	 * with 'x' or 'o' populating its cells according to the
	 * current status of {@code theBoard} field.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
	/**
	 * Adds a passed char to a specified indeces in
	 * {@code theBoard[<row>][column]}.
	 * <p>
	 * Warning: does not check whether char character 
	 * passed is 'x' or 'o'. It is recommended to use the 
	 * {@code Constants} interface to assign valid marks to
	 * for related classes to use throughout runtime.
	 * @param row The row coordinate
	 * @param col The column coordinate
	 * @param newMark a character passed to be placed on {@code theBoard}
	 */
	public void addMark(int row, int col, char newMark) {
		
		theBoard[row][col] = newMark;
		markCount++;
	}
	/**
	 * Reverts state of {@code theBoard} to initial conditions
	 * with {@code ' '} populating every cell.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	/**
	 * Checks for consecutive marks across the rows, columns, and diagonals
	 * represented in {@code theBoard} field.
	 * <p>
	 * If a chararacter inside cell on the TicTacToe board does not 
	 * match {@code mark}, the search for consecutive marks along that 
	 * particular line is terminated.
	 * <p>
	 * If a line in {@code theBoard} is filled with consecutive characters (i.e.
	 * a player has won), no further searching is performed
	 * @param mark The character used to search for matching consecutive characters
	 * @return 1 if a win is detected, 0 otherwise
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;
		// checks for consecutive marks along rows
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}
		// checks for consecutive marks along columns
		// will not run if previous check assigns (result = 1)
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}
		// checks for consecutive marks along the top-left to bottom-right diagonal
		// will not run if previous check assigns (result = 1)
		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		// checks for consecutive marks along the top-right to bottom-left diagonal
		// will not run if previous check assigns (result = 1)
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][2 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	/**
	 * Prints column headers to the command line
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	/**
	 * Prints hyphens to the command line, effectively
	 * drawing the horizontal lines of the TicTacToe board.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	/**
	 * Prints spaces and vertical bars to the commandline,
	 * effectively building the vertical lines of the TicTacToe
	 * board as well as empty space above and below lines that will
	 * contain a mark
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
