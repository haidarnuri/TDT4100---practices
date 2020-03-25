package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Clerk implements Employee{
    private int taskCount=0;

    private Printer printer = new Printer();
    Clerk(){}

    Clerk(Printer printer){
        this.printer=printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.taskCount++;
        return  operation.apply(value1,value2);
    }

    @Override
    public void printDocument(String document) {
        printer.printDocument(document,this);
        if(!printer.getPrintHistory(this).isEmpty()){
            this.taskCount++;
        }

    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }

    //Just for testing ManagerTest2
    public void setTaskCount(int taskCount){
        this.taskCount = taskCount;
    }
}
