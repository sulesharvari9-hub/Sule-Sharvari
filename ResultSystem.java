import java.util.*;

class Student {
    int rollNo;
    String name;
    int m1, m2, m3;
    int total;
    double percentage;
    String result;

    Student(int rollNo, String name, int m1, int m2, int m3) {
        this.rollNo = rollNo;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

        calculateResult();
    }

    void calculateResult() {
        total = m1 + m2 + m3;
        percentage = total / 3.0;

        if (m1 < 35 || m2 < 35 || m3 < 35) {
            result = "Fail";
        } else {
            result = "Pass";
        }
    }

    void display() {
        System.out.println("\nRoll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage);
        System.out.println("Result: " + result);
    }
}

public class ResultSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Results");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks for Subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter marks for Subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter marks for Subject 3: ");
        int m3 = sc.nextInt();

        students.add(new Student(roll, name, m1, m2, m3));
        System.out.println("Student added successfully!");
    }

    static void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found!");
    }
}