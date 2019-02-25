package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return result;
        Arrays.sort(nums);
        sortNums(nums, 0, nums.length);
        return result;
    }

    public List<Integer> set(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void sortNums(int[] nums, int start, int len) {
        if (len - 1 == start) {
            result.add(set(nums));
            return;
        }
        for (int j = start; j < len; j++) {
            if (j != start && nums[j] == nums[start]) {
                continue;
            }
            swap(nums, start, j);
            int[] nums2 = nums.clone();
            sortNums(nums2, start + 1, len);
        }
    }

    public void swap(int[] nums, int n, int j) {
        int temp = nums[n];
        nums[n] = nums[j];
        nums[j] = temp;
    }
}