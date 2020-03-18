package sample;

import java.io.IOException;

public interface SaveAndLoadInterface {
    void saveGame(String[] saveObj);
    String[] loadGame(String[] loadBoard);
}
