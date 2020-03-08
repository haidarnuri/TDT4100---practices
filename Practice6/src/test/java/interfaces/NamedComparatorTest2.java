package interfaces;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


@SuppressWarnings("all")
public class NamedComparatorTest2 extends TestCase {

    private Named name1 = new Person2("Halvor Hansen");
    private Named name2 = new Person2("Hans Pettersen");
    private Named name3 = new Person2("Haidar Nuri");
    private Named name4;
    private Named name5;
    private Named name6;

    private ArrayList<Named> listSameFamilyName = new ArrayList<>();
    private ArrayList<Named> actualtList = new ArrayList<>();

    @Test
    public void test1(){
        listSameFamilyName.add(name2);
        listSameFamilyName.add(name1);
        listSameFamilyName.add(name3);
        actualtList.add(name1);
        actualtList.add(name3);
        actualtList.add(name2);
        Collections.sort(listSameFamilyName,new NamedComparator());
        assertEquals(listSameFamilyName, actualtList);
    }

}
