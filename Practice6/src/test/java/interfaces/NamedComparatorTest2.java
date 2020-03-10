package interfaces;


import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


@SuppressWarnings("all")
public class NamedComparatorTest2 extends TestCase {

    //Two objects with different family name
    private Named name1 = new Person2("Halvor Hansen");
    private Named name2 = new Person2("Hans Pettersen");

    //Two objects with different given name and same family name
    private Named name3 = new Person2("Alan Nuri");
    private Named name4 = new Person2("Haidar Nuri");

    //Two objects with same family name and same given name
    private Named name5 = new Person2("Haidar Nuri");
    private Named name6 = new Person2("Haidar Nuri");

    //Create three arrayList til compare with expected list.
    private ArrayList<Named> listDifferentFamilyName = new ArrayList<>();
    private ArrayList<Named> listDifferentGivenName = new ArrayList<>();
    private ArrayList<Named> listSameFullName = new ArrayList<>();
    private ArrayList<Named> expectedList = new ArrayList<>();

    @Test
    public void testingNamedComparator_addingMembersInListFamilyNameWithDifferentFamilyNames_equalToActualList(){
        listDifferentFamilyName.add(name2);
        listDifferentFamilyName.add(name1);
        expectedList.add(name1);
        expectedList.add(name2);
        Collections.sort(listDifferentFamilyName,new NamedComparator());
        assertEquals(listDifferentFamilyName, expectedList);


    }

    @Test
    public void testingNamedComparator_addingMembersInListGivenNameWithSameFamilyNameAndDifferentGivenName_equalToExpectedList(){
        listDifferentGivenName.add(name4);
        listDifferentGivenName.add(name3);
        expectedList.add(name3);
        expectedList.add(name4);
        Collections.sort(listDifferentGivenName,new NamedComparator());
        assertEquals(listDifferentGivenName, expectedList);
    }

    @Test
    public void testingNamedComparator_addingMembersInListGivenNameWithSameFullName_equalToExpectedList(){
        listSameFullName.add(name5);
        listSameFullName.add(name6);
        expectedList.add(name5);
        expectedList.add(name6);
        Collections.sort(listSameFullName,new NamedComparator());
        assertEquals(listSameFullName, expectedList);
    }

}
