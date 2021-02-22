package project;

import java.util.Random;

public class GameBoard {
	
	private Cell[][] generatedBeforeGameboard;
	private Cell[][] duringGameboard;


	public GameBoard(int row, int col) {
		setBoard(row,col);
	}
	
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
				getGeneratedBeforeGameboard()[i][j] = new Cell(); 
				getGeneratedBeforeGameboard()[i][j].setCellLeftClicked(true);
				getGeneratedBeforeGameboard()[i][j].setCellRightClicked(true);
			}
		}
		
	}
	
	public Cell[][] getDuringGameboard() {
		return this.generatedBeforeGameboard;
	}
	
	
	public Cell[][] getGeneratedBeforeGameboard() {
		return this.generatedBeforeGameboard;
	}
	
	public void leftClickOnCell(int row, int col) {
		getDuringGameboard()[row][col].setCellLeftClicked(true);
	}
	
	public void rightClickOnCell(int row, int col) {
		getDuringGameboard()[row][col].setCellRightClicked(true);
	}
	
	public void fillCellWithMine(int row, int col) {
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
		/*
		 * Tenker at antall miner kan være kvadratrota av antall celler. Tilfeldig antall. Kanskje det blir for mange/få?
		 */
		int numberOfMines = (int)Math.sqrt(totNumberOfCells);
		int numberOfEmpty = totNumberOfCells-numberOfMines;
		Random random = new Random();
		while(numberOfMines>0) {
			int randomRow = random.nextInt(getGeneratedBeforeGameboard().length);
			int randomCol = random.nextInt(getGeneratedBeforeGameboard()[0].length);
			if(getGeneratedBeforeGameboard()[randomRow][randomCol].getFigur()==null) {
				getGeneratedBeforeGameboard()[randomRow][randomCol].MineFigur();
				numberOfMines--;
			}
		}
		while(numberOfEmpty>0) {
			int randomRow = random.nextInt(getGeneratedBeforeGameboard().length);
			int randomCol = random.nextInt(getGeneratedBeforeGameboard()[0].length);		
			if(getGeneratedBeforeGameboard()[randomRow][randomCol].getFigur()==null) {
				getGeneratedBeforeGameboard()[randomRow][randomCol].EmptyFigur();
				numberOfEmpty--;
			}
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < generatedBeforeGameboard.length; i++) {
			for (int j = 0; j < generatedBeforeGameboard[0].length; j++) {
				System.out.println(getGeneratedBeforeGameboard()[i][j].getFigur());			
			}
		}
		return "";
	}
	
	/*
	 * Må lage en array der jeg tilfeldig setter inn ulike figurer. 
	 * Antall figurer er samme som arealet av spillbrettet. 
	 * Antall miner er kvadratrot av antall celler
	 * Minene skal plasseres random i arrayen
	 * Resten er tomme celler. 
	 */
	
	//Burde man ha minst 3x3?
	private boolean checkValidSize(int size) {
		return size>2;
	}
	
	public static void main(String[] args) {
		GameBoard board = new GameBoard(3,3);
		board.fillBoardWithFigures();
		System.out.println(board);
	
	}
		
	

}
