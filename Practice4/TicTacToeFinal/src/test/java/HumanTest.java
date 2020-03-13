import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import sample.Human;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    Gson gson = new Gson();
    @Test
    public void writeHumanToTextfile() throws IOException {
        Human human = new Human("Asbjørn", 31);

        String humanString = gson.toJson(human);

        File file = new File("test.txt");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write(humanString);
        writer.flush();
        writer.close();


        FileReader fileReader = new FileReader(file);
        String readFromFile = readAllCharactersOneByOne(fileReader);

        System.out.println(readFromFile);

        assertEquals(readFromFile, humanString);




        //Human human1 = gson.fromJson(humanString, Human.class);

        //System.out.println(humanString);
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
