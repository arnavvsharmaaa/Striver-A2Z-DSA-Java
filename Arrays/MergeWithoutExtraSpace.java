// Problem: Merge Two Sorted Arrays Without Extra Space
//
// Description:
// Given two sorted arrays arr1 and arr2, merge them such that
// arr1 contains the first n smallest elements and arr2 contains
// the remaining m elements. Do this without using extra space.
//
// Approach:
// - Use the Gap Method (similar to Shell Sort).
// - Treat both arrays as a single combined array.
// - Compare elements at a distance of 'gap' and swap if needed.
// - Reduce gap until it becomes 0.
//
// Time Complexity: O((n+m) log(n+m))
// Space Complexity: O(1)

public class MergeWithoutExtraSpace {

    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < len) {

                // Both in arr1
                if (left < n && right < n) {
                    if (arr1[left] > arr1[right]) {
                        swap(arr1, left, right);
                    }
                }
                // left in arr1, right in arr2
                else if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        long temp = arr1[left];
                        arr1[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                // Both in arr2
                else {
                    if (arr2[left - n] > arr2[right - n]) {
                        swap(arr2, left - n, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) gap = 0;
            else gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
