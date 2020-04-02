//Oppgave del 3

/*
Delegering brukes når man har to eller flere klasser som implementerer samme interface/grensesnitt. 

I dette tilfelle skal vi se på utgiftene, som i mitt tilfelle blir veldig styrt i BikePayment klassen. 

Mitt forlsag er å lage et grensesnitt som bruker mye av de samme metodene som klassen min. 

Eksemple på grensesnitt under:
*/

interface BikePaymentInterface{
	void setRentAmount(LocalDateTime now, LocalDateTime returnTime);
	void paymentForExtension();
	void extraPaymentForLateDeliveryOrExtension();
	double getRentAmount();
}

class BikePayment implements BikePaymentInterface{

	....

}

/*
På denne måten kan alt av regning av utgifter i hovedsak delegeres til BikePayment klassen. Så lenge den delegerende 
implementerer samme grensesnitt, så blir det lettere å delegere arbeid videre til delegatet.
*/

/*
Antar at BikePayment har implementert grensnittet over. Tenker at Person klassen gjør det samme. 
*/

class Person implements BikePaymentInterface(){
	
	BikePayment payment = new BikePayment();
	private double amount = 0;
	
	@Override
	public void setRentAmount(LocalDateTime now, LocalDateTime returnTime){
		this.amount = (payment.setRentAmount(now,returnTime))*0.80; 
	}
	/*
	Jeg prøver kun å demonstrere hvordan dette kan brukes til å gi personlige rabatter eller bonuser. 
	Vi ser at regning for selve avgiften er fortsatt deligert til payment objektet. 
	*/
	
	@Override
	public void paymentForExtension(){
		....
	}
	
	@Override
	public void extraPaymentForLateDeliveryOrExtension(){
		....
	}
	
	public void withdraw(){
		compute(this.amount);		
	}
	
	
}

// oppgave 3c

/*
Man kan opprette en abstrakt klasse som håndterer generell regning for utgifter, eller som tilbyr noen metoder som man kan arve. 
Tenker eksempelvis
*/
public abstract class Payment{
	
	public void withdraw(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Can not withdraw a negative value");
        }
        internalWithdraw(amount);
    }

    abstract void internalWithdraw(double amount);
	abstract void paymentForExtension();

}

/*Dette gjør at folk kan arve egenskaper fra superklassen Payment. Da kan de arve metoden internalWithdraw, 
som gir hvert selskap mulighet til å justere utgifter på egenhånd. 

Dette er bare et eksempel på en metoder som kan brukes i denne klassen. Mulighetene er mange. 

*/




