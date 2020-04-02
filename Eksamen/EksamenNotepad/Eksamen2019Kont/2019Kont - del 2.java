//Oppgave 2a
/*
Denne informasjonen kan være greit å lagre i en ny klasse. Dette kan være en klasse som lagrer infoen, 
slik at det er lett i etterkant å skrive ut en kvittering. Forlengelse av leie, kan være greit å lagre i 
BikeRental klassen, men beregning av gebyrer kan være greit å ha i egen klasse.  
Støtte for å forlenge tiden kan man gjerne ha i Bike klassen, siden det er klassen som allerede støtter start 
slutt av leie. 

*/
class BikePayment{
	private double rentAmount =0;
	
	public BikePayment(){} 
	
	public void setRentAmount(LocalDateTime now, LocalDateTime returnTime){
		double timeDiff = getTimeDifference(now,returnTime);
		this.rentAmount+=10*getTimeDifference(this.startTimeRent,this.returnTimeRent);
	}
	
	public void paymentForExtension(){
		this.rentAmount+=5;
	}
	
	public void extraPaymentForLateDeliveryOrExtension(){
		this.rentAmount+=10;
	}
	
	public void eraseAmount(){
		this.rentAmount=0;
	}
	
	public double getRentAmount(){
		return this.rentAmount;
	}
	
	private double getTimeDifference(LocalDateTime now, LocalDateTime after){
		Period period = Period.between(after, now);
		double timeDiff = period.getHours();
		return timeDiff;
	}
}

class BikeTimeSchedule{
	private LocalDateTime startTime=null;
	private LocalDateTime expectedReturnTime=null;
	private LocalDateTime startExtendedTimer=null;
	private LocalDateTime expectedExtendedReturnTime=null;
	private LocalDateTime returnTime=null;
	
	public BikeTimeSchedule(){}
	
	public void startTimer(LocalDateTime startTime, LocalDateTime expectedReturnTime){
			if(startTime.isAfter(expectedReturnTime)){
				throw new RuntimeException("Return time has to be after the current time");
			}
			this.startTime = now;
			this.expectedReturnTime = expectedReturnTime;
	}
	
	public void startExtendedTimer(LocalDateTime startExtendedTimer, LocalDateTime expectedExtendedReturnTime){
			if(startExtendedTimer.isAfter(expectedExtendedReturnTime)){
				throw new RuntimeException("Return time has to be after the current time");
			}
			this.startExtendedTimer = now;
			this.expectedExtendedReturnTime = expectedExtendedReturnTime;
	}

	public void restartTime(){
		this.startTime=null;
		this.expectedReturnTime=null;
		this.startExtendedTimer=null;
		this.expectedExtendedReturnTime=null;
	}
	
	public LocalDateTime getStartTime(){
		return thie.startTime;
	}
	
	public LocalDateTime getExpectedReturnTime(){
		return this.expectedReturnTime;
	}
	public LocalDateTime getStartExtendedTimer(){
		return this.startExtendedTimer;
	}
	
	public LocalDateTime getExpectedExtendedReturnTime(){
		return this.expectedReturnTime;
	}
	
	public void setReturnTime(LocaleDate returnTime){
		this.returnTime=returnTime;
	}
	public void getReturnTime(){
		return this.returnTime;
	}
	
	public boolean checkIfTimeIsAfterExpectedTime(LocaleDate now){
		if(getExpectedExtendedReturnTime()!=null){
			return now.isAfter(getExpectedExtendedReturnTime());
		}
		else{
			return now.isAfter(getExpectedReturnTime);			
		}
		
	}
	
}