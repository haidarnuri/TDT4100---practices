package project;

public class Cell {

	private boolean cellLeftClicked;
	private boolean cellRightClicked;

	public Cell() {
		setCellLeftClicked(false);
		setCellRightClicked(false);
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

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
