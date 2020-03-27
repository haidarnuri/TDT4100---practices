package inheritance;

public class BSU extends SavingsAccount {
    private double maximumAmountSaving;
    private double balanceOFTheYear;

    BSU(double interest, double maximumAmountSaving) {
        super(interest);
        this.maximumAmountSaving=maximumAmountSaving;
    }

    @Override
    public void withdraw(double amount) {
        if(this.balanceOFTheYear<amount){
            throw new IllegalStateException("Can not withdraw this amount");
        }
        super.withdraw(amount);
        this.balanceOFTheYear-=amount;
    }

    @Override
    public void deposit(double amount) {
        if(checkLegalBSUAmount(amount)){
            throw new IllegalStateException("You can not deposit more than 25000 kr");
        }
        super.deposit(amount);
        this.balanceOFTheYear+=amount;
    }

    public double getTaxDeduction(){
        return this.balanceOFTheYear*0.2;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.balanceOFTheYear=0;
    }

    private boolean checkLegalBSUAmount(double amount){
        return this.balanceOFTheYear+amount>this.maximumAmountSaving;
    }

}
