package sample;

public class GameData {
    String[] gameDataBoard;
    int count;

    public GameData() {
        setGameDataBoard(new String[9]);
        this.count=0;
    }

    public String[] getGameDataBoard() {
        return gameDataBoard;
    }

    public void setGameDataBoard(String[] gameDataBoard) {
        int tempCountSignInBoard = 0;
        for(int i = 0; i< gameDataBoard.length; i++) {
            if (gameDataBoard[i] == null) {
                gameDataBoard[i]="";
            }
            if(!gameDataBoard[i].isEmpty()){
                tempCountSignInBoard++;
            }
        }
        this.count = tempCountSignInBoard;
        this.gameDataBoard = gameDataBoard;
    }

    public int getCount() {
        return count;
    }

    public void increaseCountByOne() {
        this.count++;
    }
}
