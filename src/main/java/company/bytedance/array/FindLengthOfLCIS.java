package company.bytedance.array;

import java.util.Arrays;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] lcis = new int[nums.length];
        Arrays.fill(lcis, 1);
        dfs(lcis, nums, 1);
        Arrays.sort(lcis);
        return lcis[lcis.length - 1];
    }
    
    private void dfs(int[] lcis, int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }
        if (nums[i - 1] < nums[i]) {
            lcis[i] = lcis[i - 1] + 1;
        }
        dfs(lcis, nums, ++i);
    }
}