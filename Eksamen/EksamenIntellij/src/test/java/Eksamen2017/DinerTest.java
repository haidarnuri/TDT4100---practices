package Eksamen2017;

import javafx.scene.control.Tab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

public class DinerTest {
    Group group1 = new Group(10);
    Group group2 = new Group(20);
    Table table1 = new Table(group1.getGuestCount());
    Table table2 = new Table(group2.getGuestCount());
    Table table3 = new Table(10);
    Table table4 = new Table(15);
    Table table5 = new Table(20);
    Seating seating1 = new Seating(group1,table1);
    Seating seating2 = new Seating(group2,table2);
    Diner dine1 = new Diner();

    @Before
    public void setUp(){
        dine1.addtable(table1);
        dine1.addtable(table2);
        dine1.addtable(table3);
        dine1.addtable(table4);
        dine1.addtable(table5);
        dine1.addSeatingGroups(seating1);
        dine1.addSeatingGroups(seating2);
    }

    @Test
    public void isOccupied_addingTableWhichIsOccupied_expectingTrue(){
        Assert.assertEquals(true,dine1.isOccupied(table1));
    }

    @Test
    public void isOccupied_addingTableWhichIsAvailable_expectingFalse(){
        Assert.assertEquals(false,dine1.isOccupied(table3));
    }
    @Test
    public void mergeTables_mergingTwoAvailableTables_expectingTrue(){
        Table newTable = new Table(table3.getCapacity()+table4.getCapacity()-3);
        dine1.mergeTables(table3,table4,3);
        boolean testTrueOrFalse = false;
        for(Table table:dine1.getAllTables()){
            if(table.getCapacity()==newTable.getCapacity()){
                testTrueOrFalse=true;
            }
        }
        Assert.assertEquals(true,testTrueOrFalse);
    }
































}
