package sample;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameDataTest {

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
