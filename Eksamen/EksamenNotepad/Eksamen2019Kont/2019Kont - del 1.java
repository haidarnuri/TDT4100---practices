//Oppgave 1 a
/*
Fordelene med å kode slik at instansene ikke kan endres er at man ikke kan manipulere instansene senere. 
Hvis det er viktig at de er fast, så er det nyttig å bruke ord som "final". 

*/

//Oppgave 1b

public class GeoLocation {
 
    private final double latitude;
    private final double longitude;
 
    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
 
    public double getLatitude() {
        return latitude;
    }
 
    public double getLongitude() {
        return longitude;
    }
 
    public double distance(GeoLocation other) {
        return distance(this.latitude,this.longitude,other.getLatitude,other.getLongitude);
    }
 
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        // return null er bare tull, den har egentlig beregning her.
        return null; // Denne kompliserte beregningen er utelatt.
        // Anta at den er implementert.
    }
}

//Oppgave 1C - Bike
public class Bike {
 
    private GeoLocation location;
    private Person renter;
	private double amountRent;
	private double numberOfExtensions=0;
	private LocaleDate returnTime=null;
	
	public Bike(GeoLocation location){
		this.location=location;
	}
	public Person getRenter(){
		return this.renter;
	}
	
	public void setRenter(Person renter){
		this.renter=renter;
	}
	
	public GeoLocation getLocation(){
		return this.location;
	}
	public void setLocation(GeoLocation location){
		this.location=location;
	}
	public void setAmountRent(double amount){
		this.amountRent=amount;
	}
	public double getAmountRent(){
		return this.amountRent;
	}
	public void increaseExtensionNumber(){
		this.numberOfExtensions+=1;
	}
	public void getExtensionNumber(){
		return this.numberOfExtensions;
	}
	
	public void eraseNumberOfExtensions(){
		this.numberOfExtensions=0;
	}
	
}

//Oppgave 1D - BikeRental
public BikeRental{
	//Her oppretter jeg instansene for denne klassen. 
	//allTheStations inneholder alle sykkelstasjonene i byen, mens allTheBikes er alle syklene i byen. 
	private Collection<GeoLocation> allTheStations = new ArrayList<GeoLocation>();
	private Collection<Bike> allTheBikes = new ArrayList<Bike>();
	
	/*
	I denne klassen burde man kunne legge til og ta bort sykkelstasjoner og sykler. 
	*/
	
	public void addBike(Bike bike, GeoLocation location){
		if(GeoLocation.contains(location)){
			bike.setLocation(location);
		}
		else{
			throw new IllegalArgumetException("This station does not exist");
		}
		allTheBikes.add(bike);
	}
	
	public void removeBike(Bike bike){
		allTheBikes.remove(bike);
	}
	
	public void addStation(GeoLocation location){
		if(location!=null){
			allTheStations.add(location);
		}else{
			throw new IllegalArgumetException("This location is uknown!");
		}		
	}
	
	public void removeStation(GeoLocation location){
		allTheBikes.remove(location);
	}
//Oppgave 1e
	private int countAvailableBikesNearby(GeoLocation location, double distance) {
		int numberBikes=0;
		if(checkIfDistanceOrLocationIsInvalid(location,distance)){
			throw new IllegalArgumetException("This location or distance is invalid");
		}
        for(Bike bike:allTheBikes){
			if(location.distance(bike.getLocation())<distance){
				numberBikes++;
			}
		}
		return numberBikes;
    }
	
	private GeoLocation getStationNearby(Bike bike, double maxDistance) {
        if(checkIfDistanceOrLocationIsInvalid(bike.getLocation(),maxDistance)){
			throw new IllegalArgumetException("This location or distance is invalid");
		}
		int minDistance=maxDistance;
		GeoLocation nearbyStation = null;
		for(GeoLocation station:allTheStations){
			if(station.distance(bike.getLocation())<minDistance){
				minDistance = station.distance(bike.getLocation());
				nearbyStation = station;
			}
		}
		return nearbyStation;			
    }
	
	privat boolean checkIfDistanceOrLocationIsInvalid(GeoLocation location, double distance){
		return (location==null && distance<0);
	}
	
	//Antar at dersom en sykkel har en renter så er den ikke null. Null = ukjent renter, altså ingen renter. 
	private Collection<Bike> getRentedBikes() {
        Collection<Bike> rentedBikes = this.allTheBikes;
		for(Bike bike:allTheBikes){
			if(bike.getRenter()==null){
				rentedBikes.remove(bike);
			}
		}
		return rentedBikes;
    }
	
	
	private Collection<Bike> getUnreturnedBikes() {
		Collection<Bike> unreturnedNearbyBikes = getRentedBikes();
		for(Bike bike:unreturnedNearbyBikes){
			if(!this.allTheStations.contains(bike.getLocation())){
				unreturnedNearbyBikes.remove(bike);
			}
		}
		return unreturnedNearbyBikes;
    }
	
	//Lager to objekter som har oversikt over utgiftene og tiden.
	private BikePayment amount = new BikePayment();
	private BikeTimeSchedule timer = new BikeTimeSchedule();
	
	public void rentBike(Person person, Bike bike, LocalDateTime now, LocalDateTime returnTime) {
		if(person==null){
			throw new IllegalArgumetException("This person is uknown");
		}
		if(getRentedBikes().contains(bike)){
			throw new RuntimeException("This bike is currently not available");
		}
		timer.startTimer(now,returnTime);
		bike.setRenter(person);
		amount.setAmountRent(timer.getStartTime(),timer.getExpectedReturnTime());
    }
	
	public void extendRental(Person person, Bike bike, LocalDateTime now, LocalDateTime returnTime) {
		if(!getRentedBikes().contains(bike)){
			throw new RuntimeException("This bike is not rented");
		}
        if(!bike.getRenter().equals(person)){
			throw new RuntimeException("This person is not renting this bike");
		}
		if(timer.checkIfTimeIsAfterExpectedTime(now)){
			amount.extraPaymentForLateDeliveryOrExtension();
		}
		timer.startExtendedTimer(now,returnTime);
		amount.paymentForExtension();
		bike.increaseExtensionNumber();
    }
	
	
    public void returnBike(Person person, Bike bike, LocalDateTime now) {
		if(!getRentedBikes().contains(bike)){
			throw new RuntimeException("This bike is not rented");
		}
		if(getStationNearby(bike,30)==null){
			throw new RuntimeException("There is no station within 30 m");
		}
		timer.setReturnTime(now);
		if(timer.checkIfTimeIsAfterExpectedTime(now)){
			amount.extraPaymentForLateDeliveryOrExtension();
		}
		person.withdraw(amount.getRentAmount());
		printReceipt(person,bike);
		bike.setRenter(null);
		amount.eraseAmount();
		timer.restartTime();
    }
	//Ikke helt fullført del 2, men tror jeg skjønner hva som er feil. 
    public void printReceipt(Person person, Bike bike) {
		System.out.println("Initial rent from "+timer.getStartTime()+" to "+timer.getExpectedReturnTime());
		if(timer.getStartExtendedTimer()!=null){
		System.out.println("Extension "+bike.getNumberOfExtensions()+" from "+timer.getStartExtendedTimer() +
							" to "+timer.getExpectedExtendedReturnTime()+".");
		}
		System.out.println("Bike ");
    }
	
}























