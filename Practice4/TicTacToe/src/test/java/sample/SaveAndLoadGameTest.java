package sample;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveAndLoadGameTest {

     String[] expectedBoardAfterLoadMethod = new String[]{"x"};
    String[] expectedBoardAfterLoadMethod1 = new String[]{"X","H","O","G","f"," "};

    SaveAndLoadGame saveObject = new SaveAndLoadGame();
    GameData gameDataBoard1 = new GameData(expectedBoardAfterLoadMethod1,0);
    GameData gameDataBoard = new GameData(expectedBoardAfterLoadMethod,0);

    @Test
    public void testingGetBoard_CallingGetBoard_ExpectingBoardInReturn(){

    }

    @Test
    public void testingSaveGame_AddingAnObjectInSaveGame_ExpectingSaveGameToSaveInString() throws IOException {
        saveObject.saveGame(gameDataBoard1.getGameDataBoard());
    }

    @Test
    public void testingLoadGame_testingMethodLoadGame_ExpectingToReadSavedString() throws IOException {
        saveObject.loadGame();
    }
}
