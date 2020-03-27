package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine=0;

    CreditAccount(double creditLine){
        super();
        setCreditLine(creditLine);
    }


    @Override
    void internalWithdraw(double amount) {
        if(this.balance-amount<-getCreditLine()){
            throw new IllegalStateException("This amount is larger than the Credit Line allows");
        }
    }
    public double getCreditLine() {
        return this.creditLine;
    }

    public void setCreditLine(double creditLine) {
        if(creditLine<0){
            throw new IllegalArgumentException("Credit line has do be positive");
        }
        if(this.balance+creditLine<0){
            throw new IllegalStateException("You have to have a larger Credit Line than the balance");
        }
        this.creditLine=creditLine;
    }
}
