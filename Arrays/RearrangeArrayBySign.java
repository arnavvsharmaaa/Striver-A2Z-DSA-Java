// Problem: Rearrange Array Elements by Sign
//
// Description:
// Given an array of even length containing equal numbers of
// positive and negative integers, rearrange the array such that
// positives are at even indices and negatives at odd indices.
// The relative order of elements must be preserved.
//
// Approach:
// - Use an auxiliary array.
// - Maintain two pointers:
//   posIndex for even positions, negIndex for odd positions.
// - Traverse the original array and place elements accordingly.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

public class RearrangeArrayBySign {

    public static int[] rearrangeArray(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        int posIndex = 0;
        int negIndex = 1;

        for (int num : arr) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, -2, -5, 2, -4};

        int[] result = rearrangeArray(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
