package company.bytedance.geek;

public class NQueensBit {
    private int count = 0;
    
    public static void main(String[] args) {
        System.out.println(new NQueensBit().totalNQueens(4));
    }
    
    public int totalNQueens(int n) {
        if (n < 1) {
            return count;
        }
        dfs(n, 0, 0, 0, 0);
        return count;
    }
    
    private void dfs(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & -bits;
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & bits - 1;
        }
    }
}
