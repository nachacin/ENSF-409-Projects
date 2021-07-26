import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Player {
    protected String name;
    protected Board board;
    protected Player opponent;
    protected final char mark;
    protected Referee theReferee;
    protected BufferedReader br;

    public Player(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        this.name = aName;
        this.mark = aMark;
        this.board = theBoard;
        this.opponent = null;
        this.br = aBR;
    }

    protected void play() {
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

    protected void makeMove() {
        boolean moveMade = false;
        var move = new ArrayList<Integer>(2);  // {row number, column number}
        move.add(0, null);
        move.add(1, null);
        while (moveMade == false) {
            System.out.print("\n" + this.name + ", please enter a row number: ");
            try {
                move.set(0, Integer.parseInt(this.br.readLine()));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.print("\n" + this.name + ", please enter a column number: ");
            try {
                move.set(1, Integer.parseInt(this.br.readLine()));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            moveMade = theReferee.validateMove(move, this.name);
        }

        board.addMark(move.get(0), move.get(1), this.mark);
    }

    protected void setOpponent(Player theOpponent) {
        this.opponent = theOpponent;
    }

    protected void setRef(Referee aReferee) {
        theReferee = aReferee;
    }

    protected void setBoard(Board theBoard) {
        this.board = theBoard;
    }
}
