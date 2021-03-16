package project;

import java.util.Iterator;
import java.util.Random;

public class GameBoardArray {
	
	private Cell[][] generatedBeforeGameboard;
	private Cell[][] duringGameboard;
	private int numberOfEmptyFieldsOnBoard;


	public GameBoardArray(int row, int col) {
		setBoard(row,col);
	}
	
	
	/**
	 * Her har vi en metode som lar oss hente et objekt med en vits.
	 * 
	 * @param jokeIndex Et tall fra og med 0 og til <code>getJokesCount()</code>
	 * @return Hvis identifikatoren finnes s� returneres et vitse-objekt, hvis ikke returneres <code>null</code>
	 */
	
	private void setBoard(int row, int col) {
		if(!checkValidSize(col)) {
			throw new IllegalArgumentException("Kolonnen må være større enn 3");
		}
		if(!checkValidSize(row)) {
			throw new IllegalArgumentException("Raden må være større enn  3");
		}
		duringGameboard = new Cell[row][col];
		generatedBeforeGameboard= new Cell[row][col];	
		
		for (int i = 0; i < generatedBeforeGameboard.length; i++) {
			for (int j = 0; j < generatedBeforeGameboard[0].length; j++) {
				getDuringGameboard()[i][j] = new Cell();
				getGeneratedBeforeGameboard()[i][j] = new Cell(); 
				getGeneratedBeforeGameboard()[i][j].setCellLeftClicked(true);
				getGeneratedBeforeGameboard()[i][j].setCellRightClicked(true);
			}
		}
		fillBoardWithFigures();
	}
	
	public Cell[][] getDuringGameboard() {
		return this.duringGameboard;
	}
	
	
	public Cell[][] getGeneratedBeforeGameboard() {
		return this.generatedBeforeGameboard;
	}
	
	public void decreaseNumberOfEmptyFields() {
		this.numberOfEmptyFieldsOnBoard--;
	}
	
	public boolean noEmptyFieldsLeft() {
		return numberOfEmptyFieldsOnBoard == 0;
	}
	
	public void leftClickOnCell(int row, int col) {
		getDuringGameboard()[row][col].setCellLeftClicked(true);
	}
	
	public void rightClickOnCell(int row, int col) {
		getDuringGameboard()[row][col].setCellRightClicked(true);
	}
	
	public void fillCellWithBomb(int row, int col) {
		getDuringGameboard()[row][col].MineFigur();
	}
	
	public void fillCellWithEmpty(int row, int col) {
		getDuringGameboard()[row][col].EmptyFigur();
	}
	
	public void fillCellWithFlag(int row, int col) {
		getDuringGameboard()[row][col].FlagFigur();
	}
	
	public void fillBoardWithFigures() {
		int totNumberOfCells = getGeneratedBeforeGameboard().length*getGeneratedBeforeGameboard()[0].length;
		//int numberOfBombs=1;
		int numberOfBombs = (int)Math.sqrt(totNumberOfCells);
		this.numberOfEmptyFieldsOnBoard = numberOfBombs;
		int tempNumberOfEmpty = totNumberOfCells-numberOfBombs;
		numberOfEmptyFieldsOnBoard = tempNumberOfEmpty;
		Random random = new Random();
		while(numberOfBombs>0) {
			int randomRow = random.nextInt(getGeneratedBeforeGameboard().length);
			int randomCol = random.nextInt(getGeneratedBeforeGameboard()[0].length);
			if(getGeneratedBeforeGameboard()[randomRow][randomCol].getFigur().isEmpty()) {
				getGeneratedBeforeGameboard()[randomRow][randomCol].MineFigur();
				numberOfBombs--;
			}
		}
		while(tempNumberOfEmpty>0) {
			int randomRow = random.nextInt(getGeneratedBeforeGameboard().length);
			int randomCol = random.nextInt(getGeneratedBeforeGameboard()[0].length);		
			if(getGeneratedBeforeGameboard()[randomRow][randomCol].getFigur().isEmpty()) {
				getGeneratedBeforeGameboard()[randomRow][randomCol].EmptyFigur();
				tempNumberOfEmpty--;
			}
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < getGeneratedBeforeGameboard().length; i++) {
			for (int j = 0; j < getGeneratedBeforeGameboard()[0].length; j++) {
				
				System.out.println(getGeneratedBeforeGameboard()[i][j].getFigur());			
			}
		}
		return "";
	}
	
	
	//Burde man ha minst 3x3?
	private boolean checkValidSize(int size) {
		return size>2;
	}
	
	public static void main(String[] args) {
		GameBoardArray board = new GameBoardArray(3, 3);
		System.out.println(board.toString());
	}
		
	

}
