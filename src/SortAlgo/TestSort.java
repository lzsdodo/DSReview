package SortAlgo;

import java.util.Arrays;

import static java.lang.System.in;
import static java.lang.System.out;

public class TestSort {

    public static void main(String[] args) {
        out.println("Test sorting");

        int[] data = new int[]{9, 3, 6, 10, 29, 1, 4, 2, 5, 13, 43, 22, 5, 12};
        out.println("Original:       " + Arrays.toString(data));

        out.println("Bubble Sort:    " + Arrays.toString(
                        SortAlgo.bubbleSort(Arrays.copyOf(data, data.length))));

        out.println("Insertion Sort: " + Arrays.toString(
                SortAlgo.insertionSort(Arrays.copyOf(data, data.length))));

        out.println("Selection Sort: " + Arrays.toString(
                SortAlgo.selectionSort(Arrays.copyOf(data, data.length))));

        int[] msArr = Arrays.copyOf(data, data.length);
        SortAlgo.mergeSort(msArr);
        out.println("Merge Sort:     " + Arrays.toString(msArr));

        int[] qsArr = Arrays.copyOf(data, data.length);
        SortAlgo.quickSort(qsArr);
        out.println("Quick Sort:     " + Arrays.toString(qsArr));

    }

}
