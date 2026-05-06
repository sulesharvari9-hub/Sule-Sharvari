import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class BankSystem {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void createAccount() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        accounts.add(new Account(accNo, name, bal));
        System.out.println("Account created successfully!");
    }

    static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void deposit() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            acc.balance += amt;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdraw() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();

            if (amt <= acc.balance) {
                acc.balance -= amt;
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.println("Name: " + acc.name);
            System.out.println("Balance: Rs " + acc.balance);
        } else {
            System.out.println("Account not found!");
        }
    }
}