package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;

public class main {
    public static void main(String[] args) {
        Clerk clerk1 = new Clerk();
        Clerk clerk2 = new Clerk();
        Clerk clerk3 = new Clerk();
        clerk1.setTaskCount(0);
        clerk2.setTaskCount(0);
        clerk3.setTaskCount(0);

        Collection<Employee> employees = new ArrayList<>();
        employees.add(clerk1);
        employees.add(clerk2);
        employees.add(clerk3);


        Manager middleManager = new Manager(employees);
        employees.add(middleManager);
        Manager topManager = new Manager(employees);
        topManager.printDocument("hei");
        topManager.printDocument("ei");
        middleManager.printDocument("hehe");

        System.out.println("Resource count for clerk 1 is " +clerk1.getResourceCount());
        System.out.println("Resource count for clerk 2 is " +clerk2.getTaskCount());
        System.out.println("Resource count for clerk 3 is " +clerk3.getTaskCount());

        System.out.println("Resource count for middleManager is " +middleManager.getResourceCount());
        System.out.println("Task count for middleManager is " +middleManager.getTaskCount());

        System.out.println("Task count for topManager is " +topManager.getTaskCount());
        System.out.println("Resource count for topManager is " +topManager.getResourceCount());


    }
}
