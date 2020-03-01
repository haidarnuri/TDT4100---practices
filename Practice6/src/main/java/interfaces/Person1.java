package interfaces;

public class Person1 implements Named{
    private String givenName;
    private String familyName;


    public Person1(String givenName, String familyName){
        setGivenName(givenName);
        setFamilyName(familyName);
    }

    @Override
    public void setGivenName(String name) {
        this.givenName = name;
    }

    @Override
    public String getGivenName() {
        return this.givenName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String getFamilyName() {
        return this.familyName;
    }

    @Override
    public void setFullName(String fullName) {
        //Divide fullName into first name and last name
        setGivenName(fullName.substring(0,fullName.lastIndexOf(' ')));
        setFamilyName(fullName.substring(fullName.lastIndexOf(" "+1)));
    }

    @Override
    public String getFullName() {
        return getGivenName()+" "+getFamilyName();
    }
}
