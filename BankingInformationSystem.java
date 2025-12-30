import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    int accountNumber;
    double balance;

    BankAccount(String name, int accNo) {
        accountHolderName = name;
        accountNumber = accNo;
        balance = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid Deposit Amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully.");
        } else {
            System.out.println("Insufficient Balance or Invalid Amount.");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void displayAccountDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: ₹" + balance);
    }
}

public class BankingInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Banking Information System ===");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
