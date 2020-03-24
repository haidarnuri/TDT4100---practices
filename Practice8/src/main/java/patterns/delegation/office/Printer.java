package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer{
    private Map<Employee,List<String>> employeeHistory = new HashMap<>();
   // List<String> employeeHistory = new ArrayList<>(){};


    public void printDocument(String document, Employee employee){
        System.out.println(document);
        employeeHistory.put(employee,);

    }

    public List<String> getPrintHistory(Employee employee){
        return employeeHistory;
    }


}
