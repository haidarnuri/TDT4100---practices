package objectstructures;
import junit.framework.TestCase;
import org.junit.Test;

import java.net.CookieHandler;


@SuppressWarnings("all")
public class CoffeeCupTest extends junit.framework.TestCase {
    //user1  = right amount of Volum compared to Capacity
    CoffeeCup user1 = new CoffeeCup(2.0,1.0);

    //user2 = too much Volum
    CoffeeCup user2 = new CoffeeCup(2.0,3.0);

    //user 3 = equal amount
    CoffeeCup user3 = new CoffeeCup(2.0,2.0);

    //user4 = object without parameters in constructor.
    CoffeeCup user4 = new CoffeeCup();



    public void testCoffeeCup() {
        testGetCapacity();
    }


    public void testGetCapacity(){
        //Testing different situations with getCapacity()
        assertEquals("Testing getCapacity method", 2.0,user1.getCapacity());



    }
}