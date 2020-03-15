package sample;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import sample.Game;
import sample.Human;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    Gson gson = new Gson();
    @Test
    public void saveGameAndLoadGame() {
        String[] aBoard = new String[]
                {
                        "X", "", "",
                        "X", "O", "O",
                        "", "", ""};
        int count = 4;
        String playerToMove = "X";

        Game game = new Game(aBoard, count, playerToMove);

        String gameStringToSave = gson.toJson(game);
        System.out.println(gameStringToSave);


    }

    public static String readAllCharactersOneByOne(Reader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        int nextChar;
        while ((nextChar = reader.read()) != -1) {
            content.append((char) nextChar);
        }
        return String.valueOf(content);
    }
}
