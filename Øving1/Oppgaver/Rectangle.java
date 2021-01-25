package com.company;

public class Rectangle {

	private int minX=0;
	private int maxX=0;
	private int minY=0;
	private int maxY=0;
	
	
	public int getMinX() {
		return this.minX;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
	public int getMinY() {
		return this.minY;
	}
	
	public int getMaxY() {
		return this.maxY;
	}
	
	public boolean isEmpty() {
		return getMinX()==0 && getMinY()==0 && getMaxX()==0 && getMaxY()==0;
	}
	
	public int getWidth() {
		if(isEmpty()) {
			return 0;
		}else if(getMinX()==getMaxX()) {
			return 1;
		}else {
			return getMaxX()-getMinX() +1;
		}
	}
	
	public int getHeight() {
		if(isEmpty()) {
			return 0;
		}else if(getMinY()==getMaxY()) {
			return 1;
		}else {
			return getMaxY()-getMinY() +1;
		}
	}
	
	public boolean contains(int x, int y) {
		if(isEmpty()) {
			return false;
		}else {
			return getMinX()<=x && x<=getMaxX() && getMinY()<=y && y<=getMaxY();
		}
	}
	
	public boolean contains(Rectangle rect) {
		if(rect.isEmpty()) {
			return false;
		}else {
			return contains(rect.getMaxX(),rect.getMaxY()) && contains(rect.getMinX(),rect.getMinY());
		}
	}
	
	
	public boolean add(int x, int y) {
		boolean isAdded = false;
		if(isEmpty()) {
			this.minX = x;
			this.maxX = x;
			this.minY = y;
			this.maxY = y;
			isAdded=true;
		}
		if(x<getMinX()) {
			this.minX = x;
			isAdded=true;
		}
		if(y<getMinY()) {
			this.minY = y;
			isAdded=true;
		}
		if(x>getMaxX()) {
			this.maxX = x;
			isAdded=true;
		}
		if(y>getMaxY()) {
			this.maxY=y;
			isAdded=true;
		}
		return isAdded;
	}
	
	public boolean add(Rectangle rect) {
		if(rect.isEmpty()) {
			return false;
		}else{
			boolean addMax = add(rect.getMaxX(),rect.getMaxY());
			boolean addMin = add(rect.getMinX(), rect.getMinY());
			return addMax && addMin;
		}
	}
	
	public Rectangle union(Rectangle rect) {
		Rectangle tempRect = new Rectangle();
		tempRect.add(this);
		tempRect.add(rect);
		return tempRect;
	}
	
	//Ikke testet om denne fungerer enda. 
	public Rectangle intersection(Rectangle rect) {
		Rectangle newRect = new Rectangle();
		if(isEmpty() && !rect.isEmpty()) {
			newRect.add(rect);
		}else if(rect.isEmpty()&&!isEmpty()) {
			newRect.add(this);
		}else if(!(isEmpty() && rect.isEmpty())) {
			if(getMinY()<rect.getMinY()) {
				for(int y=getMinY();y<=getMaxY();y++) {
					for(int x=getMinX();x<getMaxX();x++) {
						if(rect.contains(x,y)) {
							newRect.add(x, y);
						}
					}
				}
			}
			/*
			else if(getMinY()>rect.getMinY()) 
			{
				for(int y=rect.getMinY();y<=rect.getMaxY();y++) {
					for(int x=rect.getMinX();x<rect.getMaxX();x++) {
						if(contains(x,y)) {
							newRect.add(x, y);
						}
					}
				}
			} */
		}
		return newRect;
	}
	
	
	
	
	public static void main(String[] args) {
		

	}

}










