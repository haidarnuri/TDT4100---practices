package setupcheck;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuiWorks extends Application {
    public void start(Stage stage) {
        Label hello = new Label("Om du ser denne teksten, så kan du kompilere og kjøre Java!");

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(hello);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(args);
    }
}