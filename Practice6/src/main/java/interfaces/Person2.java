package interfaces;

public class Person2 implements Named{
    private String fullName;

    public Person2(String fullName){
        setFullName(fullName);
    }

    @Override
    public void setGivenName(String name) {
        setFullName(name+" "+getFamilyName());
    }

    @Override
    public String getGivenName() {
        return getFullName().substring(0,getFullName().lastIndexOf(' '));
    }

    @Override
    public void setFamilyName(String familyName) {
        setFullName(getGivenName()+" "+familyName);
    }

    @Override
    public String getFamilyName() {
        return getFullName().substring(getFullName().lastIndexOf(' ')).trim();
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }
}
