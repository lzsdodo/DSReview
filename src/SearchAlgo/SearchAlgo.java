package SearchAlgo;

public class SearchAlgo {

    // Without Repeated numbers
    public static int binarySearchNR(int[] arr, int target) {
        // Return the index of target in sorted array, -1 if target not exist
        return binarySearchNR(arr, 0, arr.length - 1, target);
    }

    public static int binarySearchNR(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid =  low + (high - low) / 2;

            if (target > arr[mid]) {
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
        // variety
        // Return left or right if they ask you to find the insert position
    }

    // With Repeated numbers
    public static int findLowerBound(int[] arr, int target) {
        return findLowerBound(arr, 0 , arr.length - 1, target);
    }

    public static int findLowerBound(int[] arr, int start, int end, int target) {
        int idx = findLastSmaller(arr, start, end, target);
        return arr[idx] == target ? idx : -1;
    }

    public static int findLastSmaller(int[] arr, int target) {
        return findLastSmaller(arr, 0 , arr.length - 1, target);
    }

    public static int findLastSmaller(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (arr[low] == target) return low;
        if (arr[high] == target) return high;
        return arr[low] < target ? low : high;
    }

    public static int findHigherBound(int[] arr, int target) {
        return findHigherBound(arr, 0 ,arr.length - 1, target);
    }

    public static int findHigherBound(int[] arr, int start, int end, int target) {
        int idx = findFirstBigger(arr, start, end, target);
        return arr[idx] == target ? idx : -1;
    }

    public static int findFirstBigger(int[] arr, int target) {
        return findFirstBigger(arr, 0 , arr.length - 1, target);
    }

    public static int findFirstBigger(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        if (arr[high] == target) return high;
        if (arr[low] == target) return low;
        return arr[high] > target ? high : low;
    }

}
