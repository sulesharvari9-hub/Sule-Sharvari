import java.util.Scanner;

// Base class
class Account {
    protected double balance;

    Account(double balance) {
        this.balance = balance;
    }

    void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
}

// Derived class (Inheritance)
class ATM extends Account {
    private int pin = 1234;

    ATM(double balance) {
        super(balance);
    }

    boolean authenticate(int enteredPin) {
        return enteredPin == pin;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(5000); // initial balance

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.authenticate(enteredPin)) {
            System.out.println("Invalid PIN!");
            return;
        }

        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double deposit = sc.nextDouble();
                    atm.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double withdraw = sc.nextDouble();
                    atm.withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}