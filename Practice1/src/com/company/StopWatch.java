package com.company;

import javafx.scene.paint.Stop;

public class StopWatch {

    private boolean start;
    private boolean stop;


    private int lapTicks;
    private int numberOfRounds;
    private int totalTicks;
    private int tempTotalTicks;
    private int lastLapTicks;



    public boolean isStarted(){
        return this.start;
   }

   public boolean isStopped(){
        return this.stop;
   }

   public int getTicks(){
        return this.totalTicks;
   }

   public int getTime(){
       if (isStopped()){
           return -1;
       }
       else{
           return getTicks();
       }
   }

   public int getLapTime(){
        if (isStopped()){
            return -1;
        }
        else {
            return this.lapTicks;
        }
   }

   public int getLastLapTicks(){
    if (numberOfRounds == 0){
            return -1;
    }
    else{
        return this.lastLapTicks;
    }
    }

    public void tick(int ticks){
        this.totalTicks +=ticks;
        this.lapTicks += ticks;
    }

    public void start(){
        //Tenker at når vi har startet runda, så er vi i gang med første runde, derfor setter jeg verdien
        //numberOfRounds = 1 selv om det ikke er lagt til noe ticks.
        this.start = true;
        this.stop = false;
        lap();
    }

    public void stop(){
        this.stop = true;
        this.start = false;
        this.lapTicks = 0;
    }

    public void lap(){
        //Lagrer verdien til forrige lapTicks, før jeg resetter den til 0.
        this.lastLapTicks = this.lapTicks;
        this.lapTicks = 0;
        this.numberOfRounds+=1;
    }

    @Override
    public String toString() {
        return "Antall totale ticks som har gått er: " +getTicks()+ ". Tid i denne lap er" + this.lapTicks+" Antall runder/laps er " + this.numberOfRounds + "Tid forrige lap er " + getLastLapTicks();
    }
}
