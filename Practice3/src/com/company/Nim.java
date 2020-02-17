package com.company;

public class Nim {
    private int pileSize0;
    private int pileSize1;
    private int pileSize2;

    public Nim(int pileSize){
        setPileSize(pileSize);
    }
    public Nim(){
        setPileSize(10);
    }

    private void setPileSize(int pileSize) {
        this.pileSize0 = pileSize;
        this.pileSize1 = pileSize;
        this.pileSize2 = pileSize;
    }

    public void removePieces(int number, int targetPile){
        if(targetPile == 0){
            if(isValidMove(number, targetPile)){
                throw new IllegalArgumentException("This move isn't valid!");
            }
            if(number >=1){
                this.pileSize0-=number;
            }
            if(isGameOver()){
                throw new IllegalStateException("The pile is empty!");
            }

        }

        else if(targetPile == 1){
            if(isValidMove(number, targetPile)){
                throw new IllegalArgumentException("This move isn't valid!");
            }
            if(number >=1){
                this.pileSize1-=number;
            }
            if(isGameOver()){
                throw new IllegalStateException("The pile is empty!");
            }
        }

        else if(targetPile == 2){
            if(isValidMove(number, targetPile)){
                throw new IllegalArgumentException("This move isn't valid!");
            }
            if(number >=1){
                this.pileSize2-=number;
            }
            if(isGameOver()){
                throw new IllegalStateException("The pile is empty!");
            }
        }
        else{
            throw new IllegalArgumentException("You can only choose between targePile nr 0,1,2");
        }

    }

    public boolean isValidMove(int number, int targetPile) {
        if (targetPile == 0) {
            return number >= 1 && number <= this.pileSize0;
        } else if (targetPile == 1) {
            return number >= 1 && number <= this.pileSize1;
        } else {
            return number >= 1 && number <= this.pileSize2;
        }
    }

    public boolean isGameOver(){
        return this.pileSize0 == 0 || this.pileSize1 == 0 || this.pileSize2 == 0;
    }

    public int getPile(int targetPile){
        if(targetPile == 0){
            return this.pileSize0;
        }

        else if(targetPile == 1){

            return this.pileSize1;
        }

        else if(targetPile == 2){
            return this.pileSize2;
        }
        else{
            throw new IllegalArgumentException("This targetPile does not exist!");
        }
    }

    @Override
    public String toString(){
       return "In targetPile 0 there is " +getPile(0) + "sticks left. In targetPile 1 there is "
               +getPile(1) + "sticks left. In targetPile 2 there is "+ getPile(2) +"sticks left";
    }
}
