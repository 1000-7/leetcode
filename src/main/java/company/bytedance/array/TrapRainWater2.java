package company.bytedance.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. 接雨水 II
 * 说明:
 * <p>
 * m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出如下 3x6 的高度图:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * 返回 4。
 * <p>
 * <p>
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 */
public class TrapRainWater2 {
    public int trapRainWater(int[][] heightMap) {
        //S1:行数和列数必须大于等于3才可以积水
        if (heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        //S2:初始化
        int result = 0;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int rows = heightMap.length;
        int colums = heightMap[0].length;
        boolean[][] mark = new boolean[rows][colums];//默认为false
        PriorityQueue<QItem> prioQueue = new PriorityQueue<QItem>(Comparator.comparingInt(o -> o.h));
        //S3:将四周方块push到优先级队列中
        for (int i = 0; i < colums; i++) {
            prioQueue.add(new QItem(0, i, heightMap[0][i]));//第一行
            mark[0][i] = true;
            prioQueue.add(new QItem(rows - 1, i, heightMap[rows - 1][i]));//最后一行
            mark[rows - 1][i] = true;
        }
        for (int i = 1; i < rows - 1; i++) {
            prioQueue.add(new QItem(i, 0, heightMap[i][0]));//第一列
            mark[i][0] = true;
            prioQueue.add(new QItem(i, colums - 1, heightMap[i][colums - 1]));//最后一列
            mark[i][colums - 1] = true;
        }
        //S4:核心
        while (!prioQueue.isEmpty()) {
            QItem item = prioQueue.remove();//获取对头元素(h最小的元素)
            for (int i = 0; i < 4; i++) {
                int newx = item.x + dx[i];
                int newy = item.y + dy[i];
                if (newx < 0 || newx >= rows ||
                        newy < 0 || newy >= colums || mark[newx][newy]) {
                    continue;
                }
                int h = item.h;//此时外围最低高度
                if (h > heightMap[newx][newy]) {
                    result += h - heightMap[newx][newy];
                    heightMap[newx][newy] = h;
                }
                mark[newx][newy] = true;
                prioQueue.add(new QItem(newx, newy, heightMap[newx][newy]));//push到队列中
            }
        }
        return result;
    }

    /**
     * 自定义优先级队列元素的数据结构
     */
    private class QItem {
        int x;
        int y;
        int h;

        public QItem(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}