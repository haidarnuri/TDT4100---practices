package inheritance;

public class CreditAccount extends AbstractAccount {
    private double balance;
    private double creditLine;

    CreditAccount(double creditLine){
        this.creditLine=creditLine;
    }

    @Override
    void internalWithdraw(double temp) {

    }
    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }


}
