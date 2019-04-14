package SortAlgo;

import java.util.Arrays;

import static java.lang.System.out;

public class TestSort {

    public static void main(String[] args) {
        out.println("Test sorting");

        int[] data = new int[]{9, 3, 6, 10, 29, 1, 4, 2, 5, 13, 43, 22, 5, 12};

        out.println("Bubble Sort: " + Arrays.toString(SortAlgo.bubbleSort(data)));

        out.println("Merge Sort: " + Arrays.toString(SortAlgo.mergeSort(data)));

        out.println("Quick Sort: " + Arrays.toString(SortAlgo.quickSort(data)));

        out.println("Select Sort: " + Arrays.toString(SortAlgo.selectSort(data)));
    }

}
