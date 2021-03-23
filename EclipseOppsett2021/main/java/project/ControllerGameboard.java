package project;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerGameboard implements Initializable,EventHandler<MouseEvent>{

	@FXML private Pane visualGameboard;
	@FXML private Label yourName;
	@FXML Button smileyButton, loadButton, saveButton;
	private GameboardList board;
	private HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	private int boardSize;
	private ReadAndWriteFile saveAndLoad;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		saveButton.setOnMouseClicked(this);
		loadButton.setOnMouseClicked(this);
		smileyButton.setGraphic(addPNGImage("duringGameSmiley.png"));
	}
	
	public void passOnParameter(String name, int boardSize) {
		this.boardSize = boardSize;
		yourName.setText("Heisann "+name);
		board = new GameboardList(boardSize*boardSize);
		saveAndLoad=new SaveAndLoadGame(board);
		createButtonsOnBoard();
	}

	private void createButtonsOnBoard() {
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
			Alert alert = new Alert(AlertType.INFORMATION);
			if(!board.getduringGameboard().get(boardPos).isCellLeftClicked()) {
				if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E") {
					board.leftClickOnCell(boardPos);
					board.decreaseNumberOfEmptyFields();
					board.fillCellWithEmpty(boardPos);
					buttonClicked.setStyle("-fx-background-color: white;");
					String numberOfBombs = board.mineCounter( boardPos);
					buttonClicked.setText(numberOfBombs);
					if(board.noEmptyFieldsLeft()) {
						alert.setContentText("You won");
						alert.show();
						smileyButton.setGraphic(addPNGImage("youWonSmiley.png"));
						integerButtonIdMap.keySet()
						  .stream()
						  .forEach(key -> integerButtonIdMap.get(key).setOnMouseClicked(null));
					}
					if(numberOfBombs.isEmpty()) {
						openCellsAround(boardPos);
					}
				}if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="M") {
					board.leftClickOnCell(boardPos);
					board.fillCellWithBomb(boardPos);
					buttonClicked.setStyle("-fx-background-color: orange;");
					buttonClicked.setGraphic(addPNGImage("bomb.png")); 
					smileyButton.setGraphic(addPNGImage("whenLooseSmiley.png"));
					alert.setContentText("You lost");
					alert.show();
					integerButtonIdMap.keySet()
									  .stream()
									  .forEach(key -> integerButtonIdMap.get(key).setOnMouseClicked(null));
					}
				}
			}
		
	
	  
	  
	  public void openCellsAround(int boardPos) {
		  List<Integer> posCellsAround = board.scoutsCellsAround(boardPos);
			for(Integer temp: posCellsAround) {
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
		if(event.getSource()==saveButton) {
			saveAndLoad.saveFile();
		}else if(event.getSource()==loadButton) {
			List<Character> loadedList = null;
			try {
				loadedList = saveAndLoad.loadFile();
				recreateBoard(loadedList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			integerButtonIdMap
			  .keySet()
			  .stream()
			  .filter(key ->event.getSource()==integerButtonIdMap.get(key))
			  .forEach(key -> buttonAction(integerButtonIdMap.get(key), key));
		}
	}
	
	private void recreateBoard(List<Character> loadedList) {
		int boardPos = 0;
		board.getduringGameboard().stream().forEach(cell -> cell.setCellLeftClicked(false));
		integerButtonIdMap.values().stream().forEach(btn ->btn.setStyle("-fx-background-color: none;"));
		integerButtonIdMap.values().stream().forEach(btn ->btn.setStyle("-fx-border-color:black"));
		integerButtonIdMap.values().stream().forEach(btn ->btn.setText(""));

		/*
		for(int i=loadedList.size()-1;i>0;i--) {
			if(i%2==0) {
				boardPos = i;
				//posisjon/id på brettet
			}else{//Figurer fra during gameboard
				//Restarter først brettet.
				board.getduringGameboard().stream().forEach(cell -> cell.setCellLeftClicked(false));
				integerButtonIdMap.values().stream().forEach(btn ->btn.setStyle("-fx-background-color: white;"));
				//buttonAction(integerButtonIdMap.get(boardPos),boardPos);
			}
			*/
			/*
			 * if(!board.getduringGameboard().get(boardPos).isCellLeftClicked()) {
				if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E") {
					board.leftClickOnCell(boardPos);
					board.decreaseNumberOfEmptyFields();
					board.fillCellWithEmpty(boardPos);
					buttonClicked.setStyle("-fx-background-color: white;");
					String numberOfBombs = board.mineCounter( boardPos);
					buttonClicked.setText(numberOfBombs);
					if(board.noEmptyFieldsLeft()) {
						alert.setContentText("You won");
						alert.show();
						smileyButton.setGraphic(addPNGImage("youWonSmiley.png"));
						integerButtonIdMap.keySet()
						  .stream()
						  .forEach(key -> integerButtonIdMap.get(key).setOnMouseClicked(null));
					}
					if(numberOfBombs.isEmpty()) {
						openCellsAround(boardPos);
					}
			 */
		
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
