package com.company;

public class LineEditor {

	private String text = "";
	private int insertionIndex=0;


	public void insert(Object o) {
		if(o instanceof String) {
			insertString((String)o);
		}
	}


	public void deleteLeft() {
		if(validLeftPostion(0)) {
			text = getText().substring(0,getInsertionIndex()-1)
					+getText().substring(getInsertionIndex());
			//setText(tempString);
			//setInsertionIndex(getInsertionIndex()-1);
			insertionIndex--;
		}
	}

	public void deleteRight() {
		if(validRightPosition(0)) {
			text = getText().substring(0,getInsertionIndex())
					+getText().substring(getInsertionIndex()+1);
		}
	}

	public void left(int n) {
			if(validLeftPostion(n)) {
				setInsertionIndex(getInsertionIndex()-n);
			}else {
				setInsertionIndex(0);
			}
	}

	public void left() {
		left(1);
	}

	public void right(int n) {
		if(validRightPosition(n)){
				setInsertionIndex(getInsertionIndex()+n);
			}
			else {
				setInsertionIndex(getText().length());
			}
	}

	public void right() {
		right(1);
	}

	public void insertString(String s) {
		if(s!=null && getText()!=null) {
			text =  getText().substring(0,getInsertionIndex())
					+s
					+getText().substring(getInsertionIndex());
			//setText(text);
			setInsertionIndex(s.length()+getInsertionIndex());
		}
	}

	//Setter og getter
	public void setText(String text) {
		if(text!=null) {
			this.text=text;
		}
	}

	public String getText() {
		return this.text;
	}

	public void setInsertionIndex(int insertionIndex) {
		if(getText()!=null && getText().length()<insertionIndex) {
			this.insertionIndex=getText().length();
		}else if(getText()!=null && insertionIndex<0)
			this.insertionIndex=0;
		else {
			this.insertionIndex=insertionIndex;
		}
	}

	public int getInsertionIndex() {
		return this.insertionIndex;
	}

	@Override
	public String toString() {
		if(getText()!=null) {
			return getText().substring(0,getInsertionIndex())+"|"+getText().substring(getInsertionIndex());
		}else {
			return null;
		}
	}

	//Private metoder/sjekkere
	private boolean validLeftPostion(int n) {
		return getInsertionIndex()-n>0;
	}

	private boolean validRightPosition(int n) {
		return getInsertionIndex()+n<getText().length();
	}

	

	public static void main(String[] args) {
		LineEditor obj = new LineEditor();
		obj.setText("Haidar");
		obj.setInsertionIndex(0);
		obj.deleteRight();
		System.out.println(obj);
		LineEditor obj1 = new LineEditor();
		obj1.setText("hei");
		obj.insertString(obj1.getText());

		System.out.println(obj);
	}
}
