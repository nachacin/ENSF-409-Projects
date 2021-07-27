
//Game.java
import java.io.*;

public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;
	
	/**
	 * creates a board for the game
	 */
    public Game( ) {
        theBoard  = new Board();

	}
    
    /**
     * calls the referee method runTheGame
     * @param r refers to the appointed referee for the game 
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
    
	
	public static void main(String[] args) throws IOException {
		
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader br;
		Game theGame = new Game();
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= br.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = br.readLine();
		}

		xPlayer = createPlayer (name, LETTER_X, theGame.theBoard, br);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = br.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = br.readLine();
		}
		
		oPlayer = createPlayer (name, LETTER_O, theGame.theBoard, br);
		
		theRef = new Referee(xPlayer, oPlayer, theGame.theBoard);
        
        theGame.appointReferee(theRef);
	}
	
	/**
	 * Creates the specified type of player indicated by the user. 
	 * 
	 * @param aName player's name
	 * @param aMark player's mark (X or O)
	 * @param theBoard refers to the game board
	 * @param aBR refers to an input stream
	 * @return a newly created player
	 * @throws IOException
	 */
	static public Player  createPlayer(String aName, char aMark, Board theBoard,
			BufferedReader aBR)throws IOException {
		// Get the player type.
		final int NUMBER_OF_TYPES = 4;
		System.out.print ( "\nWhat type of player is " + aName + "?\n");
		System.out.print("  1: Human\n" + "  2: Random Player\n"
		+ "  3: Blocking Player\n");
		System.out.print( "Please enter a number in the range 1-" + NUMBER_OF_TYPES + ": ");
		int playerTypeSelect = 0;

		String input;
		// br = new BufferedReader(new InputStreamReader(System.in)); testing if we can live without this line
		input= aBR.readLine();
		playerTypeSelect = Integer.parseInt(input);
		while (playerTypeSelect < 1 || playerTypeSelect > NUMBER_OF_TYPES) {
			System.out.print( "Please try again.\n");
			System.out.print ( "Enter a number in the range 1-" +NUMBER_OF_TYPES + ": ");
			input= aBR.readLine();
			playerTypeSelect = Integer.parseInt(input);
		}
		
		Player newPlayer = null;
		switch(playerTypeSelect) {
			case 1:
				newPlayer = new HumanPlayer(aName, aMark, theBoard, aBR);
				break;
			case 2:
				newPlayer = new RandomPlayer(aName, aMark, theBoard, aBR);
				break;
			case 3:
				newPlayer = new BlockingPlayer(aName, aMark, theBoard, aBR);
				break;
			// case 4:
			// 	newPlayer = new SmartPlayer(aName, aMark);
			// 	break;
			default:
				System.out.print ( "\nDefault case in switch should not be reached.\n"
				+ "  Program terminated.\n");
				System.exit(0);
		}
		return newPlayer;
	}
}
