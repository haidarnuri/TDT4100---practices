package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    private Collection<Employee> employeesList = new ArrayList<>();
    private int taskCount = 0;


    Manager(Collection<Employee> employees){
        setEmployeesList(employees);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.taskCount++;
        return 1;
    }

    @Override
    public void printDocument(String document) {
        this.taskCount++;
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    //Hvorfor legger man til 1??
    @Override
    public int getResourceCount() {
        return getEmployeesList().size() + 1;
    }

    private void setEmployeesList(Collection<Employee> employees){
        if(employees.isEmpty()){
            throw new IllegalArgumentException("Must contain at least one employee");
        }
        this.employeesList = employees;
    }

    private Collection<Employee> getEmployeesList(){
        return this.employeesList;
    }


}
