package Queue;

public class ArrayQueue implements MyQueue {

    private Object[] arr;
    private int      size;
    private int      cap;
    private int      head;
    private int      tail;

    public ArrayQueue(int cap) {
        this.cap = cap;
        this.size = 0;
        this.head = 0;
        this.tail = 0; // Without obj
        this.arr = new Object[cap];
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public boolean offer(Object obj) {
        if (size == cap) return false;
        if (tail == cap && head > 0) {
            for (int i = head; i < tail; i++) {
                arr[i-head] = arr[i];
            }
            tail -= head;
            head = 0;
        }
        arr[tail] = obj;
        tail++;
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if (size == 0) return null;
        Object rtn = arr[head];
        head++;
        size--;
        if (empty()) {
            head = 0;
            tail = 0;
        }
        return rtn;
    }

    @Override
    public Object peek() {
        if (empty()) return null;
        return arr[head];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return null;
        StringBuilder buf = new StringBuilder();
        for (int i = head; i < tail; i++) {
            buf.append("->");
            buf.append(arr[i]);
        }
        return buf.substring(2);
    }

}
