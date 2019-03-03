package company.bytedance.geek;

public class UniquePathsWeight {
    public int uniquePathsWeight(int m, int n) {
        int[][] map = new int[m][n];
        
        //only 1 way to get to ith row, 0th column (move down)
        for (int i = 1; i < m; i++) {
            map[i][0] = map[i - 1][0] + map[i][0];
        }
        
        //only 1 way to get to ith column, 0th row (move right)
        for (int j = 1; j < n; j++) {
            map[0][j] = map[0][j - 1] + map[0][j];
        }
        
        //x ways to get to ith row, jth column (# of ways to get to
        //ith - 1 row, jth column + # of ways to get to jth - 1 column
        //ith column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = Math.max(map[i - 1][j] + map[i][j], map[i][j - 1] + map[i][j]);
            }
        }
        
        return map[m - 1][n - 1];
    }
}

