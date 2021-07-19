public class Referee {
    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    public Referee(Player xChosen, Player oChosen, Board gridField) {
        this.xPlayer = xChosen;
        this.oPlayer = oChosen;
        this.board = gridField;
    }

    public void runTheGame() {
        this.xPlayer.setOpponent(oPlayer);
        this.oPlayer.setOpponent(xPlayer);
        this.board.display();
        this.xPlayer.play();
    }
}
