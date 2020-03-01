package interfaces;

import java.util.Comparator;


public class NamedComparator implements Comparator<Named> {

    @Override
    public int compare(Named named1, Named named2) {
        if(named1.getFamilyName().compareTo(named2.getFamilyName()) == 0){
            return named1.getGivenName().compareTo(named2.getGivenName());
        }
        else{
            return named1.getFamilyName().compareTo(named2.getFamilyName());
        }
    }

}
