public class Stack {
    private TreatmentRecord[] stack;
    private int top;        // Index of the top element
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new TreatmentRecord[capacity];
        top = -1; // -1 means stack is empty
    }

    // 1. PUSH - Add a completed treatment record
    public void push(TreatmentRecord record) {
        if (isFull()) {
            System.out.println("⚠️ Treatment History Stack is FULL!");
            return;
        }
        stack[++top] = record;
        System.out.println("✅ Treatment record pushed to Stack.");
    }

    // 2. POP - Remove the most recent treatment record (LIFO)
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("⚠️ Treatment History Stack is EMPTY! No records to pop.");
            return null;
        }
        TreatmentRecord record = stack[top--];
        System.out.println("🗑️ Popped (Removed) most recent treatment: " + record);
        return record;
    }

    // 3. DISPLAY - Show all treatment records (Top to Bottom)
    public void display() {
        if (isEmpty()) {
            System.out.println("⚠️ Treatment History Stack is EMPTY.");
            return;
        }
        System.out.println("\n--- Treatment History (Stack - LIFO) ---");
        System.out.println("Top ->");
        for (int i = top; i >= 0; i--) {
            System.out.println("  " + stack[i]);
        }
        System.out.println("<- Bottom");
        System.out.println("Total records: " + (top + 1));
    }

    // Helper methods
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}