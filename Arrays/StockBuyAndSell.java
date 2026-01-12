// Problem: Stock Buy and Sell
//
// Description:
// Given an array where prices[i] is the price of a stock on day i,
// find the maximum profit by choosing one day to buy and
// a later day to sell.
//
// Approach:
// - Track the minimum price encountered so far.
// - For each day, calculate profit = currentPrice - minPrice.
// - Update maximum profit accordingly.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class StockBuyAndSell {

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}
