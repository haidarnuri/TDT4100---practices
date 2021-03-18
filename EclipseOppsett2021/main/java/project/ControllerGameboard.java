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

public class ControllerGameboard implements EventHandler<MouseEvent>{

	@FXML private GridPane visualGameboard;
	private HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	@FXML private Label yourName;
	private GameboardList board;
	
	
	public void passOnParameter(String name, int boardSize) {
		yourName.setText(name);
		board = new GameboardList(boardSize*boardSize);
		createChildrenOnBoard(boardSize);
	}

	private void createChildrenOnBoard(int boardSize) {
		int buttonIdCounter=0;
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
				buttonClicked.setStyle("-fx-background-color: white;");
				buttonClicked.setText(String.valueOf(mineCounter( boardPos)));
			}else {
				board.leftClickOnCell(boardPos);
				board.fillCellWithBomb(boardPos);
				buttonClicked.setStyle("-fx-background-color: orange;");
				buttonClicked.setGraphic(addPNGImage("bomb.png")); 
			}
		}
	
	@Override
	public void handle(MouseEvent event) {
		integerButtonIdMap.keySet()
						  .stream()
						  .filter(key ->event.getSource()==integerButtonIdMap.get(key))
						  .forEach(key -> buttonAction(integerButtonIdMap.get(key), key));
		
	}
	
	private int mineCounter(int boardPos) {
		int size = (int)Math.sqrt(board.getGeneratedBeforeGameboard().size());
		int bombCounter = 0;
		int colPos = boardPos%size;
		int rowPos = (int)(boardPos/size);
		if(rowPos==0) {
			if(board.getGeneratedBeforeGameboard().get(boardPos+size).getFigur() =="M") {
				bombCounter++;
			}
			if(colPos!=0) {
				if(board.getGeneratedBeforeGameboard().get(boardPos+size-1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					bombCounter++;
				}
			}
			if(colPos!=size-1) {
				if(board.getGeneratedBeforeGameboard().get(boardPos+size+1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					bombCounter++;
				}
			}	
		}else if(rowPos==size-1) {

			if(board.getGeneratedBeforeGameboard().get(boardPos-size).getFigur() =="M") {
				bombCounter++;
			}
			if(colPos!=0) {
				if(board.getGeneratedBeforeGameboard().get(boardPos-size-1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					bombCounter++;
				}
			}
			if(colPos!=size-1) {
				if(board.getGeneratedBeforeGameboard().get(boardPos-size+1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					bombCounter++;
				}
			}	
		}else {

			if(board.getGeneratedBeforeGameboard().get(boardPos-size).getFigur() =="M") {
				bombCounter++;
			}
			if(board.getGeneratedBeforeGameboard().get(boardPos+size).getFigur() =="M") {
				bombCounter++;
			}
			if(colPos!=0) {
				if(board.getGeneratedBeforeGameboard().get(boardPos-size-1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos+size-1).getFigur() =="M") {
					bombCounter++;
				}
			}
			if(colPos!=size-1) {
				if(board.getGeneratedBeforeGameboard().get(boardPos-size+1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos+size+1).getFigur() =="M") {
					bombCounter++;
				}
				if(board.getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					bombCounter++;
				}
			}	
		}
		return bombCounter;
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
