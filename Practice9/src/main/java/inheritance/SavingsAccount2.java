package inheritance;

public class SavingsAccount2 extends AbstractAccount {
    private int withdrawals;
    private double fee;

    public SavingsAccount2(int withdrawals, double fee) {
        this.withdrawals=withdrawals;
        this.fee=fee;
    }

    @Override
    public void withdraw(double amount) {
        if(this.withdrawals<=0){
            super.withdraw(amount+this.fee);
        }else{super.withdraw(amount);}
    }

    @Override
    void internalWithdraw(double amount) {
        if(amount>getBalance()){
            throw new IllegalStateException("You can not withdrawal this amount of money!");
        }
        this.withdrawals-=1;
    }
}
