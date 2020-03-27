package inheritance;

public class SavingsAccount implements Account{
    private double balance;
    private double interest;

    private double endYearAmount;

    SavingsAccount(double interest){
        this.interest=interest;
        this.balance=0;
    }

    @Override
    public void deposit(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("The amount must be positive.");
        }
        this.balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("The amount must be positive.");
        }
        else if(amount>getBalance()){
            throw new IllegalStateException("The amount can not be larger than the balance.");
        }
        this.balance-=amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public void endYearUpdate(){
        this.endYearAmount=getInterest()*this.balance;
        this.balance+=this.endYearAmount;
    }

    private double getInterest() {
        return interest;
    }

    public double getEndYearAmount() {
        return endYearAmount;
    }

}
