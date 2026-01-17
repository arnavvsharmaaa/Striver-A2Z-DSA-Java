// Problem: Set Matrix Zeroes
//
// Description:
// Given an m x n matrix, if an element is 0, set its entire row
// and column to 0. Do it in-place with O(1) extra space.
//
// Approach:
// - Use first row and first column as markers.
// - Use two flags to track if first row/column should be zero.
//
// Time Complexity: O(m*n)
// Space Complexity: O(1)

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0 = false, col0 = false;

        // Check first row
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) row0 = true;

        // Check first column
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) col0 = true;

        // Mark rows & columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Apply zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // First row
        if (row0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // First column
        if (col0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
