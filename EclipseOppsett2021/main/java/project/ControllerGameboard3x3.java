package project;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
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
	private GameBoard board = new GameBoard(3,3);
	private SaveAndLoadGame saveAndLoad;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addSmileyPNG("duringGameSmiley.png");
		board.fillBoardWithFigures();
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
		saveButton.setOnMouseClicked(this);
		restartButton.setOnMouseClicked(this);
		
	}
			
		@Override
		public void handle(MouseEvent event) {
			
				
				
			//Legger til png for bombefigurene. 
				addBombPNG();
				for (int i = 0; i < buttonList.length; i++) {
					for (int j = 0; j < buttonList[0].length; j++) {
						if(event.getSource()==buttonList[i][j]) {
							Button buttonClicked = buttonList[i][j];
							if(board.getGeneratedBeforeGameboard()[i][j].getFigur()=="E") {
								board.decreaseNumberOfEmptyFields();
								board.leftClickOnCell(i, j);
								board.fillCellWithEmpty(i, j);
								String numberOfBombs = countNumberOfBombsAroundCell(i, j);
								buttonClicked.setStyle("-fx-background-color: white;");
								buttonClicked.setText(numberOfBombs);
								if(board.noEmptyFieldsLeft()) {
									iterateButtonListAddEventHandler(null);
									addSmileyPNG("youWonSmiley.png");
								}
							}else {
								board.leftClickOnCell(i, j);
								board.fillCellWithBomb(i, j);
								//iterateButtonListAddEventHandler(null);
								addSmileyPNG("whenLooseSmiley.png");
								buttonClicked.setStyle("-fx-background-color: orange;");
								buttonClicked.setGraphic(this.bombView); 
							}
						}
					}
				}
			}
		
		
		private void iterateButtonListAddEventHandler(EventHandler<MouseEvent> event) {
			for (int row = 0; row < buttonList.length; row++) {
				for (int col = 0; col < buttonList[0].length; col++) {
					buttonList[row][col].setOnMouseClicked(event);
				}
			}
		}
		
		private ImageView bombView;
		private void addBombPNG() {
			Image img = new Image(getClass().getResourceAsStream("bomb.png"));
		    this.bombView = new ImageView(img);
		    bombView.setFitHeight(30);
		    bombView.setFitWidth(30);
		    bombView.setPreserveRatio(true);
		}
		
		
		
		private ImageView smileyView;
		private void addSmileyPNG(String smileyPNG) {
			Image img = new Image(getClass().getResourceAsStream(smileyPNG));
		    this.smileyView = new ImageView(img);
		    smileyView.setFitHeight(30);
		    smileyView.setFitWidth(30);
		    smileyView.setPreserveRatio(true);
			smileyButton.setGraphic(smileyView);

		}
		
		 private void createValidNeighbour(Cell[][] arrayOfCells) {
			 HashMap<GameBoard, Integer[][]> layoutValuesToListValues = new HashMap<GameBoard, Integer[][]>();
			 Integer[][] tempVaules;
			 for (int row = 0; row < arrayOfCells.length; row++) {
					for (int col = 0; col < arrayOfCells[0].length; col++) {
						if(row-1>=0 && col-1>=0) {
							
						}if(col-1>=0) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && col-1>=0) {
							
						}if(row-1>=0) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1) {
							
						}if(row-1>=0 && col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}if(col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1&&col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}
					}
			}
			 
			 
			 
			 
		 }
		
		private String countNumberOfBombsAroundCell(int row, int col) {
			int tempCounter = 0;
			if(row-1>=0 && col-1>=0 && board.getGeneratedBeforeGameboard()[row-1][col-1].getFigur()=="M") {
				tempCounter++;
			}if(col-1>=0 && board.getGeneratedBeforeGameboard()[row][col-1].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && col-1>=0 && board.getGeneratedBeforeGameboard()[row+1][col-1].getFigur()=="M") {
				tempCounter++;
			}if(row-1>=0 &&board.getGeneratedBeforeGameboard()[row-1][col].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && board.getGeneratedBeforeGameboard()[row+1][col].getFigur()=="M") {
				tempCounter++;
			}if(row-1>=0 && col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row-1][col+1].getFigur()=="M") {
				tempCounter++;
			}if(col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row][col+1].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1&&col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row+1][col+1].getFigur()=="M") {
				tempCounter++;
			}
			
			return String.valueOf(tempCounter);
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
