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

    @FXML
    public void start(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GameWindow.fxml"));
        Parent root = loader.load();
        GameController display = loader.getController();
        display.initName(writeName.getText());
        Stage primaryStage = new Stage();
        //GameController controller = root.<GameController>getController();
        //controller.initData(writeName.getText());
        primaryStage.setTitle("Game!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void exitGame(ActionEvent event) {
        System.exit(0);
    }
}
