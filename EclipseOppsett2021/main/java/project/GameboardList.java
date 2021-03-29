package project;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;

/**
 * Denne klassen styrer største delen av logikken som skjer i spillet. 
 * 
 * @author haidarn
 */
public class GameboardList {
	/**
	 * Public metoder øverst og private metoder nederst. 
	 */
	
	//generateBeforeGameboard = Et brett som blir ferdigutfylt før man spiller.
	private List<Cell> generateBeforeGameboard = new ArrayList<>();
	
	//duringGameboard = Dette brettet fylles ut samtidig med knappene på brettet. 
	private List<Cell> duringGameboard = new ArrayList<>();
	
	private int numberOfEmptyFieldsOnBoard=0;
	private int numberOfMines=0;

	/**
	 * Konstruktør i denne klassen. 
	 * @param boardSize antall celler i spillet. 
	 */
	public GameboardList(int boardSize) {
		createBoard( boardSize);
	}
	
	/**
	 * Denne metoden fyller ge
	 * @param boardSize
	 */
	public void fillBoardWithFigures(int boardSize) {
		setNumberOfMines(boardSize);
		setNumberOfEmpty(boardSize);
		Random random = new Random();
		/*
		 * Fyller random celler med miner.
		 */
		int counterMines=getNumberOfMines();
		while(counterMines>0) {
			int randomBoardPos = random.nextInt(getGeneratedBeforeGameboard().size()-1);
			if(getGeneratedBeforeGameboard().get(randomBoardPos).getFigur().isEmpty()) {
				getGeneratedBeforeGameboard().get(randomBoardPos).mineFigur();
				counterMines--;
			}
		}
		/*
		 * Fyller resterende celler med tomrom. Altså ikke-miner
		 */
		getGeneratedBeforeGameboard().stream()
									 .filter(cell->cell.getFigur().isEmpty())
									 .forEach(cell->cell.emptyFigur());
	}
	
	/**
	 * 
	 * @param boardsize Antall celler på brettet. 
	 */
	private void setNumberOfMines(int boardsize) {
		numberOfMines=(int)Math.sqrt(boardsize);
	}
	
	/**
	 * 
	 * @return antall miner
	 */
	public int getNumberOfMines() {
		return numberOfMines;
	}
	
	/**
	 * 
	 * @param value vilkåerlig antall celler.
	 */
	
	public void setNumberOfEmpty(int value) {
		numberOfEmptyFieldsOnBoard=value-getNumberOfMines();
	}
	
	/**
	 * 
	 * @return antall tomme celler. Altså celler som ikke innholder miner. 
	 */
	public int getNumberOfEmpty() {
		return numberOfEmptyFieldsOnBoard;
	}
	
	/**
	 * Reduserer antall tomme celler med en. 
	 */
	public void decreaseNumberOfEmptyFields() {
		this.numberOfEmptyFieldsOnBoard--;
	}
	
	/**
	 * 
	 * @return sjekker om det er noen tomme celler igjen. Hvis true så har spilleren vunnet. 
	 */
	public boolean noEmptyFieldsLeft() {
		return numberOfEmptyFieldsOnBoard == 0;
	}
	 
	/**
	 * 
	 * @return returnerer liste som er lik duringGameboard
	 */
	public List<Cell> getduringGameboard() {
		return new ArrayList<>(duringGameboard);
	}
	
	/**
	 * 
	 * @return returnerer liste som er lik generateBeforeGameboard
	 */
	public List<Cell> getGeneratedBeforeGameboard() {
		return new ArrayList<>(generateBeforeGameboard);
	}
	
	/**
	 * Aktiverer at en celle blir trykket på. 
	 * @param boardPos posisjon på spillbrettet
	 */
	public void leftClickOnCell(int boardPos) {
		getduringGameboard().get(boardPos).setCellLeftClicked(true);
	}
	
