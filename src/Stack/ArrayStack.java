package Stack;

public class ArrayStack implements MyStack {

    private Object[] arr;
    private int      cap;
    private int      idx;

    public ArrayStack(int n) {
        this.arr = new String[n];
        this.cap   = n;
        this.idx   = -1;
    }

    public ArrayStack() { this(10); }

    @Override
    public void push(Object e) {
        idx++;
        if (idx == cap) expansion();
        arr[idx] = e;
    }

    @Override
    public Object pop() {
        if (idx == -1) return null;
        idx--;
        return arr[idx+1];
    }

    @Override
    public Object peek() {
        if (idx == -1) return null;
        return arr[idx];
    }

    @Override
    public boolean empty() {
        return idx == -1;
    }

    @Override
    public int size() { return idx+1; }

    public int cap() { return cap; }

    private void expansion() {
        cap *= 2;
        Object[] newArr = new Object[cap];
        int i = 0;
        for (Object s:arr) newArr[i++] = s;
        arr = newArr;
    }
}
