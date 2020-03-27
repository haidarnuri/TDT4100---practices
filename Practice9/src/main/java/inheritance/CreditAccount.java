package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine=0;
    private double amountAfterBalance = 0;
    private double remainingCredit;

    CreditAccount(double creditLine){
        super();
        this.remainingCredit=creditLine;
        setCreditLine(creditLine);
    }

    @Override
    void internalWithdraw(double amount) {
        amountAfterBalance = getBalance()-amount;
        if(amountAfterBalance<0 && -1*amountAfterBalance>getCreditLine()){
            throw new IllegalStateException("The amount is larger than the credit line can cover");
        }
            this.remainingCredit = getCreditLine() + this.amountAfterBalance;
    }
    public double getCreditLine() {
        return this.creditLine;
    }

    public void setCreditLine(double creditLine) {
        if(creditLine<0){
            throw new IllegalArgumentException("Credit line has do be positive");
        }
        else if(this.remainingCredit<creditLine && getBalance()<0){
            throw new IllegalStateException("You have to set more credit than the amount in your balance");
        }
        this.creditLine=creditLine;
    }


}
