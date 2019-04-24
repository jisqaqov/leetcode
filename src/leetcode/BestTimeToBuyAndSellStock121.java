package leetcode;

/**
 * @author Jandos Iskakov
 * problem: 121. Best Time to Buy and Sell Stock
 * time complexity: O(n)
 * space complexity: O(1)
 * algorithm: DP
 */
public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 solution = new BestTimeToBuyAndSellStock121();
        solution.test();
    }

    public void test() {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0, buy = -1;

        for (int i = 0; i < prices.length; i++) {
            buy = (i == 0)? prices[i]: Math.min(prices[i], buy);

            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }

}

