// CurrentAccount extends BankAccount, allows overdraft (negative balance) up to limit
class CurrentAccount extends BankAccount {
    private final double overdraftLimit = 10000.0;  // Overdraft allowed limit

    public CurrentAccount(int accountNumber, String holderName) {
        super(accountNumber, holderName);
    }

    // Deposit adds amount to current balance
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " Rs to Current Account.");
    }

    // Withdraw can exceed balance up to overdraft limit
    @Override
    public boolean withdraw(double amount) {
        if(balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " Rs from Current Account (Overdraft allowed).");
            return true;
        } else {
            System.out.println("Withdrawal failed! Overdraft limit exceeded.");
            return false;
        }
    }
}
