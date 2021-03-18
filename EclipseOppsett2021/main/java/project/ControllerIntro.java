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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ControllerIntro implements Initializable, EventHandler<MouseEvent>{
	
	@FXML Button newGame;
	@FXML TextField inputNameField;
	@FXML RadioButton smallBoard,mediumBoard,largeBoard;
	private ToggleGroup group = new ToggleGroup();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newGame.setOnMouseClicked(this);
		handleToogle();
	}
	
	@Override
	public void handle(MouseEvent event) {
		String name = inputNameField.getText(); 
		if(event.getSource()==newGame) {
			try {
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
		        GridPane root = loader.load(getClass().getResource("generalGameboard.fxml").openStream());
		        ControllerGameboard userController = (ControllerGameboard)loader.getController();
		        userController.passOnParameter(name, 3);
		        Scene scene = new Scene(root);
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    } catch (IOException e) {

		    }
          }
		}
	
	
	private void handleToogle() {
		smallBoard.setToggleGroup(group);
		mediumBoard.setToggleGroup(group);
		largeBoard.setToggleGroup(group);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
        { 
            public void changed(ObservableValue<? extends Toggle> ob,  Toggle o, Toggle n) 
            { 
                RadioButton tempRadioButton = (RadioButton)group.getSelectedToggle(); 
                if (tempRadioButton != null) { 
                    System.out.println(tempRadioButton.getText() + " selected"); 
                } 
            } 
        }); 
	}
	

	
	
	

}
