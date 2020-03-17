package sample;

import java.io.IOException;

public interface SaveAndLoadInterface {
    void saveGame() throws IOException;
    void loadGame(SaveAndLoadBoard loadBoard);
}
