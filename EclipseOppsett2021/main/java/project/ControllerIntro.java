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
	
	@FXML Button newGame;
	@FXML TextField inputNameField;
	@FXML Label errorField;
	@FXML RadioButton smallBoard,mediumBoard,largeBoard;
	private ToggleGroup group = new ToggleGroup();
	private boolean smallboardSelected = false;
	private boolean mediumboardSelected = false;
	private boolean largeboardSelected = false;
	private boolean toogleSelected = false;
	
	/**
	 * newGameknappen og radioknappene blir intiert. 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newGame.setOnMouseClicked(this);
		handleToogle();
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
		        /*
		         * Disse tre if setningene viser hvilke parameter som bli videresendt til gameController. 
		         * Dette basert på hvilke radioknapp brukeren har trykket på. 
		         */
		        if(toogleSelected) {
		        	if(smallboardSelected) {
		        		userController.passOnParameter(name, 3);
			        }
		        	if(mediumboardSelected) {
		        		 userController.passOnParameter(name, 6);
			        }
		        	if(largeboardSelected) {
		        		 userController.passOnParameter(name, 9);
			        }
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
	
	/*
	 * Dette er logikken bak de ulike radioknappene på intromenyen. 
	 */
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
                	toogleSelected=true;
                   if(tempRadioButton.getId().equals("smallBoard")) {
                	   smallboardSelected = true;
                	   mediumboardSelected = false;
                	   largeboardSelected = false;
                   }
                   if(tempRadioButton.getId().equals("mediumBoard")) {
                	   smallboardSelected = false;
                	   mediumboardSelected = true;
                	   largeboardSelected = false;
                   }
                   if(tempRadioButton.getId().equals("largeBoard")) {
                	   smallboardSelected = false;
                	   mediumboardSelected = false;
                	   largeboardSelected = true;
                   }
                } 
            } 
        }); 
	}
}
