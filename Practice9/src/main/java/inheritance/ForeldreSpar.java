package inheritance;

public class ForeldreSpar extends SavingsAccount {
    private int remainingWithdrawals=0;
    private int legalWithdrawal;

    ForeldreSpar(double interest, int legalWithdrawal) {
        super(interest);
        this.legalWithdrawal=legalWithdrawal;
    }

    @Override
    public void withdraw(double amount) {
        if(getRemainingWithdrawals()==0) {
            throw new IllegalStateException("Can not do any more withdrawals");
        }
        super.withdraw(amount);
        this.remainingWithdrawals+=1;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.remainingWithdrawals=0;
    }

    public int getRemainingWithdrawals(){
        return this.legalWithdrawal-this.remainingWithdrawals;
    }

}
