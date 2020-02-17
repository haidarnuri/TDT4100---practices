package com.company;


public class Digit {
    private int numberSystem;
    private int numberValue;


    public Digit(int numberSystem, int numberValue){
        setNumberSystem(numberSystem);
        setNumberValue(numberValue);
    }

    public int getNumberSystem(){
        return this.numberSystem;
    }

    public void setNumberSystem(int numberSystem) {
        //legger til 35 fordi at det er 35 ledd for 0-9 + A-Z
        if (numberSystem<35) {
            this.numberSystem = numberSystem;
        }
        else{
            throw new IllegalArgumentException("Dette er ikke et gyldig tallsystem.");
        }
    }


    public int getNumberValue(){
        return this.numberValue;
    }

    public void setNumberValue(int numberValue) {
        int temp = numberValue % numberSystem;
        if(temp>9){
            this.numberValue = (char)(numberValue+55);
        }
        else{
            this.numberValue = temp;
        }
    }

    @Override
    public String toString(){
        return "Tallsystemet du har valgt er "+getNumberSystem()+". Sifferet ditt er: "+getNumberValue()+".";
    }

}
