package SortAlgo;

public class SortAlgo {

    public static int[] bubbleSort(int[] arr) {
        // 1. In place sort
        // 2. Stability
        // 3. Best: O(n), Worst: O(n^2)
        if (arr.length <= 1) return arr;

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
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
        if (arr.length <= 1) return arr;

        for (int i = 1; i < arr.length; i++) {
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

    public static int[] selectionSort(int[] arr) {
        // 1. In place sort
        // 2. Not-Stability
        // 3. Best: O(n), Worst: O(n^2)
        if (arr.length <= 1) return arr;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
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
        // 1. Not in place sort, Space: O(n)
        // 2. Not-Stability
        // 3. Time-Avg: O(nlogn)
        // BOTTOM TO TOP
        if (arr.length < 2) return;
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
        // 1. In place sort, Space: O(1)
        // 2. Not-Stability
        // 3. Time-Avg: O(nlogn), Worst: O(n^2) depending on the `pivot` value
        // TOP to BOTTOM
        if (arr.length < 2) return;
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

    /*
    private static int findPivot(int[] arr, int low, int high) {
        int nMid = arr[low + ((high - low) / 2)];
        int[] num = new int[]{arr[low], nMid, arr[high]};
        // 3 point median
        if (num[0] > num[1]) swap(num, 0, 1);
        if (num[1] > num[2]) swap(num, 1, 2);
        if (num[0] > num[1]) swap(num, 0, 1);
        return num[1];
    }
    */

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] bucketSort(int[] arr) {
        // Bucket sorting is more suitable for external sorting
        // Like the data is 100GB and the RAM limitation is 1G.
        // O(k * logk) = O(m * k * logk) = O(m * n/m * log(n/m)) = O(n * log(n/m))
        // When n ≈ m => O(n)
        return null;
    }

    public static void countingSort(int[] arr) {
        // A special case of bucket sort
        // Small range and all data are all non-negative number
        // 1. find the range of data
        // 2. record the #
        // 3. build a new arr according to the record

        // 计数排序，a 是数组，n 是数组大小。假设数组中存储的都是非负整数。
        // Code src: https://github.com/wangzheng0822/algo/blob/master/java/13_sorts/CountingSort.java
        if (arr.length <= 1) return;

        // 查找数组中数据的范围
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 申请一个计数数组 c，下标大小 [0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max + 1; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入 c 中
        for (int i = 0; i < arr.length; ++i) {
            c[arr[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组 r，存储排序之后的结果
        int[] r = new int[arr.length];
        // 计算排序的关键步骤了，有点难理解
        for (int i = arr.length - 1; i >= 0; --i) {
            int index = c[arr[i]]-1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        // 将结果拷贝会 a 数组
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = r[i];
        }
    }

    public static int[] radixSort(int[] arr) {
        // e.g. Sort phone number / words / ...
        return null;
    }

}
