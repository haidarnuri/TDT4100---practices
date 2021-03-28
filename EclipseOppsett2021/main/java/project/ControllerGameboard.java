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

/*
 * Dette er kontrollerklassen til "generalGamboar.fxml".
 * Inndelingen er slik at 
 * 1) Først ser du en liste med feltene som brukes i klassen. 
 * 2) Så ser du en oversikt over alle public metodene
 * 3) Så ser du en oversikt over alle private metoder og hjelpemetoder. 
 */


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
		addPNGImageToButton(smileyButton, "duringGameSmiley.png");
	}
	
	public void passOnParameter(String name, int boardSize) {
		this.boardSize = boardSize;
		yourName.setText("Heisann "+name);
		board = new GameboardList(boardSize*boardSize);
		saveAndLoad=new SaveAndLoadGame(board);
		saveAndLoad.saveFile();
		createButtonsOnBoard();
	}
	
	
	  
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource()==saveButton) {
			for (int i = 0; i < board.getduringGameboard().size(); i++) {
				if(integerButtonIdMap.get(i).getStyle()!="-fx-background-color: white;") {
					board.getduringGameboard().get(i).clearCell();
				}
			}
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
	
	/*
	 * Alle private metoder under her. 
	 */
	
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
	
	private void openCellsAround(int boardPos) {
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
	
	  private void buttonAction(Button button, int boardPos) {
			Button buttonClicked = button;
			if(!board.getduringGameboard().get(boardPos).isCellLeftClicked()) {
				if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E") {
					board.leftClickOnCell(boardPos);
					board.decreaseNumberOfEmptyFields();
					board.fillCellWithEmpty(boardPos);
					buttonClicked.setStyle("-fx-background-color: white;");
					String numberOfBombs = board.mineCounter( boardPos);
					buttonClicked.setText(numberOfBombs);
					if(board.noEmptyFieldsLeft()) {
						sendAlertMessage("you Won!");
						addPNGImageToButton(smileyButton,"youWonSmiley.png");
						setOnMouseClickAllButtons(null);
					}
					if(numberOfBombs.isEmpty()) {
						openCellsAround(boardPos);
					}
				}if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="M") {
					board.leftClickOnCell(boardPos);
					board.fillCellWithBomb(boardPos);
					buttonClicked.setStyle("-fx-background-color: orange;");
					addPNGImageToButton(buttonClicked,"bomb.png");
					addPNGImageToButton(smileyButton,"whenLooseSmiley.png");
					sendAlertMessage("you Lost!");
					setOnMouseClickAllButtons(null);
					}
				}
			}
	
	 

	
	
	private void recreateBoard(List<Character> loadedList) {
		//koden under gjør at man kan trykke på samme knappene etter å ha trykket på loadfil. 
		board.getduringGameboard().stream()
								  .forEach(cell -> cell.setCellLeftClicked(false));
		
		//fjerner png bilder på cellen. Tar bort minebildene
		setOnMouseClickAllButtons(null);
	
		
		/*
		 * Tre ting her: 
		 * 1) Itererer gjennom board objektet. 
		 * 2) Iterer gjennom loadedList.
		 * 3) Restarter brettet til tilstanden som stemmer med det som er lagret i savefile.txt
		 * 
		 */
		
		int recountEmptyCellsLeft=0;
		for(int i=0;i<loadedList.size();i++) {
			if(loadedList.get(i)=='E') {
				board.leftClickOnCell(i);
				board.decreaseNumberOfEmptyFields();
				board.fillCellWithEmpty(i);
				integerButtonIdMap.get(i).setStyle("-fx-background-color: white;");
				String numberOfBombs = board.mineCounter( i);
				integerButtonIdMap.get(i).setText(numberOfBombs);
				recountEmptyCellsLeft++;
			}else {
				integerButtonIdMap.get(i).setStyle("-fx-background-color: grey;");
				integerButtonIdMap.get(i).setStyle("-fx-border-color:black;");
				integerButtonIdMap.get(i).setText("");
			}
		}
		
		//setter numberOfEmtpy-tellinga til riktig verdi. 
		board.setNumberOfEmpty(boardSize*boardSize-recountEmptyCellsLeft);
		
		//Denne aktiverer alle knappene igjen. 
		setOnMouseClickAllButtons(this);

		
	}
	
	/*
	 * Itererer gjennom alle knapper og legger til en event. 
	 * 
	 */
	private void setOnMouseClickAllButtons(EventHandler<MouseEvent> event) {
		integerButtonIdMap.keySet()
		  .stream()
		  .forEach(key -> integerButtonIdMap.get(key).setOnMouseClicked(event));
	}
	
	/**
	 * Denne metoden legger til bilde på en knapp
	 * 
	 * @param button knapp
	 * @param imagePath navn på PNG bilde
	 * 
	 */
	private void addPNGImageToButton(Button button, String imagePath) {
		ImageView view;
		Image img = new Image(getClass().getResourceAsStream(imagePath));
		view = new ImageView(img);
		view.setFitHeight(30);
		view.setFitWidth(30);
		view.setPreserveRatio(true);
		button.setGraphic(view);
	}
	
	/**
	 * Denne metoden sender ulike beskjeder til bruker
	 * 
	 * @param messageToUser beskjed som skal sendes 
	 * 
	 * 
	 */
	 private void sendAlertMessage(String messageToUser) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(messageToUser);
			alert.show();
	  }

	
	

}
