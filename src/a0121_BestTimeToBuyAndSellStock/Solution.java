/*
Say you have an array for which
the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5
(not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0
In this case, no transaction is done, i.e. max profit = 0.
*/

package a0121_BestTimeToBuyAndSellStock;

public class Solution {

    public int maxProfit(int[] prices) {
        int result = 0, bought = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[bought]) {
                result = Math.max(result, prices[i] - prices[bought]);
            } else {
                bought = i;
            }
        }
        return result;
    }

}
