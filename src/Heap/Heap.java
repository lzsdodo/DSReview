package Heap;


public class Heap {

    // Based on array

    private int[] arr;   // index start from 1
    private int   cap;   // Max storage size
    private int   size;  // # of element in Heap

    public Heap(int capacity) {
        arr = new int[capacity + 1];
        cap = capacity;
        size = 0;
    }

    public void insert(int data) {
        if (size >= cap) expand(); // FULL
        size++;
        arr[size] = data;
        int i = size;
        while (i/2 > 0 && arr[i] > arr[i/2]) {
            // Construct heap from bottom to Top
            swap(arr, i, i/2);
            i = i/2;
        }
    }

    public void removeTop() {
        if (size == 0) return; // EMPTY
        arr[1] = arr[size];
        size--;
        heapify(arr, size, 1);
    }

    public void offer(int data) {
        insert(data);
    }

    public int poll() {
        if (size == 0) return Integer.MIN_VALUE;
        int top = arr[1];
        removeTop();
        return top;
    }

    private void heapify(int[] arr, int n, int i) {
        // FROM TOP TO BOTTOM
        while (true) {
            int maxPos = i;
            if (i*2 <= n && arr[i] < arr[i*2]) maxPos = i*2;
            if (i*2+1 <= n && arr[maxPos] < arr[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private void expand() {
        int[] newArr = new int[cap * 2];
        for (int i = 0; i < size; i++)
            newArr[i] = arr[i];
        this.arr = newArr;
        this.cap = newArr.length;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    private void buildHeap(int[] arr, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }

    public void sort(int[] arr, int n) {
        buildHeap(arr, n);
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            k--;
            heapify(arr, k, 1);
        }
    }

}
