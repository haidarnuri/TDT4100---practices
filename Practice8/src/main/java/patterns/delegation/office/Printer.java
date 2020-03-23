package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;

public class Printer{
    String printHistory = new String();
    ArrayList<String> employeeHistory = new ArrayList<String>(){};

    public void printDocument(String document, Employee employee){
        System.out.println(document);
        employeeHistory.add(document);
    }

    public List<String> getPrintHistory(Employee employee){
        return employeeHistory;
    }


}
