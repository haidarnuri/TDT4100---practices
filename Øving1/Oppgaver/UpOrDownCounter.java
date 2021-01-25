package com.company;

public class UpOrDownCounter {
    private int counter;
    private int end;

    public UpOrDownCounter(int start, int end){
        if (start == end)
            throw new IllegalArgumentException("Start og slutt verdi mÃ¥ vÃ¦re ulike");
        this.counter = start;

        this.end = end;
    }

    public int getCounter(){
        return this.counter;
    }

    public boolean count() {
        if(this.counter < this.end) {
            counter +=1;
            if (this.counter == this.end) {
                return false;
            }
            else {
                return true;
            }
        }
        else if(this.counter > this.end) {
            counter -=1;
            if (this.counter == this.end) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "Verdien av counter = " + this.counter + " Sluttiden er " + this.end;
    }

}