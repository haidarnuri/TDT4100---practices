package sample;


import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveAndLoadBoardTest{

    String[] boardTemp = new String[8];
    String[] boardTemp1 = new String[]{"X"};
    SaveAndLoadBoard board = new SaveAndLoadBoard(boardTemp1);

    String testingSave = new String();

    Gson gson;

    @Test
    public void testingGetBoard_CallingGetBoard_ExpectingBoardInReturn(){
        assertEquals(board.getBoard(),boardTemp);
    }

    @Test
    public void testingSaveGame_AddingAnObjectInSaveGame_ExpectingSaveGameToSaveInString() throws IOException {
        board.saveGame();
    }

    @Override
    public String toString() {
        return String.valueOf(board.getBoard());
    }
}
