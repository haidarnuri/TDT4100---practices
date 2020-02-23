package objectstructures;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.CookieHandler;


@SuppressWarnings("all")
public class CoffeeCupTest{
    //user1  = right amount of Volum compared to Capacity
    static final String FINAL_VARIABLE = "This never changes";

    CoffeeCup user1;
    CoffeeCup user2;
    CoffeeCup user3;
    CoffeeCup user4;
    CoffeeCup user5;

    @Before
    public void initVariables(){
        user1 = new CoffeeCup(-1, 2);
    }

    //Notasjon for testing: operasjon_hvaerscenario_hvaerforventet
    @Test(expected=IllegalArgumentException.class)
    public void createCoffeCup_addingNegativeCapacity_throwsIllegalArgumentException() {
        new CoffeeCup(-1,2.0);

    }


    @Test
    public void testGetCapacity(){
        try {
            new CoffeeCup(-1, 2);
            throw new RuntimeException("Fail if this is thrown");
        } catch (IllegalArgumentException e){
            // expecting this
            assert e.getMessage().equals("Illegal capacity given.");
        }
    }
}