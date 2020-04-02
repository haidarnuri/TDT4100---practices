import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings("all")
public class BikeRentalTest extends TestCase{
		
	GeoLocation loc1 = new GeoLocation(2,5);	
	Bike bike1 = new Bike(loc1);
	Bike bike2 = new Bike(loc1);
	Bike bike3 = new Bike(loc1);
	Bike bike4 = new Bike(loc1);
	BikeRental obj1=new BikeRental();
	
	public void setUp(){
		obj1.clearAll();
		obj1.add(bike1);		
		obj1.add(bike2);		
		obj1.add(bike3);		
		obj1.add(bike4);		
	}
		
	@Test
	public void testingGetRentedBikes_testingWith_gettingRentedBikesOrErrors(){
		bike1.setRenter(null);
		BikeRental obj2 = obj1;
		obj2.remove(bike1);
		assertEqual(obj1.getRentedBikes(),obj2.getAllBikes());
	}
	//Man kan skrive videre for andre tilfeller også. 	
}

// Oppgave 5b
7/*
Oftere er det greier å teste gettere, der man kun kan bruke assertEqual som sammenligner to objekter. 

Det er en del metoder og data innbakt i rentBike. Det gjør at man må teste for ulike scenarioer, og test om unntakene fungerer osv. 

*/