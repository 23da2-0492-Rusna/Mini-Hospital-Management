public class BST {
    class Node {
        Patient patient;
        Node left, right;
        Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }

    private Node root;

    // Insert
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }
    private Node insertRec(Node root, Patient patient) {
        if (root == null) return new Node(patient);
        if (patient.getPatientId() < root.patient.getPatientId())
            root.left = insertRec(root.left, patient);
        else if (patient.getPatientId() > root.patient.getPatientId())
            root.right = insertRec(root.right, patient);
        else
            System.out.println("⚠️ Patient ID " + patient.getPatientId() + " already exists!");
        return root;
    }

    // Search
    public Patient search(int id) {
        return searchRec(root, id);
    }
    private Patient searchRec(Node root, int id) {
        if (root == null || root.patient.getPatientId() == id)
            return (root == null) ? null : root.patient;
        if (id < root.patient.getPatientId())
            return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    // Inorder Display
    public void inorder() {
        System.out.println("\n--- Patients in Ascending Order (ID) ---");
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }

    // Delete
    public void delete(int id) {
        root = deleteRec(root, id);
    }
    private Node deleteRec(Node root, int id) {
        if (root == null) {
            System.out.println("❌ Patient ID " + id + " not found!");
            return null;
        }
        if (id < root.patient.getPatientId())
            root.left = deleteRec(root.left, id);
        else if (id > root.patient.getPatientId())
            root.right = deleteRec(root.right, id);
        else {
            // Case 1: Leaf
            if (root.left == null && root.right == null) return null;
            // Case 2: One child
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // Case 3: Two children (Find min in right subtree)
            else {
                Node minNode = findMin(root.right);
                root.patient = minNode.patient;
                root.right = deleteRec(root.right, minNode.patient.getPatientId());
            }
        }
        return root;
    }
    private Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }
}