package SearchAlgo;

public class SearchAlgo {

    // Without Repeated numbers
    public static int bSearchNR(int[] arr, int target) {
        // Return the index of target in sorted array, -1 if target not exist
        return bSearchNR(arr, 0, arr.length - 1, target);
    }

    public static int bSearchNR(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid =  low + ((high - low) >> 1);

            if (target > arr[mid]) {
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    // Find first target with repeated numbers
    public static int findFirstTarget(int[] arr, int target) {
        return findFirstTarget(arr, 0 , arr.length - 1, target);
    }

    public static int findFirstTarget(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                // Equal, first of arr || first of repeated target
                if ((mid == start) || (arr[mid - 1] != target))
                    return mid;
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int findLastTarget(int[] arr, int target) {
        return findLastTarget(arr, 0 ,arr.length - 1, target);
    }

    public static int findLastTarget(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == end) || (arr[mid + 1] != target))
                    return mid;
                low = mid + 1;
            }
        }

        return -1;
    }


    // Find first elem bigger or equal than >= target
    public static int findFirstBigger(int[] arr, int target) {
        return findFirstBigger(arr, 0 , arr.length - 1, target);
    }

    public static int findFirstBigger(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] >= target) {
                if((mid == start) || (arr[mid - 1] < target))
                    return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int findLastSmaller(int[] arr, int target) {
        return findLastSmaller(arr, 0 , arr.length - 1, target);
    }

    public static int findLastSmaller(int[] arr, int start, int end, int target) {
        int low = start, high = end;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] <= target) {
                if ((mid == end) || (arr[mid + 1] > target))
                    return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
