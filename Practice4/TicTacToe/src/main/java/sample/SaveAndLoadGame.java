package sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveAndLoadGame implements SaveAndLoadInterface{
    String filePath ="Saved Games/test.txt";
    String stringFromTxtFile;

    public SaveAndLoadGame(){}

    @Override
    public void saveGame(String[] savedObj){
        try{
            PrintWriter saveFile = new PrintWriter(this.filePath);
            for(int i=0;i<savedObj.length;i++) {
                    saveFile.println(savedObj[i]);

            }
            saveFile.close();

        }catch (FileNotFoundException e){
            System.err.println("File 'test.txt' could not be opened for writing");
        }
    }

    @Override
    public String[] loadGame(String[] loadBoard) {
        Scanner in;
        int i =0;
        try {
            FileReader filePathLoad = new FileReader(this.filePath);
            in = new Scanner(filePathLoad);
            while (in.hasNext()) {
                    loadBoard[i] = in.nextLine();
                    i++;
            }
            in.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Error: file 'test.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
        return loadBoard;
    }



}

