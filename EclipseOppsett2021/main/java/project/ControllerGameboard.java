package project;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
			if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E" 
			&& !board.getduringGameboard().get(boardPos).isCellLeftClicked()) {
				board.leftClickOnCell(boardPos);
				board.decreaseNumberOfEmptyFields();
				board.fillCellWithEmpty(boardPos);
				buttonClicked.setStyle("-fx-background-color: white;");
				String numberOfBombs = board.mineCounter( boardPos);
				buttonClicked.setText(numberOfBombs);
				if(numberOfBombs.isEmpty()) {
					openCellsAround(boardPos);
				}
			}if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="M" 
			&& !board.getduringGameboard().get(boardPos).isCellLeftClicked()) {
				board.leftClickOnCell(boardPos);
				board.fillCellWithBomb(boardPos);
				buttonClicked.setStyle("-fx-background-color: orange;");
				buttonClicked.setGraphic(addPNGImage("bomb.png")); 
			}
		}
	
	  
	  
	  public void openCellsAround(int boardPos) {
			int size = (int)Math.sqrt(board.getGeneratedBeforeGameboard().size());
			int colPos = boardPos%size;
			int rowPos = (int)(boardPos/size);
			List<Integer> posCellAround = new ArrayList<>();
			if(rowPos==0) {
				posCellAround.add(boardPos+size);
				if(colPos!=0) {
					posCellAround.add(boardPos+size-1);
					posCellAround.add(boardPos-1);
				}
				if(colPos!=size-1) {
					posCellAround.add(boardPos+size+1);
					posCellAround.add(boardPos+1);
				}	
			}
			else if(rowPos==size-1) {
				posCellAround.add(boardPos-size);
				if(colPos!=0) {
					posCellAround.add(boardPos-size-1);
					posCellAround.add(boardPos-1);
				}
				if(colPos!=size-1) {
					posCellAround.add(boardPos-size+1);
					posCellAround.add(boardPos+1);
				}	
			}else {
				posCellAround.add(boardPos-size);
				posCellAround.add(boardPos+size);
				if(colPos!=0) {
					posCellAround.add(boardPos-size-1);
					posCellAround.add(boardPos-1);
					posCellAround.add(boardPos+size-1);
				}
				if(colPos!=size-1) {
					posCellAround.add(boardPos-size+1);
					posCellAround.add(boardPos+size+1);
					posCellAround.add(boardPos+1);
				}	
			}
			for(Integer temp: posCellAround) {
				Button tempButton = integerButtonIdMap.get(temp);
				board.leftClickOnCell(temp);
				board.decreaseNumberOfEmptyFields();
				board.fillCellWithEmpty(temp);
				tempButton.setStyle("-fx-background-color: white;");
				String numberOfBombs = board.mineCounter( temp);
				tempButton.setText(numberOfBombs);
			}
			
		}
	  
	@Override
	public void handle(MouseEvent event) {
		integerButtonIdMap.keySet()
						  .stream()
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
