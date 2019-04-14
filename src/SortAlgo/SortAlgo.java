package SortAlgo;

import java.util.Random;

public class SortAlgo {

    public static int[] bubbleSort(int[] arr) {
        // 1. In place sort
        // 2. Stability
        // 3. Best: O(n), Worst: O(n^2)
        int len = arr.length;
        if (len <= 1) return arr;

        for (int i = 0; i < len; i++) {
            boolean swapped = false;

            for (int j = 0; j < len - 1; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                    swapped = true;
                }
            }

            if (!swapped) break; // No swap
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        // 1. In place sort
        // 2. Stability
        // 3. Best: O(n), Worst: O(n^2)
        int len = arr.length;
        if (len <= 1) return arr;

        for (int i = 1; i < len; i++) {
            int val = arr[i];
            int j = i - 1;
            // Find out where to insert
            for (; j >= 0; j--) {
                if (val < arr[j])
                    arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = val; // Insert
        }
        return arr;
    }

    public static int[] selectSort(int[] arr) {
        // 1. In place sort
        // 2. Not-Stability
        // 3. Best: O(n), Worst: O(n^2)
        int len = arr.length;
        if (len <= 1) return arr;

        for (int i = 0; i < len - 1; i++) {
            int min = arr[i];
            int minIdx = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            // Swap
            arr[minIdx] = arr[i];
            arr[i] = min;
        }

        return arr;
    }

    public static void mergeSort(int[] arr) {
        // 1. Not in place sort
        // 2. Not-Stability
        // 3. Time-Avg: O(nlogn), Space: O(n)
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            // DaC
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            // Merge
            mergeArr(arr, low, mid, high);
        }
    }

    public static void mergeArr(int[] arr, int low, int mid, int high) {
        int[] sortedArr = new int[high - low + 1];
        int k = 0, idx1 = low, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1] < arr[idx2])
                sortedArr[k++] = arr[idx1++];
            else
                sortedArr[k++] = arr[idx2++];
        }

        while (idx1 <= mid) {
            sortedArr[k++] = arr[idx1++];
        }

        while (idx2 <= high) {
            sortedArr[k++] = arr[idx2++];
        }

        for (int i=low, j=0; i<=high; i++, j++) {
            arr[i] = sortedArr[j];
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int divIdx = partition(arr, low, high);
            quickSort(arr, low, divIdx - 1);
            quickSort(arr, divIdx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Find pivot
        int divIdx = low;       // Divide index

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, divIdx++, j);
            }
        }
        swap(arr, divIdx, high);
        return divIdx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] bucketSort(int[] arr) {
        return null;
    }
}
