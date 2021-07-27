import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Player {
    private String name;
    private Board thisgetBoard;
    private Player opponent;
    private final char mark;
    private Referee theReferee;
    private BufferedReader br;

    public Player(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        this.name = aName;
        this.mark = aMark;
        this.thisgetBoard = theBoard;
        this.opponent = null;
        this.br = aBR;
    }

    protected abstract void play();

    protected abstract void makeMove();

    protected void setOpponent(Player theOpponent) {
        this.opponent = theOpponent;
    }

    protected void setRef(Referee aReferee) {
        theReferee = aReferee;
    }

    protected void setBoard(Board theBoard) {
        this.thisgetBoard = theBoard;
    }
    /**
     * Returns name field
     * @return {@code name}
     */
    protected String getName() {
        return this.name;
    }
    /**
     * Returns board field
     * @return {@code board}
     */
    protected Board getBoard() {
        return this.thisgetBoard;
    }
    /**
     * Returns opponent field.
     * @return {@code opponent}
     */
    protected Player getOpponent() {
        return this.opponent;
    }
    /**
     * Returns buffered reader in {@code br} field.
     * @return {@code br}
     */
    protected BufferedReader getReader() {
        return this.br;
    }
    /**
     * Returns {@code theReferee} field.
     * @return {@code theReferee}
     */
    protected Referee getReferee () {
        return this.theReferee;
    }
    /**
     * Returns {@code mark} constant field
     * @return {@code mark}
     */
    protected char getMark() {
        return this.mark;
    }
}
