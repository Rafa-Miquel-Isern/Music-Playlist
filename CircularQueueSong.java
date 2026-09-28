import java.util.Random;

public class CircularQueueSong<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Reconstruido: el constructor no aparece en las diapositivas
    public CircularQueueSong(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public Object enqueue(Object data) {
        queue[rear] = data;
        rear = (rear + 1) % capacity;
        return queue;
    }

    public Object dequeue() {
        Object data = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        return data;
    }

    public Object current() {
        return queue[front];
    }

    // Reconstruido: Main usa peek() pero no aparece en las diapositivas
    public Object peek() {
        return queue[front];
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(queue[i]); // Print each element in new line
        }
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            queue[i] = null; // Remove all elements
        }
        front = 0; // Reset front
        rear = 0;  // Reset rear
    }

    public Object next() {
        front = (front + 1) % capacity;
        return queue[front];
    }

    public void printQueue() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(queue[i] + " "); // Print all elements
        }
        System.out.println();
    }

    public Object back() {
        front = (front - 1 + capacity) % capacity;
        return queue[front];
    }

    public void shuffle() {
        Random r = new Random(); // Random generator
        for (int i = 0; i < capacity; i++) {
            int j = r.nextInt(capacity); // Random index
            Object temp = queue[i];      // Swap elements
            queue[i] = queue[j];
            queue[j] = temp;
        }
    }

    public boolean insertAtFirstNull(T data) {
        for (int i = 0; i < capacity; i++) {
            if (queue[i] == null) {
                queue[i] = data;
                return true; // Successfully inserted
            }
        }
        return false; // No null spot found (playlist is full)
    }
}
