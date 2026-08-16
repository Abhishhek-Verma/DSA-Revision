class Solution {
    //private int min = Integer.MAX_VALUE;
    Integer[][] dp;
    public int minPathSum(int[][] mm) {
        int m = mm.length;
        int n = mm[0].length;
        dp = new Integer[m][n];
        return solve(0, 0, mm, m, n);
    }
private int solve(int r, int c, int[][] a, int m, int n) {
       if (r == m - 1 && c == n - 1) return a[r][c];

        if (dp[r][c] != null) return dp[r][c];

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (r + 1 < m) down = solve(r + 1, c, a,m, n);
        if (c + 1 < n) right = solve(r, c + 1, a, m, n);

        return dp[r][c] = a[r][c] + Math.min(down, right);
    }
}