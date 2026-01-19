// Problem: Pascal’s Triangle
//
// Description:
// Given an integer numRows, generate the first numRows of Pascal's Triangle.
// Each number is the sum of the two numbers directly above it.
//
// Approach:
// - Build the triangle row by row.
// - First and last element of each row is 1.
// - Middle elements are sum of two numbers from previous row.
//
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

import java.util.*;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }

            if (i > 0) row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
