import java.io.*;
import java.util.*;

public class LoginSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Login System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    static void register() {
        try {
            FileWriter fw = new FileWriter("users.txt", true);

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            fw.write(username + "," + password + "\n");
            fw.close();

            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }

    static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean found = false;

        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                String[] parts = data.split(",");

                if (parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }

            fileScanner.close();

            if (found) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No users registered yet!");
        }
    }
}