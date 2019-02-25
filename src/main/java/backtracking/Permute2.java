package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute2 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return result;
        int len = nums.length;
        sortNums(nums, 0, len);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void sortNums(int[] nums, int n, int len) {
        List<Integer> list = new ArrayList<>();
        if (len - 1 == n) {
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int j = n; j < len; j++) {
            swap(nums, n, j);
            int[] nums2=nums.clone();
            sortNums(nums2, n + 1, len);
//            swap(nums, n, j);      //不还原，for不同次的循环使用的nums不同
        }
    }

    public void swap(int[] nums, int n, int j) {
        int temp = nums[n];
        nums[n] = nums[j];
        nums[j] = temp;
    }

}