package project;

public class Cell {

	private boolean cellLeftClicked;
	private boolean cellRightClicked;
	private String figur;
	private int boardPos;

	public Cell(int boardPos) {
		setBoardPos(boardPos);
		setCellLeftClicked(false);
		setCellRightClicked(false);
		figur="";
	}
	
	private void setBoardPos(int boardPos) {
		if(boardPos<0) {
			throw new IllegalArgumentException("posisjonen kan ikke være en negative verdi");
		}
		this.boardPos = boardPos;
	}
	
	public int getBoardPos(){
		return boardPos;
	}
	
	public String getFigur() {
		return this.figur;
	}
	
	public boolean isCellLeftClicked() {
		return cellLeftClicked;
	}

	public void setCellLeftClicked(boolean cellLeftClicked) {
		this.cellLeftClicked = cellLeftClicked;
	}

	public boolean isCellRightClicked() {
		return cellRightClicked;
	}

	public void setCellRightClicked(boolean cellRightClicked) {
		this.cellRightClicked = cellRightClicked;
	}

	public void MineFigur() {
		if(isCellLeftClicked())
			figur = "M";
	}
	
	public void EmptyFigur() {
		if(isCellLeftClicked())
			figur = "E";
	}	
	
	public void SmileyFigur() {
		figur =  ":)";
	}
	
	public void FlagFigur() {
		if(isCellRightClicked())
			figur= "F";
	}
	
	
	public static void main(String[] args) {
		

	}

}
