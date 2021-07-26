import java.util.ArrayList;
import java.util.HashSet;

public class Referee {
    private Player xPlayer;
    private Player oPlayer;
    private Board board;
    private HashSet<ArrayList<Integer>> moves;

    public Referee(Player xChosen, Player oChosen, Board gridField) {
        this.xPlayer = xChosen;
        this.oPlayer = oChosen;
        this.board = gridField;
        this.moves = new HashSet<ArrayList<Integer>>();
    }

    public void runTheGame() {
        this.xPlayer.setOpponent(oPlayer);
        this.xPlayer.setRef(this);
        this.oPlayer.setOpponent(xPlayer);
        this.oPlayer.setRef(this);
        this.board.display();
        this.xPlayer.play();
    }

    public boolean validateMove(ArrayList<Integer> moveAttempt, String movingPlayer) {
        if (moves.add(moveAttempt)) {
            return true;
        }
        else {
            System.out.println("\n" + movingPlayer + ", that move has already been made."
                                                   + "\nTry Again!");
            return false;
        }
    }
}
