package Eksamen2017;
public class Table {

    private static int tableCounter = 1;

    private final int num;
    private final int capacity;

    public Table(int capacity) {
        this.num = tableCounter++;
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public int getNum() {
        return this.num;
    }
}