package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Clerk implements Employee{
    private int calculationTaskCount=0;
    private int printerTaskCount=0;

    private Printer printer = new Printer();

    Clerk(Printer printer){
        this.printer=printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.calculationTaskCount++;
        return  operation.apply(value1,value2);
    }

    @Override
    public void printDocument(String document) {
        printer.printDocument(document,this);
        if(!printer.getPrintHistory(this).isEmpty()){
            this.printerTaskCount++;
        }
    }

    @Override
    public int getTaskCount() {
        return this.calculationTaskCount+this.printerTaskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }
}
