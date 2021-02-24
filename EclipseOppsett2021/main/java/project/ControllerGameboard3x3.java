package project;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerGameboard3x3 implements Initializable, EventHandler<MouseEvent>{

	
	@FXML Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	Button[][] buttonList = new Button[3][3];
	//HashMap<Button, Coordinates> layoutValuesToListValues = new HashMap<Button, Coordinates>();
	GameBoard board = new GameBoard(3,3);
	Cell comparisonCell = new Cell();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		board.fillBoardWithFigures();
		/*
		layoutValuesToListValues.put(btn1, new Coordinates(0,0,btn1.getLayoutX(),btn1.getLayoutY()));
		layoutValuesToListValues.put(btn2, new Coordinates(0,1,btn2.getLayoutX(),btn2.getLayoutY()));
		layoutValuesToListValues.put(btn3, new Coordinates(0,2,btn3.getLayoutX(),btn3.getLayoutY()));
		layoutValuesToListValues.put(btn4, new Coordinates(1,0,btn4.getLayoutX(),btn4.getLayoutY()));
		layoutValuesToListValues.put(btn5,new Coordinates(1,1,btn5.getLayoutX(),btn5.getLayoutY()));
		layoutValuesToListValues.put(btn6,new Coordinates(1,2,btn6.getLayoutX(),btn6.getLayoutY()));
		layoutValuesToListValues.put(btn7,new Coordinates(2,0,btn7.getLayoutX(),btn7.getLayoutY()));
		layoutValuesToListValues.put(btn8,new Coordinates(2,1,btn8.getLayoutX(),btn8.getLayoutY()));
		layoutValuesToListValues.put(btn9,new Coordinates(2,2,btn9.getLayoutX(),btn9.getLayoutY()));
		*/
		
		buttonList[0][0] = btn1;
		buttonList[0][1] = btn2;
		buttonList[0][2] = btn3;
		buttonList[1][0] = btn4;
		buttonList[1][1] = btn5;
		buttonList[1][2] = btn6;
		buttonList[2][0] = btn7;
		buttonList[2][1] = btn8;
		buttonList[2][2] = btn9;
		for (int i = 0; i < buttonList.length; i++) {
			for (int j = 0; j < buttonList[0].length; j++) {
				buttonList[i][j].setOnMouseClicked(this);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		HashMap<Integer[], Double[]> layoutValuesToListValues = new HashMap<Integer[], Double[]>();
		Integer[] temp = {1};
		Double[] temDouble = {1.1};
		layoutValuesToListValues.put(temp,temDouble);
		for(Double temper:layoutValuesToListValues.get(temp)) {
			
				System.out.println(temper);
			
		}
	}

		
		@Override
		public void handle(MouseEvent event) {
						
			//Legger til png for bombefigurene. 
			addBombPNG();
	       		    
			for (int i = 0; i < buttonList.length; i++) {
				for (int j = 0; j < buttonList[0].length; j++) {
					if(event.getSource()==buttonList[i][j]) {
						Button buttonClicked = buttonList[i][j];
						if(board.getDuringGameboard()[i][j].getFigur()=="E") {
							String numberOfBombs = countNumberOfBombsAroundCell(i, j);
							buttonClicked.setStyle("-fx-background-color: white;");
							buttonClicked.setText(numberOfBombs);
						}else {
							buttonClicked.setStyle("-fx-background-color: orange;");
							buttonClicked.setGraphic(this.view); 
						}
					}
				}
			}
		}
		
		
		private ImageView view;
		private void addBombPNG() {
			Image img = new Image(getClass().getResourceAsStream("bomb.png"));
		    this.view = new ImageView(img);
		    view.setFitHeight(30);
		    view.setFitWidth(30);
		    view.setPreserveRatio(true);
		}
		
		private boolean isBombAroundCell;
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
			if(tempCounter>0) {
				this.isBombAroundCell = true;
				return String.valueOf(tempCounter);
			}else{
				this.isBombAroundCell=false;
				return "";
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
