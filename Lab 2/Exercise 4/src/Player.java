import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private Player opponent;
    private char mark;

    public Player(String aName, char aMark) {
        this.name = aName;
        this.mark = aMark;
        this.board = null;
        this.opponent = null;
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
        int rowNum;
        int colNum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n" + this.name + ", please enter a row number: ");
        rowNum = scanner.nextInt();
        System.out.print("\n" + this.name + ", please enter a column number: ");
        colNum = scanner.nextInt();
        board.addMark(rowNum, colNum, this.mark);
    }

    public void setOpponent(Player theOpponent) {
        this.opponent = theOpponent;
    }

    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }
}
