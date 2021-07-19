
import java.io.*;
import java.util.Scanner;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;
	
    public Game( ) {
        theBoard  = new Board();
	}
    
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		var scanner = new Scanner(System.in);
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X, scanner);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O, scanner);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee(xPlayer, oPlayer, theGame.theBoard);
        
        theGame.appointReferee(theRef);
		scanner.close();
	}
	

}
