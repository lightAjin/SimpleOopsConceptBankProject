import java.util.Scanner;
public abstract class BankAccount {
    //Private fileds to enforece encapsulation
    private int accountNumber;
    private String holderName;
    protected double balance;

    //Constructor to initialize account info
    public BankAccount(int accountNumber,String holderName){
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=0.0; //Default Initial Balance
    }
    //Getters provide controlled access to private fields(Encapsulation)
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getHolderName(){
        return holderName;
    }
    public double getBalance() {
        return balance;
    }

    //Abstract Methods forcing subclasses to provide their own implementation
    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    //Common Method to display account details
    public void displayDetails(){
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Holder Name: "+ holderName);
        System.out.println("Balance: "+ balance +" Rs");
    }
}
