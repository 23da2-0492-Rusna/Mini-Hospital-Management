import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== TASK 1: PATIENT BST MANAGEMENT ===");
        do {
            System.out.println("\n1. Insert Patient");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Delete Patient by ID");
            System.out.println("4. Display All (Inorder)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Contact: "); String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: "); String condition = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, condition));
                    System.out.println("✅ Patient inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int sId = sc.nextInt();
                    Patient found = bst.search(sId);
                    if (found != null) System.out.println("✅ Found: " + found);
                    else System.out.println("❌ 2Patient not found!");
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int dId = sc.nextInt();
                    bst.delete(dId);
                    System.out.println("✅ Deletion attempted.");
                    break;

                case 4:
                    bst.inorder();
                    break;

                case 5:
                    System.out.println("Exiting Task 1...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}