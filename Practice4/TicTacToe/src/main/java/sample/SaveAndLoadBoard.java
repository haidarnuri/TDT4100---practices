package sample;

import com.google.gson.Gson;

public class SaveAndLoadBoard implements SaveAndLoadInterface{

    private String[] board = new String[9];
    private String boardStringToSave = new String();
    private Gson gson;

    public SaveAndLoadBoard(String[] board){
        setBoard(board);
    }

    public SaveAndLoadBoard(){
        setBoard(new String[9]);
    }


    @Override
    public void saveGame(SaveAndLoadBoard saveBoard) {
        this.boardStringToSave = gson.toJson(this);
    }

    @Override
    public void loadGame(SaveAndLoadBoard loadBoard) {
        loadBoard = gson.fromJson(boardStringToSave,SaveAndLoadBoard.class);
        loadBoard.getBoard();
    }

    public String[] getBoard() {
        return this.board;
    }

    public void setBoard(String[] board) {
        if(board.length == 9) {
            this.board = board;
        }
        else{
            throw new IllegalArgumentException("Your board should have 9 places");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(getBoard());
    }
}
