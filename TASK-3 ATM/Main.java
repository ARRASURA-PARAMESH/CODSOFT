//@Arrasura Paramesh
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        if (bankAccount == null) {
            System.out.println("Please set up your bank account first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayOptions();
            System.out.print("Select an option (1/2/3/4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrew " + withdrawAmount + ". New balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed. Please check your input or balance.");
                    }
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.deposit(depositAmount)) {
                        System.out.println("Deposited " + depositAmount + ". New balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Deposit failed. Please check your input.");
                    }
                    break;
                case "3":
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your balance is: " + balance);
                    break;
                case "4":
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM();
        atm.setBankAccount(userAccount);
        atm.run();
    }
}
