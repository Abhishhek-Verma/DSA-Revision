1class Solution {
2    private int min = Integer.MAX_VALUE;
3    public int minPathSum(int[][] mm) {
4        int m = mm.length;
5        int n = mm[0].length;
6        Integer[][] dp = new Integer[m][n];
7        return solve(0, 0, mm, m, n, dp);
8    }
9
10private int solve(int r, int c, int[][] a, int m, int n, Integer[][] dp) {
11       if (r == m - 1 && c == n - 1) return a[r][c];
12        if (dp[r][c] != null) return dp[r][c];
13
14        int down = Integer.MAX_VALUE;
15        int right = Integer.MAX_VALUE;
16
17        if (r + 1 < m) down = solve(r + 1, c, a,m, n, dp);
18        if (c + 1 < n) right = solve(r, c + 1, a, m, n, dp);
19
20        return dp[r][c] = a[r][c] + Math.min(down, right);
21    }
22}