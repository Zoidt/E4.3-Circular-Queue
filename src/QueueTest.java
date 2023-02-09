import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

    public static final int CAPACITY = 20;
    private IntQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new IntQueue(CAPACITY);
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(4);
        assertEquals(4, queue.peek());
        queue.enqueue(5);
        assertEquals(4, queue.peek());
        queue.enqueue(6);
        assertEquals(4, queue.peek());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
    }

    @Test
    public void testQueueOverflow() {
        for (int i = 0; i < CAPACITY; i++) {
            queue.enqueue(i);
		}

		assertThrows(QueueOverflowException.class, () ->  queue.enqueue(1));
    }

    @Test
    public void testQueueUnderflow() {
        assertThrows(QueueUnderflowException.class, () -> queue.dequeue());
    }

	@Test
    public void testCircularQueue() {
        offsetQueue(5);
        for (int i = 0; i < CAPACITY; i++)
            queue.enqueue(i);
        for (int i = 0; i < CAPACITY; i++)
            assertEquals(String.valueOf(i), queue.dequeue());
    }

    @Test
    public void testEmptyAndFull() {

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        // move queue front position
        offsetQueue(5);

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        // fill queue
        for (int i = 0; i < CAPACITY; i++)
            queue.enqueue(i);

        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());

        // empty queue
        for (int i = 0; i < CAPACITY - 1; i++) {
            queue.dequeue();
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
        }
        queue.dequeue();

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

    }

    @Test
    public void testQueueToString() {
        assertEquals("FRONT --> [] <-- REAR", queue.toString());

        queue.enqueue(4);
        assertEquals("FRONT --> [4] <-- REAR", queue.toString());

        queue.enqueue(5);
        assertEquals("FRONT --> [4, 5] <-- REAR", queue.toString());

        queue.enqueue(6);
        assertEquals("FRONT --> [4, 5, 6] <-- REAR", queue.toString());
    }

	/*
     * Shift the front position of the queue.
     */
    private void offsetQueue(int n) {
        for (int i = 0; i < n; i++) {
            queue.enqueue(4);
            queue.dequeue();
        }
    }
}
