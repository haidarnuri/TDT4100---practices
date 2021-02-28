package project;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerGameboard3x3 implements Initializable, EventHandler<MouseEvent>{

	
	@FXML private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,smileyButton,saveButton,restartButton;
	@FXML private Label nameLabel;
	private Button[][] buttonList = new Button[3][3];
	private GameBoard board;
	private ScoutNeighbourCells scouter;
	private addPNGImages addingImage = new addPNGImages();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		smileyButton.setGraphic(addingImage.addSmileyPNG("duringGameSmiley.png"));
		board = new GameBoard(3,3);
		scouter = new ScoutNeighbourCells(board);
		buttonList[0][0] = btn1;
		buttonList[0][1] = btn2;
		buttonList[0][2] = btn3;
		buttonList[1][0] = btn4;
		buttonList[1][1] = btn5;
		buttonList[1][2] = btn6;
		buttonList[2][0] = btn7;
		buttonList[2][1] = btn8;
		buttonList[2][2] = btn9;
		iterateButtonListAddEventHandler(this);
		
	}
			
		@Override
		public void handle(MouseEvent event) {
			//Legger til png for bombefigurene. 
				for (int i = 0; i < buttonList.length; i++) {
					for (int j = 0; j < buttonList[0].length; j++) {
						if(event.getSource()==buttonList[i][j]) {
							buttonAction(buttonList[i][j], i, j);
						}
					}
				}
			}
		
		
		private void buttonAction(Button button, int row, int col) {
			Button buttonClicked = button;
			if(board.getGeneratedBeforeGameboard()[row][col].getFigur()=="E") {
				board.decreaseNumberOfEmptyFields();
				board.leftClickOnCell(row, col);
				board.fillCellWithEmpty(row, col);
				String numberOfBombs = scouter.countNumberOfBombsAroundCell(row, col);
				buttonClicked.setStyle("-fx-background-color: white;");
				buttonClicked.setText(numberOfBombs);
				if(numberOfBombs.isEmpty()) {
					int[] neighbourCells = scouter.findNeighbourCells(row, col);
					for (int i = 0; i < neighbourCells.length; i++) {
						int rowValue = neighbourCells[i];
						int colValue = neighbourCells[++i];
						buttonList[rowValue][colValue].setStyle("-fx-background-color: white;");
					}
				}
				if(board.noEmptyFieldsLeft()) {
					//iterateButtonListAddEventHandler(null);
					smileyButton.setGraphic(addingImage.addSmileyPNG("youWonSmiley.png"));
				}
			}else {
				board.leftClickOnCell(row, col);
				board.fillCellWithBomb(row, col);
				//iterateButtonListAddEventHandler(null);
				smileyButton.setGraphic(addingImage.addSmileyPNG("whenLooseSmiley.png"));
				buttonClicked.setStyle("-fx-background-color: orange;");
				buttonClicked.setGraphic(addingImage.addBombPNG("bomb.png")); 
			}
		}
		
		private void iterateButtonListAddEventHandler(EventHandler<MouseEvent> event) {
			for (int row = 0; row < buttonList.length; row++) {
				for (int col = 0; col < buttonList[0].length; col++) {
					buttonList[row][col].setOnMouseClicked(event);
				}
			}
		}
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
}
