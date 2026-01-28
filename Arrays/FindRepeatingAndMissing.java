// Problem: Find the Repeating and Missing Number
//
// Description:
// Given an array of size n containing numbers from 1 to n,
// one number is repeating and one number is missing.
// Find both numbers.
//
// Approach:
// - Use sum and sum of squares formulas.
// - Let x = repeating, y = missing.
// - Solve using equations:
//   x - y = (actualSum - expectedSum)
//   x^2 - y^2 = (actualSqSum - expectedSqSum)
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class FindRepeatingAndMissing {

    public static int[] findNumbers(int[] arr, int n) {

        long S = (long) n * (n + 1) / 2;
        long S2 = (long) n * (n + 1) * (2L * n + 1) / 6;

        long s = 0, s2 = 0;

        for (int num : arr) {
            s += num;
            s2 += (long) num * num;
        }

        long diff = s - S;          // x - y
        long sqDiff = s2 - S2;      // x^2 - y^2

        long sum = sqDiff / diff;   // x + y

        long x = (diff + sum) / 2;  // repeating
        long y = sum - x;           // missing

        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 5, 3};
        int n = 5;

        int[] result = findNumbers(arr, n);

        System.out.println("Repeating: " + result[0]);
        System.out.println("Missing: " + result[1]);
    }
}
