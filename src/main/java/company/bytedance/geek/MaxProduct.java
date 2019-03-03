package company.bytedance.geek;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{-2, -2, -1}));
        System.out.println(new MaxProduct().maxProduct2(new int[]{-2, -2, -1}));
    }
    
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] memoMax = new int[n];
        int[] memoMin = new int[n];
        memoMax[0] = nums[0];
        memoMin[0] = nums[0];
        int max = memoMax[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                memoMax[i] = Math.max(memoMax[i - 1] * nums[i], nums[i]);
                memoMin[i] = Math.min(memoMin[i - 1] * nums[i], nums[i]);
            } else {
                memoMax[i] = Math.max(memoMin[i - 1] * nums[i], nums[i]);
                memoMin[i] = Math.min(memoMax[i - 1] * nums[i], nums[i]);
            }
            max = Math.max(max, memoMax[i]);
        }
        return max;
        
    }
    
    /**
     * @param nums
     * @return 可以多用一个变量存储最大值，最后不需要排序；
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memoMax = new int[nums.length];
        int[] memoMin = new int[nums.length];
        memoMax[0] = nums[0];
        memoMin[0] = nums[0];
        dfs(nums, memoMax, memoMin, 1);
        Arrays.sort(memoMax);
        return memoMax[nums.length - 1];
    }
    
    public void dfs(int[] nums, int[] memoMax, int[] memoMin, int i) {
        if (i >= nums.length) {
            return;
        }
        if (nums[i] > 0) {
            memoMax[i] = Math.max(memoMax[i - 1] * nums[i], nums[i]);
            memoMin[i] = Math.min(memoMin[i - 1] * nums[i], nums[i]);
        } else {
            memoMax[i] = Math.max(memoMin[i - 1] * nums[i], nums[i]);
            memoMin[i] = Math.min(memoMax[i - 1] * nums[i], nums[i]);
        }
        dfs(nums, memoMax, memoMin, ++i);
    }
}