package project;


public class ScoutNeighbourCells {

	private int[] neighbourCells;
	private GameBoardArray board;
	private int[] cellAround = {
			-1,-1,
			-1,0,
			-1,1,
			0,-1,
			0,1,
			1,-1,
			1,0,
			1,1
	};
	
	public ScoutNeighbourCells(GameBoardArray board) {
		this.board=board;
	}
	
	public int[] findNeighbourCells(int row, int col) {
		int arraySize = 0;
		//Dette gjør jeg for å finne størrelse på array jeg må initiere. 
		for (int i = 0; i < cellAround.length; i++) {
				int rowCount = cellAround[i];
				int colCount=cellAround[++i];
				if(row+rowCount<board.getGeneratedBeforeGameboard().length && row+rowCount>=0&&
						col+colCount<board.getGeneratedBeforeGameboard()[0].length && col+colCount>=0) {
					arraySize++;			
				}			
		}
		neighbourCells = new int[arraySize*2];
		
		//Finner faktiske nabocellene
		int arrayPos = 0;
		for (int i = 0; i < cellAround.length; i++) {
			int rowCount = cellAround[i];
			int colCount=cellAround[++i];
			
			if(row+rowCount<board.getGeneratedBeforeGameboard().length && row+rowCount>=0&&
					col+colCount<board.getGeneratedBeforeGameboard()[0].length && col+colCount>=0) {
				neighbourCells[arrayPos] = row+rowCount;
				arrayPos++;
				neighbourCells[arrayPos] = col+colCount;
				arrayPos++;
			}			
			
		}
		
		return neighbourCells;
	}
	
	public String countNumberOfBombsAroundCell(int row, int col) {
		int[] tempNeighbourCells = findNeighbourCells( row, col);
		int bombCounter = 0;
		for (int i = 0; i < tempNeighbourCells.length; i++) {
			int rowCount = tempNeighbourCells[i];
			int colCount=tempNeighbourCells[++i];
			if(board.getGeneratedBeforeGameboard()[rowCount][colCount].getFigur()=="M") {
				bombCounter++;
			}
		}
		if(bombCounter>0) {
			return String.valueOf(bombCounter);
		}else {
			return "";
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < neighbourCells.length; i++) {
			System.out.println(neighbourCells[i]);
		}
		return "";
	}
	
	
	
	
	public static void main(String[] args) {
		GameBoardArray board = new GameBoardArray(3, 3);
		board.fillBoardWithFigures();
		System.out.println(board);
		ScoutNeighbourCells scouter = new ScoutNeighbourCells(board);
		scouter.findNeighbourCells(1, 2);
		//scouter.countNumberOfBombsAroundCell(1, 2);	
	}

}
