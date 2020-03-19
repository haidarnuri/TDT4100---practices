package sample;

public class GameData {
    String[] gameDataBoard;
    int count;

    public GameData(String[] gameDataBoard, int count) {
        setGameDataBoard(gameDataBoard);
        this.count = count;
    }

    public GameData() {
        this.gameDataBoard = new String[9];
        setGameDataBoard(gameDataBoard);
        this.count=0;
    }

    public String[] getGameDataBoard() {
        return gameDataBoard;
    }
    public void setGameDataBoard(String[] gameDataBoard) {
        for(int i = 0; i< gameDataBoard.length; i++) {
            if (gameDataBoard[i] == null) {
                gameDataBoard[i]="";
            }
        }
        this.gameDataBoard = gameDataBoard;
    }

    public int getCount() {
        return count;
    }

    public void increaseCountByOne() {
        this.count++;
    }
}
