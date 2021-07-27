import java.io.BufferedReader;
import java.util.ArrayList;

public class BlockingPlayer extends RandomPlayer {
    
    public BlockingPlayer(String aName, char aMark, Board theBoard, BufferedReader aBR) {
        super(aName, aMark, theBoard, aBR);
    }
    protected void makeMove() {
        boolean moveMade = false;
        var name = super.getName();
        var randomNum = new RandomGenerator();
        var blockMove = this.getBlock();
        if (blockMove != null) {
            super.getBoard().addMark(blockMove.get(0), blockMove.get(1), super.getMark());
            System.out.println("\n" + name + " chooses: " + blockMove.get(0) + ", " + blockMove.get(1) + "\n");
        } else {
            var move = new ArrayList<Integer>(2);  // {row number, column number}
            move.add(0, null);
            move.add(1, null);
            while (moveMade == false) {
                move.set(0, randomNum.discrete(0, 2));
                move.set(1, randomNum.discrete(0, 2));
                System.out.println("\n" + name + " chooses: " + move.get(0) + ", " + move.get(1) + "\n");
                moveMade = super.getReferee().validateMove(move, name);
            }
            super.getBoard().addMark(move.get(0), move.get(1), super.getMark());
    
        }
    }

    protected ArrayList<ArrayList<Integer>> getAllMoves() {
        var move = new ArrayList<Integer>(2);
        var allMoves = new ArrayList<ArrayList<Integer>>();
        for (Integer i = 0; i < 3; i++) {
            for(Integer j = 0; j < 3; j++) {
                move.add(0, i);
                move.add(1, j);
                allMoves.add(move);
            }
        }
        return allMoves;
    }
    protected ArrayList<Integer> getBlock() {
        var opponentMoves = super.getBoard().getOpponentMoves(super.getMark());
        var movesAvail = super.getBoard().getMovesAvail();
        var blockCell = new ArrayList<Integer>(2);
        blockCell = null;
        // 1 Checking rows
        for (int i = 0; i < 3; i++) {
            int oppMoves = 0;
            int openCell = 0;
            for (int j = 0; j < 3; j++) {
                var cell = new ArrayList<Integer>(2);
                cell.add(0, i);
                cell.add(1, j);
                if (opponentMoves.contains(cell)) {
                    oppMoves += 1;
                }
                if (movesAvail.contains(cell)) {
                    openCell += 1;
                    blockCell = cell;
                }
            }
            if (oppMoves == 2 && openCell == 1) {
                return blockCell;
            }
        }
        // Checking collumns
        for (int j = 0; j < 3; j++) {
            int oppMoves = 0;
            int openCell = 0;
            for (int i = 0; i < 3; i++) {
                var cell = new ArrayList<Integer>(2);
                cell.add(0, i);
                cell.add(1, j);
                if (opponentMoves.contains(cell)) {
                    oppMoves += 1;
                }
                if (movesAvail.contains(cell)) {
                    openCell += 1;
                    blockCell = cell;
                }
            }
            if (oppMoves == 2 && openCell == 1) {
                return blockCell;
            }
        }
        int oppMoves = 0;
        int openCell = 0;
        // Checking top-left to bottom-right diagonal
        for (int i = 0; i < 3; i++) {
            var cell = new ArrayList<Integer>(2);
            cell.add(0, i);
            cell.add(1, i);
            if (opponentMoves.contains(cell)) {
                oppMoves += 1;
            }
            if (movesAvail.contains(cell)) {
                openCell += 1;
                blockCell = cell;
            }
        }
        if (oppMoves == 2 && openCell == 1) {
            return blockCell;
        }
        oppMoves = 0;
        openCell = 0;
        // Checking top-right to bottom-left diagonal
        for (int i = 0; i < 3; i++) {
            var cell = new ArrayList<Integer>(2);
            cell.add(0, i);
            cell.add(1, 2 - i);
            if (opponentMoves.contains(cell)) {
                oppMoves += 1;
            }
            if (movesAvail.contains(cell)) {
                openCell += 1;
                blockCell = cell;
            }
        }
        if (oppMoves == 2 && openCell == 1) {
            return blockCell;
        } else {
            blockCell = null;
        }
        return blockCell;
    }
}
