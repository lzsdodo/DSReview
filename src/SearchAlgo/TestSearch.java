package SearchAlgo;

import static java.lang.System.out;

public class TestSearch {

    public static void main(String[] args) {
        out.println("Test Search");

        int[] arr1 = new int[] {1, 2, 3, 4, 5, 5, 6, 9, 10, 12, 13, 22, 29, 43};
        out.println("Range: [0, " + (arr1.length - 1) + "]");

        out.println("Binary Search (first): " + SearchAlgo.binarySearchNR(arr1, 1));
        out.println("Binary Search (last): " + SearchAlgo.binarySearchNR(arr1, 43));

        out.println("Binary Search (not exist): " + SearchAlgo.binarySearchNR(arr1, 11));
        out.println("Binary Search (exist): " + SearchAlgo.binarySearchNR(arr1, 12));

        out.println("Binary Search (out of bound): " + SearchAlgo.binarySearchNR(arr1, 0));
        out.println("Binary Search (out of bound): " + SearchAlgo.binarySearchNR(arr1, 55));

        int[] arr2 = new int[] {1, 1, 2, 3, 3, 3, 5, 5, 5, 5, 6, 7, 7, 8, 8, 9, 9, 9};
        out.println("Range: [0, " + (arr2.length - 1) + "]");

        out.println("Lower Bound (first): " + SearchAlgo.findLowerBound(arr2, 1));
        out.println("Lower Bound (second): " + SearchAlgo.findLowerBound(arr2, 2));
        out.println("Lower Bound (last): " + SearchAlgo.findLowerBound(arr2, 9));

        out.println("Lower Bound (exist): " + SearchAlgo.findLowerBound(arr2, 3));
        out.println("Lower Bound (exist): " + SearchAlgo.findLowerBound(arr2, 5));

        out.println("Lower Bound (not exist): " + SearchAlgo.findLowerBound(arr2, 4));
        out.println("Last Smaller (not exist): " + SearchAlgo.findLastSmaller(arr2, 4));

        out.println("Lower Bound (out of bound): " + SearchAlgo.findLowerBound(arr2, -1));
        out.println("Lower Bound (out of bound): " + SearchAlgo.findLowerBound(arr2, 10));


        out.println("Higher Bound (first): " + SearchAlgo.findHigherBound(arr2, 1));
        out.println("Higher Bound (second): " + SearchAlgo.findHigherBound(arr2, 2));
        out.println("Higher Bound (last): " + SearchAlgo.findHigherBound(arr2, 9));

        out.println("Higher Bound (exist): " + SearchAlgo.findHigherBound(arr2, 3));
        out.println("Higher Bound (exist): " + SearchAlgo.findHigherBound(arr2, 5));

        out.println("Higher Bound (not exist): " + SearchAlgo.findHigherBound(arr2, 4));
        out.println("First Bigger (not exist): " + SearchAlgo.findFirstBigger(arr2, 4));

        out.println("Higher Bound (out of bound): " + SearchAlgo.findHigherBound(arr2, -1));
        out.println("Higher Bound (out of bound): " + SearchAlgo.findHigherBound(arr2, 10));
    }

}
