package Eksamen2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Diner {

    private Collection<Table> allTables =new ArrayList<>();
    private Collection<Seating> seatingGroups=new ArrayList<>();

    //Oprettet på eget insj. Ikke en del av oppgaven.
    public Collection<Table> getAllTables(){
        return this.allTables;
    }


    //Hvis en i sittegruppa har borde, så er bordet opptatt.
    public boolean isOccupied(Table table) {
        boolean isOccupied=false;
        for(Seating seating:seatingGroups){
            if(seating.getTable().equals(table)){
                isOccupied=true;
            }
        }
        return isOccupied;
    }

    //Noe ekstra jeg har lagt inn selv. Ikke regn med denne.
    public void addSeatingGroups(Seating seatingGroup){
        if(!seatingGroups.contains(seatingGroup)){
            seatingGroups.add(seatingGroup);
        }
    }

    public int getCapacity(boolean includeOccupied) {
        if(includeOccupied){
            return allTables.size()+seatingGroups.size();
        }else{
        return allTables.size();}
    }

    public void removeTable(Table table){
        if(isOccupied(table)){
            throw new IllegalArgumentException("This table can not be removed, because it is occupied");
        }else{
            allTables.remove(table);
        }
    }

    public void addtable(Table table){
        if(!allTables.contains(table)){
            allTables.add(table);
        }
    }

    /**
     * Merges two tables, i.e. replaces two tables with one table.
     * lostCapacity is the difference between the old capacity and the new.
     * This number is typically positive, since seats are lost when moving two tables
     * close to each other.
     * @param table1
     * @param table2
     * @param lostCapacity
     * @throws IllegalArgumentException if any of the tables are occupied
     */
    public void mergeTables(Table table1, Table table2, int lostCapacity) {
              if(isOccupied(table1) || isOccupied(table2)){
                  throw new IllegalArgumentException("At least one of these tables are occupied. Can not merge");
              }
              int capacityAfterMerge = table1.getCapacity()+table2.getCapacity()-lostCapacity;
              Table mergeTable = new Table(capacityAfterMerge);
              allTables.remove(table1);
              allTables.remove(table2);
              allTables.add(mergeTable);
    }
    public void splitTables(Table table, int capacity1, int capacity2) {
              if(isOccupied(table)){
                  throw new IllegalArgumentException("This table is occupied. Can not split");
              }
              if(capacity1+capacity2>table.getCapacity()){
                  throw new IllegalArgumentException("Table does not have enough chairs to split in these groups");
              }
              Table splitTable1 = new Table(capacity1);
              Table splitTable2 = new Table(capacity2);
              allTables.remove(table);
              allTables.add(splitTable1);
              allTables.add(splitTable2);
    }

    /**
     * Tells whether a table has the provided capacity,
     * i.e. if that number of new guests can be seated there.
     * Note that a table cannot be shared among different groups.
     * @param table
     * @param capacity
     * @return true of capacity number of guests can be seated here, false otherwise.
     */
    public boolean hasCapacity(Table table, int capacity) {
        return table.getCapacity()>=capacity;
    }

    /**
     * Returns the tables that has the provided capacity.
     * The tables should be sorted with the one with the least capacity (but enough) first.
     * @param capacity
     * @return the tables that has the provided capacity
     */
    public Collection<Table> findAvailableTables(int capacity) {
            Table tempWithLeastCap = null;
            for(Table table: allTables){
                if(hasCapacity(table,capacity)){
                    tempWithLeastCap = table;
                }
              }
            for(Table table:allTables){
                if(hasCapacity(table,capacity) && table.getCapacity()<tempWithLeastCap.getCapacity()){

                }
            }
    }





}
