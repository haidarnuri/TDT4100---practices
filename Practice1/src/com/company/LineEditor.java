package com.company;

public class LineEditor {

    private String text;
    private int insertionIndex;



//Starter med settere og gettere.
    public void setText(String newText){
        setInsertionIndex(newText.length());
        this.text = newText;
    }


    public void setInsertionIndex(int newInsertionIndex) {
        this.insertionIndex = newInsertionIndex;
    }

    public int getInsertionIndex(){return this.insertionIndex;}

    public String getText(){return this.text;}


    //Under er resterende public metodene.
    public void left(){
        this.insertionIndex-=1;
    }

    public void right(){
        this.insertionIndex+=1;
    }

    public void insertString(String s){
        String newString = "";
        if(getInsertionIndex() == getText().length()){
            newString = getText() + " " + s;
            setInsertionIndex(newString.length());
        }
        else {
            for (int i = 0; i < getText().length(); i++) {
                newString += getText().charAt(i);
                if (i == getInsertionIndex()) {
                    newString += s;
                    right();
                }
            }
        }
        this.text = newString;
    }

    public void deleteLeft(){
        if(getInsertionIndex()==0){
            throw new IllegalArgumentException("No char at left!");
        }
        else{
        this.text = getText().substring(0,getInsertionIndex()-1) + getText().substring(getInsertionIndex());
        setInsertionIndex(this.insertionIndex - 1);
        System.out.println(this.text);
      }
    }

    public void deleteRight(){
        if(this.text == null) {
            System.out.println("hre");
            this.text = " ";
        }

        else if(getInsertionIndex()==getText().length()){
            throw new IllegalArgumentException("No char at right side!");
        }
        else {
            this.text = getText().substring(0, getInsertionIndex()) + getText().substring(getInsertionIndex()+1);
            System.out.println(this.text);
        }
    }

    public void insert(Object o){

        String newString = o.toString();

        insertString(newString);

    }

    public void left(int n){

        if(n>text.substring(0,getInsertionIndex()).length()){

            //     System.out.println("Du kan ikke flytte den så langt bak. Den blir bare flyttet til posisjon 0");
            setInsertionIndex(0);
        }
        else {

            setInsertionIndex(this.insertionIndex - n);
        }
    }

    public void right(int n){
        if(n>text.substring(getInsertionIndex()).length()){
            //        System.out.println("Du kan ikke flytte den så langt frem. Den blir bare flyttet til siste mulige posisjon");
            setInsertionIndex(text.length()-1);
        }
        else {
            setInsertionIndex(this.insertionIndex + n);
        }
    }

    //Under er alle private metodene.




}