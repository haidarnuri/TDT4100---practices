package patterns.delegation.office;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("all")
public class ManagerTest2 extends TestCase {
    Clerk clerk1 = new Clerk();
    Clerk clerk2 = new Clerk();
    Clerk clerk3 = new Clerk();

    Collection<Employee> clerkList = new ArrayList<>();
    Manager manager1;


    public void setUp(){
        clerk1.setTaskCount(5);
        clerk2.setTaskCount(4);
        clerk3.setTaskCount(1);
        clerkList.add(clerk1);
        clerkList.add(clerk2);
        clerkList.add(clerk3);
    }

    @Test
    public void testingFindEmployeeWithLeastWork_insertingTwoDifferentClerksWithDifferentAmountWork_gettingClerkWithLeastAmountOfTask(){
        manager1 = new Manager(clerkList);
        int taskCountTemp = manager1.findEmployeeWithLeastTaskCount(clerkList);
        assertEquals(clerk2.getTaskCount(),taskCountTemp);
    }

    @Test
    public void testingGetEmployeeFromManagerList_usingGetObjectAndUsingTaskCountAsParameter_gettingClerkIAskFor() {
        Employee tempEmployee = new Clerk();
        for(Employee employee: clerkList){
            if(employee.getTaskCount()==0)
                tempEmployee = employee;
        }
        assertEquals(tempEmployee,clerk2);
    }




}
