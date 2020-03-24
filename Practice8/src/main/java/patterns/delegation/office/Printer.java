package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer{
    private Map<Employee,List<String>> employeeHistory;
    List<String> documentHistory;

    Printer(){
    	employeeHistory = new HashMap<>();
    	documentHistory = new ArrayList<>();
    }

    public void printDocument(String document, Employee employee){
        if(!documentHistory.contains(document) && !document.isEmpty()) {
        	documentHistory.add(document);
        }
        	employeeHistory.put(employee,documentHistory);
    }

    public List<String> getPrintHistory(Employee employee){
    	if(employeeHistory.get(employee)==null){
    	    documentHistory.clear();
    	    return documentHistory;
        }
        return employeeHistory.get(employee);   
    }


}
