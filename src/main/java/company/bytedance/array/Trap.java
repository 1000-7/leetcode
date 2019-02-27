package company.bytedance.array;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap {
    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Trap().trap(new int[]{2, 1, 0, 1, 3}));
        System.out.println(new Trap().trap(new int[]{4, 1, 3}));
        System.out.println(new Trap().trap(new int[]{5, 4, 1, 2}));
        System.out.println(new Trap().trap(new int[]{5, 4, 1, 2, 1, 5}));
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int area = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                --right;
            }
        }
        return area;
    }

}