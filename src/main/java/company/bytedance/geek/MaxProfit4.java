package company.bytedance.geek;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class MaxProfit4 {
    public static void main(String[] args) {
        System.out.println(new MaxProfit4().maxProfit(2, new int[]{2, 1, 2, 0, 1}));
        System.out.println(new MaxProfit4().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new MaxProfit4().maxProfit(1, new int[]{2, 1}));
        System.out.println(new MaxProfit4().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new MaxProfit4().maxProfit(4, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
    
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return greedy(prices);
        }
        if (k == 1) {
            return one(prices);
        }
        //0次交易也算一种情况，所以至多2次交易，要存0，1，2三种情况
        k = k + 1;
        
        int[][][] mp = new int[prices.length][k][2];
        for (int i = 0; i < k; i++) {
            mp[0][i][1] = -prices[0];
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                max = Math.max(max, mp[i][j][0]);
            }
        }
        return max;
    }
    
    private int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
    
    private int one(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}