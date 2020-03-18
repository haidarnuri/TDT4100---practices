package sample;

public class GameData {
    String[] board;
    int count;

    public GameData(String[] board, int count) {
        this.board = board;
        this.count = count;
    }

    public GameData() {
        board = new String[9];
        this.count=0;
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

    public void increaseCountByOne() {
        this.count++;
    }
}
