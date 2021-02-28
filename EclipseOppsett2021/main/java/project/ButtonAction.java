package project;

import javafx.scene.control.Button;

public class ButtonAction {
	
	
	private void buttonAction(Button smileyButton, Button[][] buttonList,ScoutNeighbourCells scouter, GameBoard board, Button button, int row, int col) {
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
