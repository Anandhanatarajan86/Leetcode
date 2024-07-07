package arrays.binarysearch;

public class PeakIndex {
    public int peakIndexInMountainArray(int[] arr) {
        return modifiedBinarySearch(arr);

    }

    // Modified Binary Search continue searching till condition violates
    private int modifiedBinarySearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < arr[middle + 1]) { // go right to find peak index
                low = middle + 1;
            } else {
                high = middle - 1;
            }

        }
        return low;

    }
}
