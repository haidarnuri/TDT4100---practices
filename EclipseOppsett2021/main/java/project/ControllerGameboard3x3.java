package project;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControllerGameboard3x3 implements Initializable{

	
	@FXML Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	Button[][] buttonList = new Button[3][3];
	HashMap<Integer[], Double[]> layoutValuesToListValues = new HashMap<Integer[], Double[]>();
	GameBoard board = new GameBoard(3,3);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		board.fillBoardWithFigures();
		layoutValuesToListValues.put({0,0},{0.0,0.0});
		buttonList[0][0] = btn1;
		buttonList[0][1] = btn2;
		buttonList[0][2] = btn3;
		buttonList[1][0] = btn4;
		buttonList[1][1] = btn5;
		buttonList[1][2] = btn6;
		buttonList[2][0] = btn7;
		buttonList[2][1] = btn8;
		buttonList[2][2] = btn9;
		
	}
	
	public void buttonTest() {
		for (int i = 0; i < buttonList.length; i++) {
			for (int j = 0; j < buttonList[0].length; j++) {
				System.out.println("Xpos = "+buttonList[i][j].getLayoutX() + " ypos = " + buttonList[i][j].getLayoutY()+ " tabellpos " + i + " " + j);
				
				buttonList[i][j].setText(board.getGeneratedBeforeGameboard()[i][j].getFigur());
			}
		}
		
	}
	
	public static void main(String[] args) {
		HashMap<Integer[], Double[]> layoutValuesToListValues = new HashMap<Integer[], Double[]>();
		Integer[] temp = {1};
		Double[] temDouble = {1.1};
		layoutValuesToListValues.put(temp,temDouble);
		System.out.println("Nøkkelen er" + layoutValuesToListValues.keySet() + " og verdiene er " + layoutValuesToListValues.get(1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
