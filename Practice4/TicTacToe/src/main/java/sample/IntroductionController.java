package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class IntroductionController {

    @FXML public TextField writeName;
    @FXML public Button newGame;
    @FXML public Button exit;

    GameScreen gameScreen = new GameScreen();

    public void start(ActionEvent event) throws IOException {
        gameScreen.openGameScreen(writeName.getText());
    }

    @FXML
    public void exitGame(ActionEvent event) {
        gameScreen.exitScreen();
    }
}
