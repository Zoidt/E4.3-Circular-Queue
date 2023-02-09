public class IntQueue {
    private int[] elements;
    private int front;
    private int rear;
    private boolean empty;

    public IntQueue(int capactiy) {
        this.elements = new int[capactiy];
        front = -1;
        rear = -1;
        empty = false;
    }

    /**
     * @param i int to put in queue
     * @throws QueueOverflowException s
     */
    // TODO: Implement enqueue
    public void enqueue(int i) throws QueueOverflowException {
        // check if array is full
        rear = (rear + 1) % elements.length;
        elements[rear] = i;
        empty = false;

        /* Another example of what happens above
         * if (rear == elements.length - 1)
         * rear = -1
         */
    }

    // TODO: Implement dequeue
    public int dequeue() {
        front = (front + 1) % elements.length;
        int element = elements[front];

        // Flag that array is empty
        if(front == rear)
            empty = true;

        return element;
    }

    public boolean isFull() {
        return !empty && rear == front;
    }
    public boolean isEmpty() {

        return empty; // TODO: CHECK THIS!!
    }


}
