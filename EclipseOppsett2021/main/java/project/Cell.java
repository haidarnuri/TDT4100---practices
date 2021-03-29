package project;
/**
 * Denne klasse for hver enkelt celle på brettet. 
 * 
 * @author haidarn
 *
 */

public class Cell {

	private boolean cellLeftClicked;
	private String figur;

	/**
	 * Konstruktør. 
	 * Her settes leftClick til false. 
	 * Settes inn tom figur i første omgang
	 */
	public Cell() {
		setCellClicked(false);
		figur="";
	}
	/**
	 * 
	 * @return figuren på cellen
	 */
	public String getFigur() {
		return this.figur;
	}
	/**
	 * 
	 * @return om cellen er trykket på eller ikke 
	 */
	public boolean isCellClicked() {
		return cellLeftClicked;
	}

	/**
	 * @param cellLeftClicked true når cellen trykkes på. False ellers. 
	 */
	public void setCellClicked(boolean cellLeftClicked) {
		this.cellLeftClicked = cellLeftClicked;
	}
	
	/**
	 * Fjerner symbolet i cellen. Altså setter figuren lik tom figur. 
	 */
	public void clearCell() {
			figur = "";
	}
	
	/**
	 * Setter figur lik M(for mine) dersom den er klikka på. 
	 */
	public void mineFigur() {
		if(isCellClicked())
			figur = "M";
	}
	
	/**
	 * Setter figur lik E(for empty) dersom den er klikka på. 
	 */
	public void emptyFigur() {
		if(isCellClicked())
			figur = "E";
	}	

}
