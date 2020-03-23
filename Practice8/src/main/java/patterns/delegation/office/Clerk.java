package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{

    Clerk(Printer printer){

    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        return 0;
    }

    @Override
    public void printDocument(String document) {

    }

    @Override
    public int getTaskCount() {
        return 0;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }
}
