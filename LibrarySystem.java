import java.util.*;

class Book {
    String name;
    boolean isIssued;

    Book(String name) {
        this.name = name;
        this.isIssued = false;
    }
}

public class LibrarySystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter book name: ");
        String name = sc.nextLine();
        books.add(new Book(name));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.name +
                    (b.isIssued ? " (Issued)" : " (Available)"));
        }
    }

    static void issueBook() {
        viewBooks();
        System.out.print("Enter book number to issue: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < books.size()) {
            Book b = books.get(index);
            if (!b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book already issued!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    static void returnBook() {
        viewBooks();
        System.out.print("Enter book number to return: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < books.size()) {
            Book b = books.get(index);
            if (b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Book was not issued!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }
}