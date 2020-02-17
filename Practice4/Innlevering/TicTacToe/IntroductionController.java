package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;

public class IntroductionController extends ButtonAction {

@FXML public TextField writeName;
@FXML public Button newGame;
@FXML public Button exit;



    public void start(ActionEvent event) throws IOException {
      openNewScreen();
    }

    public void exitGame(ActionEvent event) {
        exitScreen();
    }




}
