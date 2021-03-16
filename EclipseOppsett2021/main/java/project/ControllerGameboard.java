package project;

import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.google.common.collect.Multiset.Entry;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControllerGameboard implements Initializable, EventHandler<MouseEvent>{

	@FXML private GridPane visualGameboard;
	private HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	@FXML private Label yourName;
	private int buttonSize;
	private GameboardList board;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		board = new GameboardList(9);
		createChildrenOnBoard();	
	}
	
	public void passOnParamter(String name, int buttonsSize) {
		yourName.setText(name);
		this.buttonSize = buttonsSize;
	}

	private void createChildrenOnBoard() {
		int buttonIdCounter=0;
		int boardSize = 3; //Lager 3x3 brett
		int boardSizePixel = 540; 
		int buttonSize = boardSizePixel/boardSize;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Button button = new Button();
				button.setTranslateX(j*buttonSize);
				button.setTranslateY(i*buttonSize+100);
				button.setPrefHeight(buttonSize);
				button.setPrefWidth(buttonSize);
				button.setStyle("-fx-border-color:black");
				//button.setText(String.valueOf(this.buttonSize));
				button.setId("btn"+buttonIdCounter);
				button.setOnMouseClicked(this);
				integerButtonIdMap.put(buttonIdCounter, button);
				buttonIdCounter++;
				visualGameboard.getChildren().add(button);
			}			
		}
	}
	
	
	  private void buttonAction(Button button, int boardPos) {
			Button buttonClicked = button;
			if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E") {
				board.decreaseNumberOfEmptyFields();
				board.leftClickOnCell(boardPos);
				board.fillCellWithEmpty(boardPos);
				//String numberOfBombs = scouter.countNumberOfBombsAroundCell(row, col);
				buttonClicked.setStyle("-fx-background-color: white;");
			}else {
				board.leftClickOnCell(boardPos);
				board.fillCellWithBomb(boardPos);
				buttonClicked.setStyle("-fx-background-color: orange;");
				buttonClicked.setGraphic(addPNGImage("bomb.png")); 
			}
		}
	
	@Override
	public void handle(MouseEvent event) {
		integerButtonIdMap.keySet().stream()
		.filter(key ->event.getSource()==integerButtonIdMap.get(key))
		.forEach(key -> buttonAction(integerButtonIdMap.get(key), key));
	}
	
	
	private ImageView addPNGImage(String imagePath) {
		ImageView view;
		Image img = new Image(getClass().getResourceAsStream(imagePath));
		view = new ImageView(img);
		view.setFitHeight(30);
		view.setFitWidth(30);
		view.setPreserveRatio(true);
	    return view;
	}
	
	
	
	

}
