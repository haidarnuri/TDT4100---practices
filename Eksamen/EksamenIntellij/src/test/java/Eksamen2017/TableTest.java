package Eksamen2017;

import org.junit.Assert;
import org.junit.Test;

public class TableTest {
    private int capacity1 = 10;
    private Table table1 = new Table(capacity1);
    private Table table2 = new Table(capacity1);

    @Test
    public void testGetTableNumber_CreatingTable1_Expecting1AsTableNumber(){
        Assert.assertEquals(1,table1.getNum());
    }

    @Test
    public void testGetTableNumber_CreatingTable2_Expecting1AsTableNumber(){
        Assert.assertEquals(2,table2.getNum());
    }


    @Test
    public void testGetCapacity_InsertingKeyInMapping_Expecting10AsCapacity(){
        Assert.assertEquals(capacity1,table1.getCapacity());
    }
}
