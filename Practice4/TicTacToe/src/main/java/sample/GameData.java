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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
