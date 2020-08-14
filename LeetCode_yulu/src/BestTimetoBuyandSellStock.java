public class BestTimetoBuyandSellStock {

   // 公式 dp[i]代表第i 天卖的最大值，第i天卖的收益最大值就是第i天的股价-前i天的最小值
    //即dp[i] = prices[i]-min[i]
    public int maxProfit(int[] prices) {
//要谨防数组越界
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        int diff = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            diff = prices[i] - min;
            max = Math.max(diff, max);
        }

        return max;
    }

    public int maxProfit2(int[] prices) {

        int max = 0, min = Integer.MAX_VALUE, diff = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            diff = prices[i] - min;
            max = Math.max(diff, max);
        }

        return max;
    }

    public void test() {
        int value = maxProfit2(new int[]{
                7, 6, 4, 3, 1
        });
        System.out.println(value);
    }
}
