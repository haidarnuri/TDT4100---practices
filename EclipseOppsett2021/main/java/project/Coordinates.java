package project;

public class Coordinates {

	private Integer[] boardValue; 
	private Double[] buttonLayoutCoordinate; 
	
	public Coordinates(int intValue1, int intValue2,double doubleValue1, double doubleValue2) {
		this.boardValue[0] = Integer.valueOf(intValue1);
		this.boardValue[1] = Integer.valueOf(intValue2);
		this.buttonLayoutCoordinate[0] = Double.valueOf(doubleValue1);
		this.buttonLayoutCoordinate[1] = Double.valueOf(doubleValue2);

	}
	
	public Integer[] getBoardValue() {
		return this.boardValue;
	}
	
	public Double[] getButtonLayoutCoordinate() {
		return this.buttonLayoutCoordinate;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
