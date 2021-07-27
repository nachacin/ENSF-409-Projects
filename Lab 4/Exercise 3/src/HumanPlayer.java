import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class HumanPlayer extends Player {
    public HumanPlayer(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        super(aName, aMark, theBoard, aBR);
    }
    /**
     * Checks if move made by last Player resulted in a win or if
     * the board is full. If neither is the case, it calls the {@code makeMove}
     * method.
     * <p>
     * Then calls for the board to be displayed with updated state and
     * calls {@code theReferee} to make further decisions.
     */
    protected void play() {
        var board = super.getBoard();
        this.makeMove();        
        board.display();
        super.getReferee().turnTransition(super.getOpponent());
    }
    protected void makeMove() {
        boolean moveMade = false;
        var br = super.getReader();
        var name = super.getName();
        var move = new ArrayList<Integer>(2);  // {row number, column number}
        move.add(0, null);
        move.add(1, null);
        while (moveMade == false) {
            System.out.print("\n" + name + ", please enter a row number: ");
            try {
                move.set(0, Integer.parseInt(br.readLine()));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.print("\n" + name + ", please enter a column number: ");
            try {
                move.set(1, Integer.parseInt(br.readLine()));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            moveMade = super.getReferee().validateMove(move, name);
        }

        super.getBoard().addMark(move.get(0), move.get(1), super.getMark());
    }
    
}
