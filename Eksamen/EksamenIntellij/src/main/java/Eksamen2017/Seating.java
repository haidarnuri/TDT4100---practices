package Eksamen2017;

public class Seating {

    private Group groupOfPeople;
    private final Table table;

    public Seating(Group groupOfPeople, Table table) {
        checkIsCapacity(groupOfPeople.getGuestCount(),table.getCapacity());
        this.groupOfPeople=groupOfPeople;
        this.table=table;
    }



    public void changeGroup(int newGroupNumber){
        checkIsCapacity(newGroupNumber,table.getCapacity());
        groupOfPeople.setGuestCount(newGroupNumber);
    }



    public Group getGroupOfPeople() {
        return groupOfPeople;
    }

    public Table getTable() {
        return table;
    }

    private void checkIsCapacity(int groupNumber, int tableCapacity){
        if(groupNumber>tableCapacity){
            throw new IllegalArgumentException("The group is larger than number of chairs");
        }
    }


}
