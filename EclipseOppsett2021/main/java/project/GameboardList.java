package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import javafx.scene.control.Button;

public class GameboardList {
	
	
	private List<Cell> generateBeforeGameboard = new ArrayList<>();
	private List<Cell> duringGameboard = new ArrayList<>();
	private int numberOfEmptyFieldsOnBoard;

	
	public GameboardList(int boardSize) {
		createBoard( boardSize);
	}
	
	private void createBoard(int boardSize) {
		if(!checkValidSize(boardSize)) {
			throw new IllegalArgumentException("Brettet må bestå av minst 9 knapper");
		}
		
		//Her initieres alle plassene i beforeGameboard
		int tempSize = boardSize;
		while(tempSize>=0) {
			Cell tempCell = new Cell(boardSize-tempSize);
			tempCell.setCellLeftClicked(true);
			generateBeforeGameboard.add(tempCell);
			tempSize--;
		}	
		fillBoardWithFigures( boardSize);
		
		//Her initieres alle plassene i duringGameboard
		tempSize = boardSize;
		while(tempSize>=0) {
			Cell tempCell = new Cell(boardSize-tempSize);
			duringGameboard.add(tempCell);
			tempSize--;
		}	
		showBoardFigurs();
	}
	
	
	public void fillBoardWithFigures(int boardSize) {
		int numberOfBombs = (int)Math.sqrt(boardSize);
		int numberOfEmpty = boardSize-numberOfBombs;
		numberOfEmptyFieldsOnBoard= numberOfEmpty;
		Random random = new Random();
		while(numberOfBombs>0) {
			int randomBoardPos = random.nextInt(getGeneratedBeforeGameboard().size()-1);
			if(getGeneratedBeforeGameboard().get(randomBoardPos).getFigur().isEmpty()) {
				getGeneratedBeforeGameboard().get(randomBoardPos).MineFigur();
				numberOfBombs--;
			}
		}
		while(numberOfEmpty>0) {
			int randomBoardPos = random.nextInt(getGeneratedBeforeGameboard().size()-1);
			if(getGeneratedBeforeGameboard().get(randomBoardPos).getFigur().isEmpty()) {
				getGeneratedBeforeGameboard().get(randomBoardPos).EmptyFigur();
				numberOfEmpty--;
			}
		}
	}
	 
	public void decreaseNumberOfEmptyFields() {
		this.numberOfEmptyFieldsOnBoard--;
	}
		
	public boolean noEmptyFieldsLeft() {
		return numberOfEmptyFieldsOnBoard == 0;
	}
	 
	/*
	 * bryter dette med inkapslingsprinsippet??
	 * Burde skrive new List<Cell> ...... 
	 * Ifølge øvingsforelesning 9
	 */
	public List<Cell> getduringGameboard() {
		return this.duringGameboard;
	}
	
	public List<Cell> getGeneratedBeforeGameboard() {
		return this.generateBeforeGameboard;
	}
	

	public void leftClickOnCell(int boardPos) {
		getduringGameboard().get(boardPos).setCellLeftClicked(true);
	}
	
	public void fillCellWithBomb(int boardPos) {
		getduringGameboard().get(boardPos).MineFigur();
	}
	
	public void fillCellWithEmpty(int boardPos) {
		getduringGameboard().get(boardPos).EmptyFigur();
	}
	
	private void showBoardFigurs() {
		generateBeforeGameboard.stream().forEach(cell ->System.out.println(cell.getFigur()));
	}
	
	
	/*
	 * 3x3 brett tilsvarer 9 knapper. 
	 */
	private boolean checkValidSize(int value) {
		return value>=9;
	}
	
	
	
	public static void main(String[] args) {
		GameboardList game = new GameboardList(9);
		
	}

}
