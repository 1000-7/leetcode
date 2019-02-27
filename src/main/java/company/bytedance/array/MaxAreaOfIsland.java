package company.bytedance.array;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int num = dfs(grid, i, j);
                    if (num > max) {
                        max = num;
                    }
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        } else {
            return 0;
        }
    }

}