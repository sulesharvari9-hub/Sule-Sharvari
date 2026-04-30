import java.util.Scanner;

class RestaurantSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] items = {"Burger", "Pizza", "Sandwich", "Cold Drink"};
        int[] prices = {100, 200, 80, 50};

        int choice;
        int total = 0;

        System.out.println("===== Welcome to Restaurant =====");

        do {
            System.out.println("\nMenu:");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - Rs " + prices[i]);
            }
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                int cost = qty * prices[choice - 1];
                total += cost;

                System.out.println("Added " + items[choice - 1] + " x " + qty);
                System.out.println("Cost: Rs " + cost);
            }

        } while (choice != 5);

        System.out.println("\n===== BILL =====");
        System.out.println("Total Amount: Rs " + total);
        System.out.println("Thank You! Visit Again 😊");

        sc.close();
    }
}
