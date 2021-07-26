import java.io.BufferedReader;
import java.util.ArrayList;

public class RandomPlayer extends Player {
    public RandomPlayer(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        super(aName, aMark, theBoard, aBR);
    }
    protected void makeMove() {
        boolean moveMade = false;
        var randomNum = new RandomGenerator();
        var move = new ArrayList<Integer>(2);  // {row number, column number}
        move.add(0, null);
        move.add(1, null);
        while (moveMade == false) {
            System.out.print("\n" + this.name + ", please enter a row number: ");
            move.set(0, randomNum.discrete(0, 2));
            System.out.print(move.get(0) + "\n");
            System.out.print("\n" + this.name + ", please enter a column number: ");
            move.set(1, randomNum.discrete(0, 2));
            System.out.print(move.get(1) + "\n");
            System.out.println("Overal move: " + move.get(0) + ", " + move.get(1));
            moveMade = theReferee.validateMove(move, this.name);
        }
        board.addMark(move.get(0), move.get(1), this.mark);
    }
    
}
