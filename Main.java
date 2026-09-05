import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        Queue queue = new Queue(10); // Max 10 patients can wait
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM (Task 1 & 2) ===");
        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Insert Patient (BST)");
            System.out.println("2. Search Patient by ID (BST)");
            System.out.println("3. Delete Patient by ID (BST)");
            System.out.println("4. Display All Patients (BST Inorder)");
            System.out.println("5. Add Patient to Emergency Queue (Enqueue)"); // Task 2
            System.out.println("6. Treat Next Patient (Dequeue)");             // Task 2
            System.out.println("7. Display Emergency Waiting Queue");          // Task 2
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // --- TASK 1: BST Operations ---
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Contact: "); String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: "); String condition = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, condition));
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int sId = sc.nextInt();
                    Patient found = bst.search(sId);
                    if (found != null) System.out.println("✅ Found: " + found);
                    else System.out.println("❌ Patient not found!");
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int dId = sc.nextInt();
                    bst.delete(dId);
                    break;

                case 4:
                    bst.inorder();
                    break;

                // --- TASK 2: Queue Operations ---
                case 5:
                    System.out.print("Enter Patient ID to add to Emergency Queue: ");
                    int qId = sc.nextInt();
                    Patient patientToQueue = bst.search(qId);
                    if (patientToQueue != null) {
                        queue.enqueue(patientToQueue);
                    } else {
                        System.out.println("❌ Patient ID " + qId + " not found in BST! Please register first.");
                    }
                    break;

                case 6:
                    Patient treatedPatient = queue.dequeue();
                    // (Optional: Later we will add this to Stack - Task 3)
                    break;

                case 7:
                    queue.display();
                    break;

                case 8:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}