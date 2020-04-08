package Eksamen2017;

import org.junit.Assert;
import org.junit.Test;

public class SeatingTest {
    Group group1 = new Group(10);
    Group group2 = new Group(20);
    private int capacity1 = 10;
    Table table1 = new Table(capacity1);
    Seating seating1 = new Seating(group1,table1);

    @Test
    public void getGroup_addingGroup1InConstructor_ExpectingGroup1(){
        Assert.assertEquals(group1,seating1.getGroupOfPeople());
    }

    @Test
    public void getTable_addingTable1InConstructor_ExpectingTable1(){
        Assert.assertEquals(table1,seating1.getTable());
    }

    @Test
    public void testingConstructor_addingLargerGroupThanCapacity_ExpectingException(){
        try {
            Seating seating2=new Seating(group2, table1);
            throw new IllegalStateException("Should throw error when group larger than capacity");
        }catch (IllegalArgumentException e){}
    }

    @Test
    public void testingChangeGroupNumber_addingLargerGroupThanCapacity_ExpectingException(){
        try {
            seating1.changeGroup(20);
            throw new IllegalStateException("Should throw error when group larger than capacity");
        }catch (IllegalArgumentException e){}
    }


}
