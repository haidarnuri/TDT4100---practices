package objectstructures;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.CookieHandler;


@SuppressWarnings("all")
public class CoffeeCupTest{
    //user1  = right amount of Volum compared to Capacity
    CoffeeCup user1 ;


    public void mainTest(){
        testCoffeeCup();
    }

    @Test(expected=Exception.class)
    public void testCoffeeCup() {
        String testContructorText = "Testing constructor";
        user1 = new CoffeeCup(-1,2.0);
        //Testing user 1
        assertThrows(IllegalArgumentException.class, (ThrowingRunnable)user1);
        //DET ER NOE FEIL HER!
        assertEquals(testContructorText,2.0,user1.getCapacity());
        assertEquals(testContructorText,1.0,user1.getCurrentVolume());
    }



    public void testGetCapacity(){

    }
}