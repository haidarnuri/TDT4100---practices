package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    private Collection<Employee> employeesList = new ArrayList<>();
    private int taskCount = 0;
    private int resourceCount = 0;

    int leastAmountOfTaskCountOfEmployee = 0;


    Manager(Collection<Employee> employees){
        setEmployeesList(employees);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        leastAmountOfTaskCountOfEmployee=findEmployeeWithLeastTaskCount(getEmployeesList());
        double calculations = 0;
        for(Employee employee:employeesList){
            if(employee.getTaskCount()==leastAmountOfTaskCountOfEmployee) {
                calculations = employee.doCalculations(operation, value1, value2);
                break;
            }
        }
        this.taskCount++;
        return calculations;
    }

    @Override
    public void printDocument(String document) {
        leastAmountOfTaskCountOfEmployee=findEmployeeWithLeastTaskCount(getEmployeesList());
        for(Employee employee:employeesList) {
            if (employee.getTaskCount() == leastAmountOfTaskCountOfEmployee) {
                employee.printDocument(document);
                this.taskCount++;
                break;
            }
        }
    }

    @Override
    public int getTaskCount() {
        return this.taskCount;
    }

    //Hvorfor legger man til 1??
    @Override
    public int getResourceCount() {
        for (Employee employee: employeesList){
            this.resourceCount += employee.getResourceCount();
        }
        return this.resourceCount+1;
    }

    private void setEmployeesList(Collection<Employee> employees){
        if(employees.isEmpty()){
            throw new IllegalArgumentException("Must contain at least one employee");
        }
        this.employeesList = employees;
    }

    public Collection<Employee> getEmployeesList(){
        return this.employeesList;
    }

    public int findEmployeeWithLeastTaskCount(Collection<Employee> employeesList){
        Employee currentEmployee;
        int tempTaskCount=0;

        for(Employee employee: employeesList){
            currentEmployee = employee;
            tempTaskCount = currentEmployee.getTaskCount();
            break;
        }

        for(Employee employee: employeesList) {
            if(employee.getTaskCount()<tempTaskCount){
                tempTaskCount=employee.getTaskCount();
            }
        }

        /*while(employeesList.iterator().hasNext()){
            if(employeesList.iterator().next().getTaskCount()<leastAmountOfTaskCount){
                leastAmountOfTaskCount = employeesList.iterator().next().getTaskCount();
            }
            }*/
        this.leastAmountOfTaskCountOfEmployee=tempTaskCount;
        return this.leastAmountOfTaskCountOfEmployee;
    }

}
