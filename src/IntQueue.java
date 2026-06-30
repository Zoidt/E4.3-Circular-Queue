public class IntQueue {
    private int[] elements;
    private int front;
    private int rear;
    private boolean empty;

    public IntQueue(int capacity) {
        this.elements = new int[capacity];
        front = rear = elements.length - 1;
        empty = true;
    }

    /**
     * @param i int to put in queue
     * @throws QueueOverflowException s
     */
    // TODO: Implement enqueue
    public void enqueue(int i) throws QueueOverflowException {
        // check if array is full
        if(isFull())
            throw new QueueOverflowException();

        // Update rear and add our element to the new rear position
        rear = (rear + 1) % this.elements.length;
        elements[rear] = i;

        // Mark queue as not empty
        if (empty)
            empty = false;
    }

    // TODO: Implement dequeue
    /**
     * @throws QueueUnderflowException
     */
    public int dequeue() {
        // Check if its empty, if empty throw
        if (isEmpty())
            throw new QueueUnderflowException();

        // Update front as we did with our rear
        front = (front + 1) % elements.length;

        // if we reach rear, queue is empty
        if (front == rear)
            empty = true;

        return elements[front];
    }

    public boolean isFull() {
        return !empty && rear == front;
    }
    public boolean isEmpty() {

        return empty; // TODO: CHECK THIS!!
    }

    // Checks the first element to be dequeue
    public int peek() {
        int nextIndex = (front + 1) % elements.length;
       return elements[nextIndex];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("FRONT --> [");
        int currFront = front;
        boolean first = true;

        // loop through queue
        while (currFront!= rear){
            currFront = (currFront + 1) % elements.length;

            if (first){
                sb.append(elements[currFront]);
                first = false;}
            else{
                sb.append(", ");
                sb.append(elements[currFront]);
            }
            // if text is not first, then prefix the ,
        }

        sb.append("] <-- REAR");

        return sb.toString();
    }
}
