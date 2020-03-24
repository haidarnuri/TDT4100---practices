package patterns.delegation.office;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    Collection<Employee> employeesList = new HashSet<Employee>();

    Manager(Collection<Employee> employees){
        setEmployeesList(employees);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {

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
        return getEmployeesList().size();
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
