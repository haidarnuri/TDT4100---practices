package project;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class GameboardList {
	
	
	private List<Cell> generateBeforeGameboard = new ArrayList<>();
	private List<Cell> duringGameboard = new ArrayList<>();
	private int numberOfEmptyFieldsOnBoard;

	
	public GameboardList(int boardSize) {
		createBoard( boardSize);
	}
	
	private void createBoard(int boardSize) {
		if(!checkValidSize(boardSize)) {
			throw new IllegalArgumentException("Brettet må har enten 9, 36 eller 81 knapper");
		}
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
	
	public void setNumberOfEmptyFields(int number) {
		numberOfEmptyFieldsOnBoard=number;
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
		return new ArrayList<>(duringGameboard);
	}
	
	public List<Cell> getGeneratedBeforeGameboard() {
		return new ArrayList<>(generateBeforeGameboard);
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
	 * 6x6 brett tilsvarer 36 knapper.
	 * 9x9 brett tilsvarer 81 knapper.
	 */
	private boolean checkValidSize(int numberOfButtons) {
		return numberOfButtons==9 || numberOfButtons==36 || numberOfButtons==81;
	}
	
	public String mineCounter(int boardPos) {
		int size = (int)Math.sqrt(getGeneratedBeforeGameboard().size());
		int numberOfMines = 0;
		int colPos = boardPos%size;
		int rowPos = (int)(boardPos/size);
		if(rowPos==0) {
			if(getGeneratedBeforeGameboard().get(boardPos+size).getFigur() =="M") {
				numberOfMines++;
			}
			if(colPos!=0) {
				if(getGeneratedBeforeGameboard().get(boardPos+size-1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					numberOfMines++;
				}
			}
			if(colPos!=size-1) {
				if(getGeneratedBeforeGameboard().get(boardPos+size+1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					numberOfMines++;
				}
			}	
		}else if(rowPos==size-1) {

			if(getGeneratedBeforeGameboard().get(boardPos-size).getFigur() =="M") {
				numberOfMines++;
			}
			if(colPos!=0) {
				if(getGeneratedBeforeGameboard().get(boardPos-size-1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					numberOfMines++;
				}
			}
			if(colPos!=size-1) {
				if(getGeneratedBeforeGameboard().get(boardPos-size+1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					numberOfMines++;
				}
			}	
		}else {

			if(getGeneratedBeforeGameboard().get(boardPos-size).getFigur() =="M") {
				numberOfMines++;
			}
			if(getGeneratedBeforeGameboard().get(boardPos+size).getFigur() =="M") {
				numberOfMines++;
			}
			if(colPos!=0) {
				if(getGeneratedBeforeGameboard().get(boardPos-size-1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos-1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos+size-1).getFigur() =="M") {
					numberOfMines++;
				}
			}
			if(colPos!=size-1) {
				if(getGeneratedBeforeGameboard().get(boardPos-size+1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos+size+1).getFigur() =="M") {
					numberOfMines++;
				}
				if(getGeneratedBeforeGameboard().get(boardPos+1).getFigur() =="M") {
					numberOfMines++;
				}
			}	
		}
		if(numberOfMines == 0) {
			return "";
		}else {
			return String.valueOf( numberOfMines);
		}
		
	}
	
	public List<Integer> scoutsCellsAround(int boardPos){
		List<Integer> posCellAround = new ArrayList<>();
		int size = (int)Math.sqrt(getGeneratedBeforeGameboard().size());
		int colPos = boardPos%size;
		int rowPos = (int)(boardPos/size);
		if(rowPos==0) {
			posCellAround.add(boardPos+size);
			if(colPos!=0) {
				posCellAround.add(boardPos+size-1);
				posCellAround.add(boardPos-1);
			}
			if(colPos!=size-1) {
				posCellAround.add(boardPos+size+1);
				posCellAround.add(boardPos+1);
			}	
		}
		else if(rowPos==size-1) {
			posCellAround.add(boardPos-size);
			if(colPos!=0) {
				posCellAround.add(boardPos-size-1);
				posCellAround.add(boardPos-1);
			}
			if(colPos!=size-1) {
				posCellAround.add(boardPos-size+1);
				posCellAround.add(boardPos+1);
			}	
		}else {
			posCellAround.add(boardPos-size);
			posCellAround.add(boardPos+size);
			if(colPos!=0) {
				posCellAround.add(boardPos-size-1);
				posCellAround.add(boardPos-1);
				posCellAround.add(boardPos+size-1);
			}
			if(colPos!=size-1) {
				posCellAround.add(boardPos-size+1);
				posCellAround.add(boardPos+size+1);
				posCellAround.add(boardPos+1);
			}	
		}
		return posCellAround;
	}
	
	
	
	
	
	public static void main(String[] args) {
		GameboardList game = new GameboardList(9);
		
	}

}
