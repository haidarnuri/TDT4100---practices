package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class createNeighbourCell {

	private GameBoard gameboard;
	
	public createNeighbourCell(GameBoard gameboard) {
		this.gameboard=gameboard;
	}
	
	public void createNeighbours() {
		HashMap<List<Integer>, List<Integer>> mainCellToNeighboursMap = new HashMap<>();
		List<Integer> mainCellPos=new ArrayList<>();
		
		List<Integer> neighbourCellValue = new ArrayList<>();
		for (int row = 0; row < gameboard.getGeneratedBeforeGameboard().length; row++) {
			for (int col = 0; col < gameboard.getGeneratedBeforeGameboard()[0].length; col++) {
				if(row-1>=0 && col-1>=0) {
					neighbourCellValue.add(row-1,col-1);
				}if(col-1>=0) {
					neighbourCellValue.add(row,col-1);
				}if(row+1<=gameboard.getGeneratedBeforeGameboard().length-1 && col-1>=0) {
					neighbourCellValue.add(row+1,col-1);
				}if(row-1>=0) {
					neighbourCellValue.add(row-1,col);
				}if(row+1<=gameboard.getGeneratedBeforeGameboard().length-1) {
					neighbourCellValue.add(row+1,col);
				}if(row-1>=0 && col+1<=gameboard.getGeneratedBeforeGameboard()[0].length-1) {
					neighbourCellValue.add(row-1,col+1);
				}if(col+1<=gameboard.getGeneratedBeforeGameboard()[0].length-1) {
					neighbourCellValue.add(row,col+1);
				}if(row+1<=gameboard.getGeneratedBeforeGameboard().length-1&&col+1<=gameboard.getGeneratedBeforeGameboard()[0].length-1) {
					neighbourCellValue.add(row+1,col+1);
				}
				mainCellPos.add(row,col);
				mainCellToNeighboursMap.put(mainCellPos, neighbourCellValue);
			}
		}
	}
	
	
	
	
	
	

	/*
	 * private void createValidNeighbour(Cell[][] arrayOfCells) {
			 HashMap<GameBoard, Integer[][]> layoutValuesToListValues = new HashMap<GameBoard, Integer[][]>();
			 Integer[][] tempVaules;
			 for (int row = 0; row < arrayOfCells.length; row++) {
					for (int col = 0; col < arrayOfCells[0].length; col++) {
						if(row-1>=0 && col-1>=0) {
							
						}if(col-1>=0) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && col-1>=0) {
							
						}if(row-1>=0) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1) {
							
						}if(row-1>=0 && col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}if(col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}if(row+1<=board.getGeneratedBeforeGameboard().length-1&&col+1<=board.getGeneratedBeforeGameboard()[0].length-1) {
							
						}
					}
			}
			 
			 
			 
			 
		 }
		
		private String countNumberOfBombsAroundCell(int row, int col) {
			int tempCounter = 0;
			if(row-1>=0 && col-1>=0 && board.getGeneratedBeforeGameboard()[row-1][col-1].getFigur()=="M") {
				tempCounter++;
			}if(col-1>=0 && board.getGeneratedBeforeGameboard()[row][col-1].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && col-1>=0 && board.getGeneratedBeforeGameboard()[row+1][col-1].getFigur()=="M") {
				tempCounter++;
			}if(row-1>=0 &&board.getGeneratedBeforeGameboard()[row-1][col].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1 && board.getGeneratedBeforeGameboard()[row+1][col].getFigur()=="M") {
				tempCounter++;
			}if(row-1>=0 && col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row-1][col+1].getFigur()=="M") {
				tempCounter++;
			}if(col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row][col+1].getFigur()=="M") {
				tempCounter++;
			}if(row+1<=board.getGeneratedBeforeGameboard().length-1&&col+1<=board.getGeneratedBeforeGameboard()[0].length-1&&board.getGeneratedBeforeGameboard()[row+1][col+1].getFigur()=="M") {
				tempCounter++;
			}
			
			return String.valueOf(tempCounter);
		}
	 */
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
