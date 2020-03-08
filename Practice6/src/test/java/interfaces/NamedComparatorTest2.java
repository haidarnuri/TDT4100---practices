package interfaces;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@SuppressWarnings("all")
public class NamedComparatorTest2 extends TestCase {

    private Named name1;
    private Named name2;
    private Named name3;
    private Named name4;
    private Named name5;
    private Named name6;

    private ArrayList<Named> listSameFamilyName;

    @Before
    public void init(){
        //First initiate two objects with different familyname
        name1.setFullName("Halvor Hansen");
        name2.setFullName("Hans Pettersen");


        //First initiate two objects with equal familyname and different given name
        name3.setFullName("Hans Pettersen");
        name4.setFullName("Paul Hansen");

        //equal last name and given name
        name5.setFullName("Haidar Nuri");
        name6.setFullName("Haidar Nuri");

        listSameFamilyName = null;
    }

    @Test
    public void testt(){
        try {
            listSameFamilyName.add(name1);
            listSameFamilyName.add(name2);
            failNotEquals("hehehe", Collections.sort(listSameFamilyName,NamedComparator),[name1.getFamilyName(),name2.getFamilyName()])
        }
        catch (Exception e){

        }


    }


}
