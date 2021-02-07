/**
 * 
 */
package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 *
 */
public class Person {


	private Date birthday = new Date();
	private String fullName = "";
	private String email = "";
	private char gender = ' ';
	
	private String[] landCode = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	public Person(Date birthday, String fullName, String email, char gender) {
		setBirthday(birthday); 
		setName(fullName); 
		setEmail(email); 
		setGender(gender);
	}
	
	public Person() {
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		Date tempBirthday = Calendar.getInstance().getTime();
		if(birthday==null || birthday.after(tempBirthday)) {
			throw new IllegalArgumentException("Ikke gyldig bursdag");
		}
		this.birthday = birthday;
	}



	public String getName() {
		return fullName;
	}



	public void setName(String fullName) {
		validateFullName(fullName);
		this.fullName = fullName;
	}

	private void validateFullName(String fullName) {
		if(fullName==null) {
			throw new IllegalArgumentException("Navnet finnes ikke");
		}
		
		if(!fullName.replace(" ", "").matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Navnet kan kun inneholde bokstaver");
		}
		
		if(fullName.indexOf(" ")==-1) {
			throw new IllegalArgumentException("Du må ha mer enn 1 navn");
		}
		
		
		int indexSpace = fullName.indexOf(" ");
		String firstName = fullName.substring(0, indexSpace);
		String lastName = fullName.substring(indexSpace+1);
		
		if(firstName.length()<2 || lastName.length()<2) {
			throw new IllegalArgumentException("Fornavnet og etternavnet må inneholde minst to bokstaver");
		}
		
		if(lastName.indexOf(" ")!=-1) {
			throw new IllegalArgumentException("Du kan ikke ha mellomnavn.");
		}
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		validateEmail(email);
		this.email=email;
		
	}
	
	private void validateEmail(String email) {
		if(email==null) {
			throw new IllegalArgumentException("Mailen finnes ikke");
		}
		
		//Ser etter @ tegnet
		if(email.indexOf("@")==-1) {
			throw new IllegalArgumentException("@ finnes ikke");
		}

		
				
		//Iterere gjennom delen før @
		String mailFirstPart = "";
		String mailLastPart = "";
		int counter =0 ;
		for(String temp:email.split("@")) {
			if(counter==0) {
				mailFirstPart = temp;
			}else {
				mailLastPart=temp;
			}
			counter++;
		}
		
		
		
		if(!mailFirstPart.matches(getName().toLowerCase().replace(" ", "."))){
			throw new IllegalArgumentException("Formatet før @ er ikke riktig.");
		}
		System.out.println("Godkjente mailer er: "+ email);
		
		//Iterer gjennom for å finne de tre siste tegnene på mailen. Eks ".com"
				List<String> landcodeString; 
				Stream<String> stream = Arrays.stream(landCode);
				landcodeString = stream.filter(code -> email.substring(email.length()-2).matches(code))
									   .collect(Collectors.toList());
		
		
		if(!mailLastPart.matches("[a-zA-Z]+"+"\\."+landcodeString.get(0))) {
			throw new IllegalArgumentException("Siste delen er feil");
		}

	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if(gender=='M' || gender=='F' || gender=='\0') {
			this.gender=gender;		
		}else{
			throw new IllegalArgumentException("Kjønnet er feil format");
		}
		
	}
	
	@Override
	public String toString() {
		return 
				"""
				Navnet er: 
				Mailen er: 
				Kjønnet er: 
				Bursdagen er:
				
				""";
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		Person test = new Person();
		test.setName("Haidar Nuri");
		test.setEmail("Haidar.nuri@gmail.no");
		
		
		
	}
	
	
	
}
