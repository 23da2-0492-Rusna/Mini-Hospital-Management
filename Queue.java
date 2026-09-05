public class Queue {
    private Patient[] queue; // Array to store patients
    private int front;       // Points to the front (first) element
    private int rear;        // Points to the rear (last) element
    private int size;        // Current number of patients in queue
    private int capacity;    // Maximum size of the queue

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // 1. ENQUEUE - Add patient to the waiting list
    public void enqueue(Patient patient) {
        if (isFull()) {
            System.out.println("⚠️ Emergency Queue is FULL! Cannot add more patients.");
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = patient;
        size++;
        System.out.println("✅ " + patient.getName() + " (ID: " + patient.getPatientId() + ") added to Emergency Queue.");
    }

    // 2. DEQUEUE - Remove the next patient for treatment (FIFO)
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("⚠️ Emergency Queue is EMPTY! No patients to treat.");
            return null;
        }
        Patient patient = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("🚨 Doctor is now treating: " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
        return patient;
    }

    // 3. DISPLAY - Show all patients currently waiting
    public void display() {
        if (isEmpty()) {
            System.out.println("⚠️ Emergency Queue is EMPTY.");
            return;
        }
        System.out.print("\n--- Current Emergency Waiting Queue (FIFO) ---\nFront -> ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print("[" + queue[index].getPatientId() + ", " + queue[index].getName() + "] -> ");
        }
        System.out.println("Rear");
        System.out.println("Total Patients waiting: " + size);
    }

    // Helper methods
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}