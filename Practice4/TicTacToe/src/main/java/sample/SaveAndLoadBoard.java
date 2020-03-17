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
    }


    @Override
    public void saveGame(SaveAndLoadBoard saveBoard) {
        System.out.println(saveBoard);
        this.boardStringToSave = gson.toJson(saveBoard);
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
            this.board = board;
        System.out.println(this.board);
    }

    @Override
    public String toString() {
        return String.valueOf(getBoard());
    }
}
