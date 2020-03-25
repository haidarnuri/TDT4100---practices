package inheritance;

public abstract class AbstractAccount {
    private double balance;

    AbstractAccount(){
        this.balance=0;
    }

    public void deposit(double temp){

    }

    public void withdraw(double temp){

    }

    abstract void internalWithdraw(double temp);

    public double getBalance(){
        return 0;
    }

}
