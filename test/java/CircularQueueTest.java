import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {
    @Test
    public void testCircularQueue() {
        CircularQueue q = new CircularQueue(10);
        assertTrue(q.isEmpty());
        assertFalse(q.dequeue());
        assertEquals(-1, q.rear());
        assertEquals(-1, q.front());
        for (int i = 1; i <= 10; i++) {
            assertTrue(q.enqueue(i));
            assertEquals(i, q.rear());
            assertEquals(1, q.front());
        }
        assertTrue(q.isFull());
        assertTrue(q.dequeue());
        assertEquals(2, q.front());
        assertEquals(10, q.rear());
        assertTrue(q.enqueue(11));
        assertEquals(2, q.front());
        assertEquals(11, q.rear());
    }
}
