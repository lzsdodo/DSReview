package Array;

public class OrderedArray {

    private int[] list;
    private int   cap;
    private int   size;

    public OrderedArray(int cap) {
        this.list = new int[cap];
        this.cap  = cap;
        this.size = 0;
    }


    public boolean add(int n) {
        if (size == cap) return false;
        if (size == 0 || n > list[size-1]) {
            list[size++] = n;
            return true;
        }

        int idx = binarySearch(n);
        for (int i = size; i > idx; i--)
            list[i] = list[i-1];
        list[idx] = n;
        size++;
        return true;
    }

    public boolean update(int index, int n) {
        if (index < 0 || index >= size) return false;
        remove(index);
        add(n);
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++)
                list[i] = list[i+1];
        }
        size--;
        return true;
    }

    private int binarySearch(int n) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == n) return mid;
            if (list[mid] < n) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public int size() { return size; }

    public String toString() {
        if (size == 0) return null;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < size; i++) {
            buf.append(", ");
            buf.append(list[i]);
        }
        return buf.substring(2);
    }

}
