public class SavingsAccount extends BankAccount {
    private final double minimumBalance=500.0; //Minimum Balance restriction
    public SavingsAccount(int accountNumber,String holderName){
        super(accountNumber,holderName);
    }
    //Deposit simply adds amount to balance
    @Override
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited "+amount+ " Rs to Saving Accounts. ");
    }
    //Withdraw checks minimum balance constraint before subtracting amount
    @Override
    public boolean withdraw(double amount){
        if(balance-amount>=minimumBalance){
            balance-=amount;
            System.out.println("Withdraw "+amount+" Rs from Savings Account.");
            return true;
        }else{
            System.out.println("Withdrawal failed! Insufficient balance for Savings Account.");
            return false;
        }
    }
}
