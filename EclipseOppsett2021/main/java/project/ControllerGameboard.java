package project;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
	private Gameboard board;
	private HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	private int boardSize;
	private ReadAndWriteFile saveAndLoad;
	
	
	/*
	 * Denne metoden aktiverer save og loadknappen. 
	 * I tillegg legger den til smiley i knappen øverst. 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		saveButton.setOnMouseClicked(this);
		loadButton.setOnMouseClicked(this);
		addPNGImageToButton(smileyButton, "duringGameSmiley.png");
	}
	
	
	/**
	 * Denne metoden gjør følgende:  
	 * 1) tar imot parametere fra introController. 
	 * 2) Initierer et board objekt. 
	 * 3) Initierer et saveAndLoad objekt. 
	 * 4) Lager spillbrettet ved å kalle på createButtonsOnBoard-metoden
	 * 
	 * @param name selvvalgt brukernavn
	 * @param boardSize størrelse på en rad
	 * 
	 */
	public void passOnParameter(String name, int boardSize) {
		this.boardSize = boardSize;
		yourName.setText("Heisann "+name);
		board = new Gameboard(boardSize*boardSize);
		saveAndLoad=new SaveAndLoadGame(board);
		saveAndLoad.saveFile();
		createButtonsOnBoard();
	}
	
	
	/**
	 * Viser hva som skjer når ulike knapper på brettet blir trykket på. 
	 * 
	 * @param event et mouseeventobjekt. 
	 * 
	 */
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
	
	/**
	 * Denne metoden lager knappene på brettet. 
	 * Blir kalt av passOnParameter()-metoden
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
	
	/**
	 * Åpner celler rundt en gitt celle. 
	 * Brukes til å åpne nabocellene til en celle som har 0 miner rundt seg. 
	 * 
	 * @param boardPos posisjon til knapp. 
	 */
	
	private void openCellsAround(int boardPos) {
		  List<Integer> posCellsAround = board.scoutsCellsAround(boardPos);
			for(Integer temp: posCellsAround) {
				Button tempButton = integerButtonIdMap.get(temp);
				board.actionOnEmptyCell(temp);
				tempButton.setStyle("-fx-background-color: white;");
				String numberOfBombs = board.mineCounter( temp);
				tempButton.setText(numberOfBombs);
		}
	}
	
	/**
	 *  Denne metoden utfører handlinger som kan gjøres med knappene på brettet 
	 * @param button knapp som blir trykket på
	 * @param boardPos posisjon til button
	 */
	private void buttonAction(Button button, int boardPos) {
			Button buttonClicked = button;
			if(!board.getduringGameboard().get(boardPos).isCellClicked()) {
				if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="E") {
					board.actionOnEmptyCell(boardPos);
					buttonClicked.setStyle("-fx-background-color: white;");
					String numberOfBombs = board.mineCounter( boardPos);
					buttonClicked.setText(numberOfBombs);
					if(board.noEmptyFieldsLeft()) {
						sendAlertMessage("you Won!");
						addPNGImageToButton(smileyButton,"youWonSmiley.png");
						addActionToAllButtons(key -> integerButtonIdMap.get(key)
																						   .setOnMouseClicked(null));
					}
					if(numberOfBombs.isEmpty()) {
						openCellsAround(boardPos);
					}
				}if(board.getGeneratedBeforeGameboard().get(boardPos).getFigur()=="M") {
					board.actionOnMineCell(boardPos);
					buttonClicked.setStyle("-fx-background-color: orange;");
					addPNGImageToButton(buttonClicked,"bomb.png");
					addPNGImageToButton(smileyButton,"whenLooseSmiley.png");
					sendAlertMessage("you Lost!");
					addActionToAllButtons(key -> integerButtonIdMap.get(key)
																				       .setOnMouseClicked(null));
					}
				}
			}
	
	 

	/**
	 * Endrer brettet til hvordan det så ut sist saveAndLoad.savefile() ble kjørt. 
	 * @param loadedList liste med bokstaver/tegn som hentes fra saveFile.txt
	 */
	
	private void recreateBoard(List<Character> loadedList) {
		//koden under gjør at man kan trykke på samme knappene etter å ha trykket på loadfil. 
		board.deactivateLeftClickOnAllCells();
		
		//fjerner png bilder på cellen. Tar bort minebildene
		addActionToAllButtons(key -> addPNGImageToButton(integerButtonIdMap.get(key),null));

		/*
		 * Endre smileyknappen til gladsmiley.
		 * Trengs dersom man har trykket på mine før man trykker på load igjen. 
		 */
		addPNGImageToButton(smileyButton,"duringGameSmiley.png");
	
		
		/*
		 * Iterer gjennom loadedList.
		 */
		int recountEmptyCellsLeft=0;
		for(int i=0;i<loadedList.size();i++) {
			if(loadedList.get(i)=='E') {
				board.actionOnEmptyCell(i);
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
		
		/*
		 * Denne aktiverer alle knappene igjen. 
		 * Trengs hvis man ønsker å loade etter å trykket på en mine
		 */
		addActionToAllButtons(key -> integerButtonIdMap.get(key).setOnMouseClicked(this));
	}
	
	/**
	 * Itererer gjennom alle knapper og utfører en handling. 
	 * 
	 * @param action handling som skal utføres på alle knappene
	 * 
	 */
	private void addActionToAllButtons(Consumer<? super Integer> action) {
		integerButtonIdMap.keySet()
		  .stream()
		  .forEach(action);
	}
	
	
	/**
	 * Denne metoden legger til bilde på en knapp
	 * 
	 * @param button knapp
	 * @param imagePath navn på PNG bilde
	 * 
	 */
	private void addPNGImageToButton(Button button, String imagePath) {
		if(imagePath==null) {
			button.setGraphic(null);
		}else {
			ImageView view;
			Image img = new Image(getClass().getResourceAsStream(imagePath));
			view = new ImageView(img);
			view.setFitHeight(30);
			view.setFitWidth(30);
			view.setPreserveRatio(true);
			button.setGraphic(view);
		}
		
	}
	
	/**
	 * Denne metoden sender ulike beskjeder til bruker
	 * 
	 * @param messageToUser beskjed som skal sendes 
	 */
	 private void sendAlertMessage(String messageToUser) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(messageToUser);
			alert.show();
	  }

	
	

}
