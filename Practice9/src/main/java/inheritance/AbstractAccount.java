package inheritance;

public abstract class AbstractAccount {
    protected double balance;

    AbstractAccount(){
        this.balance=0;
    }


    public void deposit(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("The amount you deposit must be positive.");
        }
        this.balance+=amount;
    }

    public void withdraw(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Can not withdraw a negative value");
        }
        internalWithdraw(amount);
        this.balance-=amount;
    }

    abstract void internalWithdraw(double amount);

    public double getBalance(){
        return this.balance;
    }

}
