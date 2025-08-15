import java.util.InputMismatchException;
import java.util.Scanner;

public class bankProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Welcome to Java Bank!");
        int accNum = 0;

        // Input validation loop for account number
        while (true) {
            System.out.print("Enter Account Number: ");
            try {
                accNum = sc.nextInt();
                sc.nextLine();  // consume leftover newline
                break; // valid input, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid numeric account number.");
                sc.nextLine(); // clear invalid input
            }
        }
        System.out.print("Enter Account Holder Name/Account Id: ");
        String name=sc.nextLine();

        System.out.print("Enter Account Type (1=SAVINGS , 2=CURRENT):");
        int type= sc.nextInt(); //Read A/c type Selection

        //Instantiate Object dynamically based on user input(Polymorphism in action)
        if(type==1){
            account=new SavingsAccount(accNum,name);
        }else if(type==2){
            account=new CurrentAccount(accNum,name);
        }else{
            System.out.println("Invalid Account Type!");
            sc.close();
            System.exit(0);
        }

        //Menu Driven interaction for various Banking Operations
        while(true){
            System.out.println("<----------------------------------------------------------->");
            System.out.println("MENU");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Show Details");
            System.out.println("4.Exit");
            System.out.print("Choose Option: ");
            int option=sc.nextInt();
            switch(option){
                case 1:
                System.out.print("Enter amount to deposit: ");
                double dep=sc.nextDouble();
                account.deposit(dep);
                break;

                case 2:
                System.out.print("Enter amount to withdraw: ");
                double wd=sc.nextDouble();
                account.withdraw(wd);
                break;

                case 3:
                    account.displayDetails();
                    break;

                case 4:
                    System.out.println("Thank You for Banking with us GoodBye.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Option:Try Again");
            }
        }
    }
}
