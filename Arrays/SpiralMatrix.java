// Problem: Print the Matrix in Spiral Order
//
// Description:
// Given an m x n matrix, print all elements in spiral order.
//
// Approach:
// - Use four boundaries: top, bottom, left, right.
// - Traverse in 4 directions and shrink boundaries after each round.
//
// Time Complexity: O(m*n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left to Right
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                // Right to Left
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                // Bottom to Top
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix));
    }
}
