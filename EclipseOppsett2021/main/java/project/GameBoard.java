package project;

import java.util.Random;

public class GameBoard {

	
	private String[][] duringGameBoard;
	private String[][] generatedBeforeBoard;
	private Figur figur=new Figur();

	
	//Standard størrelse er 9x9
	public GameBoard() {
		this(9,9);
	}
	
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
		this.duringGameBoard = new String[row][col];
		this.generatedBeforeBoard = new String[row][col];
	}
	
	public String[][] getDuringGameBoard() {
		return this.duringGameBoard;
	}
	
	public String[][] getGeneratedBeforeBoard() {
		return this.generatedBeforeBoard;
	}
	
	
	public void fillBoardWithFigures() {
		int totNumberOfCells = getGeneratedBeforeBoard().length*getGeneratedBeforeBoard()[0].length;
		/*
		 * Tenker at antall miner kan være kvadratrota av antall celler. Tilfeldig antall. Kanskje det blir for mange/få?
		 */
		int numberOfMines = (int)Math.sqrt(totNumberOfCells);
		int numberOfEmpty = totNumberOfCells-numberOfMines;
		Random random = new Random();
		while(numberOfMines>0) {
			int randomRow = random.nextInt(getGeneratedBeforeBoard().length);
			int randomCol = random.nextInt(getGeneratedBeforeBoard()[0].length);
			if(getGeneratedBeforeBoard()[randomRow][randomCol]==null) {
				getGeneratedBeforeBoard()[randomRow][randomCol]=figur.MineFigur();
				getDuringGameBoard()[randomRow][randomCol]=figur.MineFigur();
				numberOfMines--;
			}
		}
		

		while(numberOfEmpty>0) {
			int randomRow = random.nextInt(getGeneratedBeforeBoard().length);
			int randomCol = random.nextInt(getGeneratedBeforeBoard()[0].length);
			
			if(getGeneratedBeforeBoard()[randomRow][randomCol]==null) {
				getGeneratedBeforeBoard()[randomRow][randomCol]=figur.EmptyFigur();
				getDuringGameBoard()[randomRow][randomCol]=figur.EmptyFigur();
				numberOfEmpty--;
			}
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < getGeneratedBeforeBoard().length; i++) {
			for (int j = 0; j < getGeneratedBeforeBoard()[0].length; j++) {
				System.out.println(getGeneratedBeforeBoard()[i][j]);
			}
			System.out.println("\n");
		}
		return "finished";
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
		return size>3;
	}
	
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		board.fillBoardWithFigures();
		System.out.println(board);
	
	}
		
	

}
