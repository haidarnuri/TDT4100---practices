package sample;

public class Game {
    String[] board;
    int count;
    String playerToMove;

    public Game(String[] board, int count, String playerToMove) {
        this.board = board;
        this.count = count;
        this.playerToMove = playerToMove;
    }

    public Game() {
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPlayerToMove() {
        return playerToMove;
    }

    public void setPlayerToMove(String playerToMove) {
        this.playerToMove = playerToMove;
    }
}
