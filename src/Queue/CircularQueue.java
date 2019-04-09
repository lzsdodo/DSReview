package Queue;

public class CircularQueue implements MyQueue {

    private Object[] list;
    private int      cap;
    private int      head;
    private int      tail; // without object at list[tail]

    public CircularQueue(int cap) {
        this.list = new Object[cap + 1];
        this.cap  = cap + 1;
        this.head = 0;
        this.tail = 0;
    }

    public CircularQueue() {
        this(10);
    }

    @Override
    public boolean offer(Object obj) {
        if ((tail + 1) % cap == head) return false;
        list[tail] = obj;
        tail = (tail + 1) % cap;
        return true;
    }

    @Override
    public Object poll() {
        if (head == tail) return null;
        Object rtn = list[head++];
        head %= cap;
        return rtn;
    }

    @Override
    public Object peek() {
        if (head == tail) return null;
        return list[head];
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    @Override
    public int size() {
        return (cap + tail - head) % cap;
    }

    @Override
    public String toString() {
        if (empty()) return null;
        StringBuilder buf = new StringBuilder();
        int idx = head;
        for (int i = 0; i < size(); i++) {
            buf.append("->");
            buf.append(list[idx++].toString());
            idx %= cap;
        }
        return buf.substring(2);
    }
}
