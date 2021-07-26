import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private Player opponent;
    private char mark;
    private Referee theReferee;
    private Scanner inputScanner;

    public Player(String aName, char aMark, Scanner aScanner) {
        this.name = aName;
        this.mark = aMark;
        this.board = null;
        this.opponent = null;
        this.inputScanner = aScanner;
    }

    public void play() {
        if((board.xWins() == false) && 
           (board.oWins() == false) &&
           (board.isFull() == false)) {
            this.makeMove();
        }
        
        this.board.display();
        if (board.xWins()) System.out.println(this.name + " wins!");
        else if (board.oWins()) System.out.println(this.name + " wins!");
        else if (board.isFull()) System.out.println("It's a tie!");
        else opponent.play();
    }

    public void makeMove() {
        boolean moveMade = false;
        var move = new ArrayList<Integer>(2);  // {row number, column number}
        move.add(0, null);
        move.add(1, null);
        while (moveMade == false) {
            System.out.print("\n" + this.name + ", please enter a row number: ");
            move.set(0, this.inputScanner.nextInt());
            System.out.print("\n" + this.name + ", please enter a column number: ");
            move.set(1, this.inputScanner.nextInt());
            moveMade = theReferee.validateMove(move, this.name);
        }

        board.addMark(move.get(0), move.get(1), this.mark);
    }

    public void setOpponent(Player theOpponent) {
        this.opponent = theOpponent;
    }

    public void setRef(Referee aReferee) {
        theReferee = aReferee;
    }

    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }
}
