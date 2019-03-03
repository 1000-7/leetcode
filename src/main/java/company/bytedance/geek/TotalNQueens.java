package company.bytedance.geek;

import java.util.ArrayList;
import java.util.List;

public class TotalNQueens {
    
    
    public static void main(String[] args) {
        System.out.println(new TotalNQueens().solveNQueens(5));
    }
    
    public List<List<String>> solveNQueens(int n) {
        // 该数组很重要 下标为所在行 值为 该行皇后所在的列
        int[] location = new int[n];
        List<List<String>> res = new ArrayList();
        insertQueen(n, 0, location, res);
        return res;
    }
    
    public void insertQueen(int n, int row, int[] location, List<List<String>> res) {
        // 如果当前行到达超出最后一行 构造结果
        if (row == n) {
            List<String> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == location[i]) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            res.add(list);
            return;
        }
        // 遍历所有列 插入皇后
        for (int i = 0; i < n; i++) {
            location[row] = i;
            if (check(row, location)) {
                insertQueen(n, row + 1, location, res);
            }
        }
        
    }
    
    // 检验当前皇后所在位置是否有效
    private boolean check(int row, int[] location) {
        // 遍历当前行的之前所有行
        for (int i = 0; i < row; i++) {
            // 如果当前行皇后所在的列 和之前行皇后所在的列相等 或者 在同一对角线上 返回false
            if (location[row] == location[i] || Math.abs(location[row] - location[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}