package inheritance;

public class DebitAccount extends AbstractAccount {

    DebitAccount(){
        super();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    void internalWithdraw(double amount) {
        if(getBalance()<amount){
            throw new IllegalStateException("Amount can not be larger than the balance");
        }
    }
}