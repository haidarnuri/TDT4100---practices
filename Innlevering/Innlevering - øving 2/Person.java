package com.company;
import java.util.Date;

public class Person {

    private String name;
    private String email;
    private Date birthday;
    private char gender;

    private String firstName;
    private String familyName;
    private String SSN;


    private final String[] landCode = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};


    //Samler alle settere under her.
    public void setFirstName(String fullName){
        if(!validateFirstNameLength(fullName)){
            throw new IllegalArgumentException("Fornavnet ditt er for kort. Skal være minst 2 bokstaver.");
        }
        else{
            this.firstName = fullName.substring(0,fullName.indexOf(" ")).trim();
        }
    }

    public void setFamilyName(String fullName){
        if(!validateLastNameLength(fullName)){
            throw new IllegalArgumentException("Etternavnet ditt er for kort. Skal være minst 2 bokstaver.");
        }
        else{
            this.familyName = fullName.substring(fullName.indexOf(" ")+1).trim();
        }
    }

    public void setName(String fullName) {
        int spaceIndex = 0;
        for(char c : fullName.toCharArray()) {
            if(Character.isWhitespace(c)){
                spaceIndex +=1;
            }
        }
        if(spaceIndex>1) {
            throw new IllegalArgumentException("Det er altfor mange mellomrom i navnet.");
        }
        else if(fullName.equals("") || fullName.equals("\0")) {
            throw new IllegalArgumentException("Navnet er tomt.");
        }
        else if(fullName.length()<5) {
            throw new IllegalArgumentException("Navnet ditt er for kort. ");
        }
        else if(containsDigits(fullName)) {
            throw new IllegalArgumentException("Navnet kan ikke inneholde tall.");
        }
        else{
            setFirstName(fullName);
            setFamilyName(fullName);
            this.name = deleteSpaceInName(fullName);}
    }

    public void setEmail(String email) {
        if (validateMail(email)) {
            this.email = email;
        }
        else if(isEmpty(email)){
            this.email = "";
        }
        else{
            throw new IllegalArgumentException("Email er ikke riktig format. Det skal være fornavn.etternavn@domene.landskode");
        }
    }

    public void setBirthday(Date birthday){
        if(validateBirthday(birthday)){
            this.birthday = birthday;
        }
        else {
            throw new IllegalArgumentException("Datoen du skriver inn kan ikke være fra i dag eller fremtiden!");
        }
    }

    public void setGender(char gender) {
        if (validateGenderNotation(gender)) {
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException("Du må skrive M for mann, F for kvinne eller 0.");
        }
    }


    public void setSSN(String SSN){
        //add a leading zero
        //String.format("%02d", month);
        //sjekker om lengden er riktig.
        if(!validLength(SSN)){
            throw new IllegalArgumentException("Personnummeret ditt er ikke riktig lengde");
        }
        //sjekker om de seks første sifrene er riktig format.
        String day = correctCalenderFormat(getBirthday().getDate());
        String month = correctCalenderFormat(getBirthday().getMonth());
        String year = correctCalenderFormat(getBirthday().getYear());

        char N3 = 0;
        //SJekker om N3 er partall for kvinner og oddetall for menn.
        if(validN3Condition(SSN)){
            N3 = SSN.charAt(8);
        }

        //Sjekker K1 verdien og K2 verdiene.
        String K1 = calculateK1(SSN);
        String K2 = calculateK2(SSN);

        //Plasserer N1 og N2. De kan være vilkåerlig siffer.
        char N1 = SSN.charAt(6);
        char N2 = SSN.charAt(7);

        //Kan for eksempel sjekke SSN = 06058897728
        if(SSN.compareTo(day+month+year+N1+N2+N3+K1+K2) == 0){
            this.SSN = SSN;
        }
        else{
            throw new IllegalArgumentException("Personnummeret ditt er ikke riktig");
        }
    }

    //Samler gettere under her.

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public Date getBirthday(){
        return this.birthday;
    }

    public char getGender(){
        return this.gender;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getFamilyName(){
        return this.familyName;
    }

    public String getSSN() {
        return this.SSN;
    }


    @Override
    public String toString(){
        return "Fornavnet dit er : " + getFirstName() + ". Etternavnet ditt er: " + getFamilyName() + ". Fulle navnet ditt er : " + getName() +
                ". Mailen din er : " + getEmail() + ". Bursdagen din er : " + getBirthday()+". Personnummeret ditt er "+ getSSN();
    }

    //Samler alle private metoder under her.

    private boolean validLength(String SSN){
        return SSN.length() == 11;
    }

    private String correctCalenderFormat(int num){
        String correctFormat = String.valueOf(num);
        if(correctFormat.length() == 1){
            correctFormat = String.format("%02d", num);
        }
        else if(correctFormat.length() > 2) {
            correctFormat =  correctFormat.substring(2);
        }
        return correctFormat;
    }

    private boolean validN3Condition(String s){
        return ((Integer.parseInt(String.valueOf(s.charAt(8))) % 2 == 0  && getGender() == 'F') || (Integer.parseInt(String.valueOf(s.charAt(8))) % 2 == 1 && getGender() == 'M'));
    }

    private String calculateK1(String s){
        int[] listF = new int[]{3,7,6,1,8,9,4,5,2};
        int VSK1 = 0;
        for (int i = 0; i<listF.length; i++){
            int var = listF[i]*Integer.parseInt(String.valueOf(s.charAt(i)));
            VSK1 +=var;
        }
        //System.out.println(VSK1);
        return String.valueOf(11 - (VSK1 % 11));
    }

    private String calculateK2(String s){
        int[] listG = new int[]{5,4,3,2,7,6,5,4,3,2};
        int VSK2 = 0;
        for (int i = 0; i<listG.length; i++){
            int var = listG[i]*Integer.parseInt(String.valueOf(s.charAt(i)));
            VSK2 +=var;
        }
        return String.valueOf(11 - (VSK2 % 11));
    }

    private boolean validateMail(String mail){
        if(mail.indexOf("@")==-1){
            throw new IllegalArgumentException("Ingen @");
        }
        else {
            return (mail.length() > 0) && (mail.toLowerCase().compareTo(getFirstName().toLowerCase() + "." + getFamilyName().toLowerCase() + mailDomain(mail.toLowerCase()).toLowerCase() + "." + landCode(mail)) == 0);
        }
    }

    private boolean isEmpty(String text){
        return text.equals("");
    }

    private String landCode(String mail){
        String landCodeString = "";
        for (String i : landCode) {
            if (mail.substring(mail.length() - 2).equals(i)) {
                landCodeString = i;
            }
        }
        return landCodeString;
    }

    private String mailDomain(String email){
        return email.substring(getFirstName().length()+getFamilyName().length()+1,email.length()-3);
    }

    private boolean validateFirstNameLength(String name){
        return (name.substring(0,name.indexOf(" ")).trim().length()>2);
    }

    private boolean validateLastNameLength(String name){
        return name.substring(name.indexOf(" ")+1).trim().length()>2;
    }

    private boolean containsDigits(String text){
        if(text=="" || text == "\0") {
            return false;
        }
        else {
            for (char i : text.toCharArray()){
                if(Character.isDigit(i)){
                    return true;
                }
            }
            return false;
        }
    }

    //Fjerner dobbelt mellomrom.
    private String deleteSpaceInName(String fullName){
        return fullName.replaceAll("( +)"," ").trim();
    }

    private boolean validateGenderNotation(char gender) {
        if (gender == 'M' || gender == 'F' || gender == '\0') {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean validateBirthday(Date birthday){
        Date currentDate = new Date();
        return currentDate.compareTo(birthday)>0;
    }


}
