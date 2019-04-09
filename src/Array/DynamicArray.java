package Array;

public class DynamicArray {

    private Object[] list;
    private int      cap;
    private int      size;

    public DynamicArray() {
        this.size = 0;
        this.cap  = 10;
        this.list = new Object[10];
    }

    public DynamicArray(int cap) {
        this.size = 0;
        this.cap  = cap;
        this.list = new Object[cap];
    }

    public void add(Object obj) {
        if (size == cap)
            expansion();

        list[size] = obj;
        size++;
    }

    public boolean remove(int index) {
        if (empty() || index >= size) return false;

        if (index == size - 1) {
            list[size-1] = null;
            size--;
            return true;
        }

        for (int i = index; i < size - 1; i++)
            list[i] = list[i+1];
        list[size-1] = null;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public String toString() {
        if (size == 0) return null;
        StringBuffer buf = new StringBuffer();
        for (Object o:list) {
            buf.append(", ");
            buf.append(o);
        }
        return buf.substring(2);
    }

    private void expansion() {
        cap *= 2;
        Object[] newList = new Object[cap];
        int i = 0;
        for (Object o:list) newList[i++] = o;
        list = newList;
    }

}
