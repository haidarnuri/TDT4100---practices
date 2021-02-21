package project;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ControllerGameboard implements Initializable{

	
	private GameBoard board = new GameBoard();
	@FXML private GridPane gridpane;
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		   board.fillBoardWithFigures();
		   fillGridpaneGameBoard();
		  gridpane.setStyle("-fx-background-color: black;");
		 
	}
	
	  
	private void fillGridpaneGameBoard() {
		        for (int column = 0; column < gridpane.getColumnCount(); column++) {
		            for (int row = 0 ; row < gridpane.getRowCount(); row++) {
		                TextField textField = new TextField(board.getGeneratedBeforeBoard()[row][column]);
		                System.out.println();
		                textField.setStyle("-fx-pref-width: 66px; -fx-pref-height: 44px;");
		                //textField.setStyle(";");
		                GridPane.setConstraints(textField, column, row);
		                gridpane.getChildren().add(textField);
		            }
		        }
	}

	
}
