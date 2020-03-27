package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine=0;
    private double amountAfterBalance = 0;
    private double remainingCredit;

    CreditAccount(double creditLine){
        super();
        setCreditLine(creditLine);
    }


    @Override
    void internalWithdraw(double amount) {
        if(this.balance-amount<-getCreditLine()){
            throw new IllegalStateException("");
        }
    }
    public double getCreditLine() {
        return this.creditLine;
    }

    public void setCreditLine(double creditLine) {
        System.out.println(creditLine);
        System.out.println(getBalance());
        if(creditLine<0){
            throw new IllegalArgumentException("Credit line has do be positive");
        }
        if(this.balance+creditLine<0){
            throw new IllegalStateException("ddd");
        }
        this.creditLine=creditLine;
    }
}
