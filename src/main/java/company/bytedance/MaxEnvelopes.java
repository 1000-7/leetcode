package company.bytedance;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] e = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 11}, {10, 11}};
        new MaxEnvelopes().maxEnvelopes(e);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length <= 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] n : envelopes) {
            int i = Arrays.binarySearch(dp, 0, len, n[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = n[1];
            if (i == len) len++;
        }
        return len;
    }
}

