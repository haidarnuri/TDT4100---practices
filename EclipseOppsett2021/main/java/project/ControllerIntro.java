package project;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Dette er kontrollerklassen til introWindow.fxml
 * Public metoder øverst og private metoder nederst. 
 * 
 * @author haidarn
 */
public class ControllerIntro implements Initializable, EventHandler<MouseEvent>{
	
	@FXML private Button newGame;
	@FXML private TextField inputNameField;
	@FXML private Label errorField;
	@FXML private RadioButton smallBoard,mediumBoard,largeBoard;
	private ToggleClass toogle;
	/**
	 * newGameknappen og radioknappene blir intiert. 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newGame.setOnMouseClicked(this);
		toogle = new ToggleClass(smallBoard,mediumBoard,largeBoard);
	}
	
	/**
	 * Denne metoden viser det som skjer når newGameknappen blir trykket på
	 */
	@Override
	public void handle(MouseEvent event) {
		String name = inputNameField.getText(); 
		if(event.getSource()==newGame) {
			try {
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
		        Pane root = loader.load(getClass().getResource("generalGameboard.fxml").openStream());
		        ControllerGameboard userController = (ControllerGameboard)loader.getController();
		        
		        if(toogle.toggleIsSelected()) {
		        	userController.passOnParameter(name, toogle.boardSizeSelected());
		        	Scene scene = new Scene(root);
			        primaryStage.setScene(scene);
			        primaryStage.show();
			        /*
			         * else setningen blir kjørt dersom brukeren har glemt å velge en brettstørrelse. 
			         */
		        }else {
		        	errorField.setText("Du må velge størrelse først");
		        	errorField.setTextFill(Color.color(1, 0, 0));
		        }
		    } catch (IOException e) {
		    	
		    }
          }
		}
}
