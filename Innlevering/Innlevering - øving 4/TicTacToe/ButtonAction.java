package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonAction {

    public void openNewScreen() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
        primaryStage.setTitle("Game!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void exitScreen() {
        System.exit(0);
    }

}
