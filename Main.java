import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        Queue queue = new Queue(10);
        Stack stack = new Stack(10);
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM (All Tasks) ===");
        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Insert Patient (BST)");
            System.out.println("2. Search Patient by ID (BST)");
            System.out.println("3. Delete Patient by ID (BST)");
            System.out.println("4. Display All Patients (BST Inorder)");
            System.out.println("5. Add Patient to Emergency Queue (Enqueue)");
            System.out.println("6. Treat Next Patient (Dequeue + Push to Stack)");
            System.out.println("7. Display Emergency Waiting Queue");
            System.out.println("8. Display Treatment History (Stack)");
            System.out.println("9. Pop Last Treatment Record (Stack)");
            System.out.println("---- Task 4: Linked List Operations ----");
            System.out.println("10. Add Visit to Patient History (Linked List)");
            System.out.println("11. Remove Visit from Patient History");
            System.out.println("12. Search Visit in Patient History");
            System.out.println("13. Display Patient Visit History");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // --- TASK 1: BST ---
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

                // --- TASK 2: QUEUE ---
                case 5:
                    System.out.print("Enter Patient ID to add to Emergency Queue: ");
                    int qId = sc.nextInt();
                    Patient patientToQueue = bst.search(qId);
                    if (patientToQueue != null) {
                        queue.enqueue(patientToQueue);
                    } else {
                        System.out.println("❌ Patient ID " + qId + " not found in BST!");
                    }
                    break;

                case 6:
                    Patient treatedPatient = queue.dequeue();
                    if (treatedPatient != null) {
                        System.out.print("Enter Diagnosis for this treatment: ");
                        String diagnosis = sc.nextLine();
                        String date = LocalDate.now().toString();
                        TreatmentRecord record = new TreatmentRecord(treatedPatient, date, diagnosis);
                        stack.push(record);
                    }
                    break;

                case 7:
                    queue.display();
                    break;

                // --- TASK 3: STACK ---
                case 8:
                    stack.display();
                    break;

                case 9:
                    stack.pop();
                    break;

                // --- TASK 4: SINGLY LINKED LIST ---
                case 10:
                    System.out.print("Enter Patient ID to add visit: ");
                    int pIdAdd = sc.nextInt();
                    sc.nextLine();
                    Patient patientAdd = bst.search(pIdAdd);
                    if (patientAdd == null) {
                        System.out.println("❌ Patient not found!");
                        break;
                    }
                    System.out.print("Enter Visit ID: ");
                    String vId = sc.nextLine();
                    System.out.print("Enter Visit Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctor = sc.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diag = sc.nextLine();
                    System.out.print("Enter Treatment Given: ");
                    String treat = sc.nextLine();
                    
                    Visit newVisit = new Visit(vId, date, doctor, diag, treat);
                    patientAdd.getVisitHistory().addVisit(newVisit);
                    break;

                case 11:
                    System.out.print("Enter Patient ID to remove visit: ");
                    int pIdRem = sc.nextInt();
                    sc.nextLine();
                    Patient patientRem = bst.search(pIdRem);
                    if (patientRem == null) {
                        System.out.println("❌ Patient not found!");
                        break;
                    }
                    System.out.print("Enter Visit ID to remove: ");
                    String remId = sc.nextLine();
                    patientRem.getVisitHistory().removeVisit(remId);
                    break;

                case 12:
                    System.out.print("Enter Patient ID to search visit: ");
                    int pIdSearch = sc.nextInt();
                    sc.nextLine();
                    Patient patientSearch = bst.search(pIdSearch);
                    if (patientSearch == null) {
                        System.out.println("❌ Patient not found!");
                        break;
                    }
                    System.out.print("Enter Visit ID to search: ");
                    String searchId = sc.nextLine();
                    Visit foundVisit = patientSearch.getVisitHistory().searchVisit(searchId);
                    if (foundVisit != null) {
                        System.out.println("✅ Visit Found: " + foundVisit);
                    } else {
                        System.out.println("❌ Visit not found.");
                    }
                    break;

                case 13:
                    System.out.print("Enter Patient ID to display history: ");
                    int pIdDisp = sc.nextInt();
                    Patient patientDisp = bst.search(pIdDisp);
                    if (patientDisp == null) {
                        System.out.println("❌ Patient not found!");
                        break;
                    }
                    System.out.println("\n=== Visit History for " + patientDisp.getName() + " (ID: " + patientDisp.getPatientId() + ") ===");
                    patientDisp.getVisitHistory().displayHistory();
                    break;

                case 14:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 14);
        sc.close();
    }
}