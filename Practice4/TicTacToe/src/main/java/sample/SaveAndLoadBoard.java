package sample;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    public void saveGame() throws IOException {
        this.boardStringToSave = gson.toJson(this);
        File file = new File("test.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(this.boardStringToSave);
        writer.flush();
        writer.close();
        System.out.println(boardStringToSave);
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
    }

    @Override
    public String toString() {
        return String.valueOf(getBoard());
    }
}
