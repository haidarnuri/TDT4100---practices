package Eksamen2017;

import org.junit.Assert;
import org.junit.Test;

public class GroupTest {
    Group group1 = new Group(10);


    public void initialize(){
    }

    @Test
    public void constructorTest_addingIntValue_Expecting10WhenGetValue(){
        Assert.assertEquals(10,group1.getGuestCount());
    }


}
