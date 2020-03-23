package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
    private int taskCount=0;
    private Printer printer;

    Clerk(Printer printer){
        this.printer=printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.taskCount++;
        return 0;
    }

    @Override
    public void printDocument(String document) {
        printer.printDocument(document,this);
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }
}