	/**
	 * Legger til minefigur til en spesifikk posisjon på brettet. 
	 * @param boardPos posisjon på spillbrettet
	 */
	public void fillCellWithMine(int boardPos) {
		getduringGameboard().get(boardPos).mineFigur();
	}
	
	
	/**
	 * Legger til tomfigur til en spesifikk posisjon på brettet. 
	 * @param boardPos posisjon på spillbrettet
	 */
	public void fillCellWithEmpty(int boardPos) {
		getduringGameboard().get(boardPos).emptyFigur();
	}
		
	/**
	 * 
	 * @param boardPos spesifikk posisjon på brettet.
	 * @return antall miner rundt en spesfikk cell. 
	 */
	public String mineCounter(int boardPos) {
		int size = (int)Math.sqrt(getGeneratedBeforeGameboard().size());
		int numberOfMines = 0;
		/*
		 * Prøver å finne spesfikk posisjon i getGeneratedBeforeGameboard-lista
		 * Først ved å finne hvilken kolonne og deretter hvilken rad. 
		 */
		int colPos = boardPos%size;
		int rowPos = (int)(boardPos/size);
		/*
		 * Først if setningen skjer dersom man er i første rad på brettet. 
		 */
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
			/*
			 * Andre if setningen skjer dersom man er i siste rad på brettet. 
			 */
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
			/*
			 * else setningen skjer dersom man er i alle radene mellom første og siste rad på brettet. 
			 */
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
	
	/**
	 * En rekke med metoder som er mye brukt, som blir samlet under et objekt. 
	 * @param boardPos spesifikk posisjon på brettet. 
	 */
	public void actionOnEmptyCell(int boardPos) {
		leftClickOnCell(boardPos);
		decreaseNumberOfEmptyFields();
		fillCellWithEmpty(boardPos);
	}
	
	/**
	 * En rekke med metoder som er mye brukt, som blir samlet under et objekt. 
	 * @param boardPos spesifikk posisjon på brettet. 
	 */
	public void actionOnMineCell(int boardPos) {
		leftClickOnCell(boardPos);
		fillCellWithMine(boardPos);
	}
	
	
	/*
	 * koden under gjør at man kan trykke på samme knappene etter å ha trykket på loadknappen på brettet.  
	 */
	public void deactivateLeftClickOnAllCells() {
		getduringGameboard().stream()
						    .forEach(cell -> cell.setCellLeftClicked(false));
	}
	
	/**
	 * Finner alle celler rundt en spesifikk posisjon. Bruker neste samme logikk som i mineCounter().
	 * @param boardPos spesifikk posisjon på brettet. 
	 * @return en liste med celler rundt en spesifikk posisjon på brettet.
	 */
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
	
	/*
	 * Under her kommer private metoder og hjelpemetoder. 
	 */
	
	
	/**
	 * Legger inn figurer i generateBeforeGameboard-lista og initierer duringGameboard-lista. 
	 * @param boardSize Antall celler på brettet. 
	 */
	private void createBoard(int boardSize) {
		if(!checkValidSize(boardSize)) {
			throw new IllegalArgumentException("Brettet må har enten 9, 36 eller 81 knapper");
		}
		int tempSize = boardSize;
		while(tempSize>0) {
			Cell tempCell = new Cell(boardSize-tempSize);
			tempCell.setCellLeftClicked(true);
			generateBeforeGameboard.add(tempCell);
			tempSize--;
		}	
		fillBoardWithFigures( boardSize);
		
		//Her initieres alle plassene i duringGameboard
		tempSize = boardSize;
		while(tempSize>0) {
			Cell tempCell = new Cell(boardSize-tempSize);
			duringGameboard.add(tempCell);
			tempSize--;
		}	
		
	}
	
	/**
	 * 
	 * @param numberOfButtons antall celler
	 * @return sjekker om brettet har riktig størrelse. 
	 */
	private boolean checkValidSize(int numberOfButtons) {
		return numberOfButtons==9 || numberOfButtons==36 || numberOfButtons==81;
	}
	
}
