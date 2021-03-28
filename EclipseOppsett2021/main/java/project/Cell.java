package project;

public class Cell {

	private boolean cellLeftClicked;
	private String figur;

	public Cell(int boardPos) {
		setCellLeftClicked(false);
		figur="";
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
	
	public void clearCell() {
			figur = "";
	}
	
	public void mineFigur() {
		if(isCellLeftClicked())
			figur = "M";
	}
	
	public void emptyFigur() {
		if(isCellLeftClicked())
			figur = "E";
	}	

}
