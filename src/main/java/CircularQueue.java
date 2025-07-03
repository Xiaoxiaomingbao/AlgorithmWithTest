public class CircularQueue {
    // 用循环数组实现队列（不带自动扩容机制）
    private final int[] queue;
    private int front, rear, size;  // right 记录第一个空位，left 记录最后一个满位

    /**
     * 构造器
     * @param limit 同时在队列中的元素的最大数量
     */
    public CircularQueue(int limit) {
        queue = new int[limit];
        front = rear = size = 0;
    }

    public boolean enqueue(int item) {
        if (isFull()) {
            return false;
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % queue.length;
        size--;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear + queue.length - 1) % queue.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
