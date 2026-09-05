public class VisitHistory {
    // Node Inner Class
    class Node {
        Visit data;
        Node next;
        Node(Visit data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // First node of the list

    // 1. ADD - Add a new visit to the end of the list
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("✅ New visit added to patient's history.");
    }

    // 2. REMOVE - Remove a visit by Visit ID
    public boolean removeVisit(String visitId) {
        if (head == null) {
            System.out.println("⚠️ Visit history is empty.");
            return false;
        }

        // If the head itself holds the visitId
        if (head.data.getVisitId().equals(visitId)) {
            head = head.next;
            System.out.println("✅ Visit " + visitId + " removed successfully.");
            return true;
        }

        // Search for the visit in the rest of the list
        Node current = head;
        while (current.next != null && !current.next.data.getVisitId().equals(visitId)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("❌ Visit ID " + visitId + " not found in history.");
            return false;
        }

        current.next = current.next.next;
        System.out.println("✅ Visit " + visitId + " removed successfully.");
        return true;
    }

    // 3. SEARCH - Find a visit by Visit ID
    public Visit searchVisit(String visitId) {
        Node current = head;
        while (current != null) {
            if (current.data.getVisitId().equals(visitId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // 4. DISPLAY - Show all visits in the patient's history
    public void displayHistory() {
        if (head == null) {
            System.out.println("⚠️ No visit history found for this patient.");
            return;
        }
        System.out.println("\n--- Patient Visit History (Singly Linked List) ---");
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.data);
            current = current.next;
            count++;
        }
        System.out.println("Total Visits: " + (count - 1));
    }
}