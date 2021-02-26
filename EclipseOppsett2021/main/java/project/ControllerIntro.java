package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ControllerIntro implements Initializable, EventHandler<MouseEvent>{
	
	@FXML Button newGame;


	@Override
	public void handle(MouseEvent event) {
		if(event.getSource()==newGame) {
			try {
				Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("MinesweeperGameBoardTilepane3x3.fxml"));
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		    } catch (IOException e) {

		    }
          }
		}
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newGame.setOnMouseClicked(this);
	}

}
