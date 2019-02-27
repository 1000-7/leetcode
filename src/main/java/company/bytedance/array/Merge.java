package company.bytedance.array;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(9, 18));
        System.out.println(new Merge().merge(intervals));

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        intervals.sort((o1, o2) -> {
            int minus = o1.start - o2.start;
            if (minus == 0) {
                return o1.end - o2.end;
            }
            return minus;
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        res.add(new Interval(start, end));
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Interval.class.getSimpleName() + "[", "]")
                .add("start=" + start)
                .add("end=" + end)
                .toString();
    }
}