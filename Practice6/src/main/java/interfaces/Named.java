package interfaces;

public interface Named {
    //fornavn
    void setGivenName(String name);
    String getGivenName();


    //etternavn
    void setFamilyName(String familyName);
    String getFamilyName();


    //hele navnet
    void setFullName(String fullName);
    String getFullName();



}