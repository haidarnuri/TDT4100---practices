package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameScreen {

    public GameScreen(){
    }

    public void openGameScreen(String name) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GameWindow.fxml"));
        Parent root = loader.load();
        GameController display = loader.getController();
        display.showNameOnScreen(name);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Game!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void exitScreen(){
        System.exit(0);
    }



}
