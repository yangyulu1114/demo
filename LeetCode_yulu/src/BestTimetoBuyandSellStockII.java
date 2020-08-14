public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0 || prices[i] <= prices[i - 1]) {
                profit += max;
                min = prices[i];
                max = 0;
            }
            min = Math.min(min, prices[i]);
            max = Math.max(max, (prices[i] - min));
        }
        profit += max;
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }


    public void test() {
        int[] input = new int[]{1,2,3,4,5};
        System.out.println(maxProfit2(input));
    }
}
