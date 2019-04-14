package SearchAlgo;

import static java.lang.System.out;

public class TestSearch {

    public static void main(String[] args) {
        out.println("Test Search");

        int[] arr1 = new int[] {1, 2, 3, 4, 5, 5, 6, 9, 10, 12, 13, 22, 29, 43};
        out.println("Range: [0, " + (arr1.length - 1) + "]");

        out.println("Binary Search (first): " + SearchAlgo.bSearchNR(arr1, 1));
        out.println("Binary Search (last): " + SearchAlgo.bSearchNR(arr1, 43));

        out.println("Binary Search (not exist): " + SearchAlgo.bSearchNR(arr1, 11));
        out.println("Binary Search (exist): " + SearchAlgo.bSearchNR(arr1, 12));

        out.println("Binary Search (out of bound): " + SearchAlgo.bSearchNR(arr1, 0));
        out.println("Binary Search (out of bound): " + SearchAlgo.bSearchNR(arr1, 55));

        int[] arr2 = new int[] {1, 1, 2, 3, 3, 3, 5, 5, 5, 5, 6, 7, 7, 8, 8, 9, 9, 9};
        out.println("Range: [0, " + (arr2.length - 1) + "]");

        out.println("First Target (first): " + SearchAlgo.findFirstTarget(arr2, 1));
        out.println("First Target (second): " + SearchAlgo.findFirstTarget(arr2, 2));
        out.println("First Target (last): " + SearchAlgo.findFirstTarget(arr2, 9));

        out.println("First Target (exist): " + SearchAlgo.findFirstTarget(arr2, 3));
        out.println("First Target (exist): " + SearchAlgo.findFirstTarget(arr2, 5));

        out.println("First Target (not exist): " + SearchAlgo.findFirstTarget(arr2, 4));
        out.println("Last Smaller (not exist): " + SearchAlgo.findLastSmaller(arr2, 4));

        out.println("First Target (out of bound): " + SearchAlgo.findFirstTarget(arr2, -1));
        out.println("First Target (out of bound): " + SearchAlgo.findFirstTarget(arr2, 10));


        out.println("Higher Bound (first): " + SearchAlgo.findLastTarget(arr2, 1));
        out.println("Higher Bound (second): " + SearchAlgo.findLastTarget(arr2, 2));
        out.println("Higher Bound (last): " + SearchAlgo.findLastTarget(arr2, 9));

        out.println("Higher Bound (exist): " + SearchAlgo.findLastTarget(arr2, 3));
        out.println("Higher Bound (exist): " + SearchAlgo.findLastTarget(arr2, 5));

        out.println("Higher Bound (not exist): " + SearchAlgo.findLastTarget(arr2, 4));
        out.println("First Bigger (not exist): " + SearchAlgo.findFirstBigger(arr2, 4));

        out.println("Higher Bound (out of bound): " + SearchAlgo.findLastTarget(arr2, -1));
        out.println("Higher Bound (out of bound): " + SearchAlgo.findLastTarget(arr2, 10));
    }

}
