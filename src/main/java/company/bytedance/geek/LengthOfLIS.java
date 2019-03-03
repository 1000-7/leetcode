package company.bytedance.geek;

import java.util.Arrays;

public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        dfs(memo, nums, 1);
        Arrays.sort(memo);
        return memo[memo.length - 1];
    }
    
    private void dfs(int[] memo, int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        dfs(memo, nums, ++i);
    }
}