package company.bytedance.geek;

public class MaxProfitCold {
    public static void main(String[] args) {
        System.out.println(new MaxProfitCold().maxProfit(new int[]{2, 4, 1, 2}));
        System.out.println(new MaxProfitCold().maxProfitMP(new int[]{2, 4, 1, 2}));
        System.out.println(new MaxProfitCold().maxProfitMPsimple(new int[]{2, 4, 1, 2}));
    }
    
    public int maxProfitMP(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int[][][] mp = new int[n][2][2];
        mp[0][1][1] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            //今天没股票今天可以交易。要么前一天就没股票今天不做，要么前一天有股票今天给卖了
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][1][1] + prices[i]);
            //今天没股票今天还不可交易。这一天的利润最大只能和前一天卖出的状态的最大利润一样
            mp[i][0][0] = mp[i - 1][0][1];
            //今天有股票今天可以交易。要么前一天就有股票今天不做的最大利润，要么前一天不可交易的最大利润今天买,不能是mp[i][0][1]- prices[i]，因为这包含了代表昨天卖的情况
            mp[i][1][1] = Math.max(mp[i - 1][1][1], mp[i - 1][0][0] - prices[i]);
//      mp[i][1][0]不存在，不可能今天有股票今天却不能交易
        }
        
        return Math.max(mp[n - 1][0][0], mp[n - 1][0][1]);
    }
    
    public int maxProfitMPsimple(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int[][][] mp = new int[n][2][2];
        mp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][1][1] + prices[i]);
            mp[i][0][0] = mp[i - 1][0][1];
            mp[i][1][1] = Math.max(mp[i - 1][1][1], mp[i - 1][0][0] - prices[i]);
        }
        
        return Math.max(mp[n - 1][0][0], (mp[n - 1][0][1]));
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int[] sell = new int[n];
        int[] buy = new int[n];
        int[] cool = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] = sell[i - 1];
        }
        return sell[n - 1];
    }
}