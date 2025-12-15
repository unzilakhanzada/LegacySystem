import java.util.ArrayList;
import java.util.Scanner;

public class SmellyCodeExample {

    // Global mutable state (Code smell)
    static ArrayList<String> data = new ArrayList<>();

    // Hard-coded credentials (Security smell)
    static String adminPassword = "12345";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // God class smell: Too much responsibility in main
        while (true) {
            System.out.println("1. Add data");
            System.out.println("2. Remove data");
            System.out.println("3. Print data");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                addData(sc);
            } else if (choice == 2) {
                removeData(sc);
            } else if (choice == 3) {
                printData();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }

    // Long method (Code smell)
    static void addData(Scanner sc) {
        System.out.print("Enter data: ");
        String input = sc.next();
        data.add(input);
        System.out.println("Data added!");

        // Duplicate code smell
        System.out.println("Current data size: " + data.size());
        System.out.println("Current data size: " + data.size());
    }

    static void removeData(Scanner sc) {
        System.out.print("Enter index to remove: ");
        int index = sc.nextInt();
        if (index >= 0 && index < data.size()) {
            data.remove(index);
            System.out.println("Removed successfully");
        } else {
            System.out.println("Index out of bounds");
        }

        // Empty catch block (Code smell)
        try {
            int x = 10 / 0;
        } catch (Exception e) {
        }
    }

    static void printData() {
        // Hard-coded loop limit (Code smell)
        for (int i = 0; i < 100; i++) {
            if (i < data.size()) {
                System.out.println(data.get(i));
            }
        }
    }
}
