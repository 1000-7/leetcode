package company.bytedance.array;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{1, 12, 3, 4, 3, 2}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        for (int n = 0; n < nums.length; n++) {
            integers.add(nums[n]);
        }
        int ans = 0;
        while (k > 0) {
            ans = integers.poll();
            k--;
        }
        return ans;
    }
}