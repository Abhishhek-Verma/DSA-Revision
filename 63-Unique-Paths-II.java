class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] mm) {
        int m = mm.length;
        int n = mm[0].length;
        //start with obs so move not possible
        if (mm[0][0] == 1)
            return 0;
        dp=new Integer[m][n];
        return solve(0, 0, mm, m, n);
    }
    private int solve(int r, int c, int[][] a, int m, int n) {
        if (r >= m || c >= n || a[r][c] == 1)
            return 0;
        if (r == m - 1 && c == n - 1) return 1;
        if (dp[r][c] != null) return dp[r][c];
        int down = solve(r + 1, c, a, m, n);
        int right = solve(r, c + 1, a, m, n);
        return dp[r][c] = down + right;
    }
}