package company.bytedance.geek;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
    
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                continue;
            }
            dp[coins[i]] = 1;
        }
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}