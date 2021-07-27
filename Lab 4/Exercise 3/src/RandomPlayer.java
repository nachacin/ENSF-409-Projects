import java.io.BufferedReader;
import java.util.ArrayList;

public class RandomPlayer extends Player {
    public RandomPlayer(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        super(aName, aMark, theBoard, aBR);
    }
    protected void play() {
        var board = super.getBoard();
        this.makeMove();        
        board.display();
        super.getReferee().turnTransition(super.getOpponent());
    }
    protected void makeMove() {
        boolean moveMade = false;
        var name = super.getName();
        var randomNum = new RandomGenerator();
        var move = new ArrayList<Integer>(2);  // {row number, column number}
        move.add(0, null);
        move.add(1, null);
        while (moveMade == false) {
            move.set(0, randomNum.discrete(0, 2));
            move.set(1, randomNum.discrete(0, 2));
            System.out.println(name + " chooses: " + move.get(0) + ", " + move.get(1));
            moveMade = super.getReferee().validateMove(move, name);
        }
        super.getBoard().addMark(move.get(0), move.get(1), super.getMark());
    }
}
