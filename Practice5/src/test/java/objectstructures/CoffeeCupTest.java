package objectstructures;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeCupTest{

    CoffeeCup coffeCup1 = new CoffeeCup(2.0, 1.0);


    //@Test(expected=IllegalArgumentException.class)
    //public void createCoffeCup_addingNegativeCapacity_throwsIllegalArgumentException() {
    //    new CoffeeCup(-1,2.0);
    //}



    //Notasjon for testing: operasjon_hvaerscenario_hvaerforventet
    @Test
    public void createCoffeCup_addingNegativeCapacityToConstructor_throwsIllegalArgumentException(){
        try {
            new CoffeeCup(-1, 2);
            throw new RuntimeException("Should throw exception when negative capacity is added to the constructor");
        } catch (IllegalArgumentException e){
            // expecting this
            assert e.getMessage().equals("Illegal capacity given.");
        }
    }

    @Test
    public void createCoffeCup_addingNegativeVolumToConstructor_throwsIllegalArgumentException(){
        try{
            new CoffeeCup(1,-2);
            throw new RuntimeException("Should throw exception when negative volume is added to the constructor");
        }catch (IllegalArgumentException e){
            e.getMessage().equals("Illegal volume given.");
        }
    }

    @Test
    public void getCapacity_gettingValueOfCapacity_gettingCapacityArgumentFromCoffeCup1(){
        assertEquals(2.0,coffeCup1.getCapacity(),0);
    }

    @Test
    public void getCurrentVolume_gettingValueOfCurrentVolum_gettingCurrentVolumArgumentFromCoffeCup1(){
        assertEquals(1.0,coffeCup1.getCurrentVolume(),0);
    }

    @Test
    public void increaseCupSize_addingNegativeValueToIncreaseCupSize_throwsIllegalArgumentException(){
        try{
            coffeCup1.increaseCupSize(-2);
            throw new RuntimeException("Should throw expection when increasing cup with negative value.");
        } catch(IllegalArgumentException e){}
    }

    @Test
    public void fillCoffee_addingTooLargeValueToFillCoffee_throwsIllegalArgumentException(){
        try{
            coffeCup1.fillCoffee(3.0);
            throw new RuntimeException("Should throw expection when filling coffee over the capacity of cup.");
        } catch (IllegalArgumentException e){
            e.getMessage().equals("You just poured coffee all over the table. Good job.");
        }
    }

    @Test
    public void fillCoffee_addingNegativeValueToFillCoffee_throwsIllegalArgumentException(){
        try{
            coffeCup1.fillCoffee(-3.0);
            throw new RuntimeException("Should throw expection when filling coffee with negative value.");
        } catch (IllegalArgumentException e){}
    }

    @Test
    public void drinkCoffee_addingNegativeValueToDrinkCoffee_throwsIllegalArgumentException(){
        try{
            coffeCup1.drinkCoffee(-3.0);
            throw new RuntimeException("Should throw expection when filling coffee with negative value.");
        } catch (IllegalArgumentException e){}
    }

    @Test
    public void drinkCoffee_drinkMoreThanCapacityOfCup_throwsIllegalArgumentException(){
        try{
            coffeCup1.drinkCoffee(3.0);
            throw new RuntimeException("Should throw expection when drinking more than the capacity of cup.");
        } catch (IllegalArgumentException e){
            e.getMessage().equals("You can't drink that much coffee!");
        }
    }
}