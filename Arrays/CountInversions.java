// Problem: Count Inversions in an Array
//
// Description:
// Given an array of integers, count the number of inversions.
// An inversion is a pair (i, j) such that i < j and arr[i] > arr[j].
//
// Approach:
// - Use Merge Sort based technique.
// - Count inversions while merging two sorted halves.
// - If left[i] > right[j], then all remaining elements in left
//   form inversions with right[j].
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

public class CountInversions {

    public static long countInversions(long[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(long[] arr, int low, int high) {

        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        long count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    private static long merge(long[] arr, int low, int mid, int high) {

        long[] temp = new long[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        long inversions = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } 
            else {
                // Inversion found
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            arr[low + p] = temp[p];
        }

        return inversions;
    }

    public static void main(String[] args) {

        long[] arr = {5, 3, 2, 4, 1};
        System.out.println("Inversion Count: " + countInversions(arr));
    }
}
