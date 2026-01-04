// Problem: Linear Search in an Array
// Approach: Traverse array and compare each element
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LinearSearch {

    public static int linearSearch(int[] arr, int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // element found
            }
        }

        return -1; // element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 5};
        int x = 7;

        System.out.println(linearSearch(arr, x));
    }
}
