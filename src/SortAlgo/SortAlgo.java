package SortAlgo;

public class SortAlgo {

    public static int[] bubbleSort(int[] arr) {
        // In place sort
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        return null;
    }

    public static int[] quickSort(int[] arr) {
        return null;
    }

    public static int[] insertSort(int[] arr) {
        return null;
    }

    public static int[] selectSort(int[] arr) {
        return null;
    }
    
}
