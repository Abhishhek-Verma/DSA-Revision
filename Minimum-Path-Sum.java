1class Solution {
2    private int min = Integer.MAX_VALUE;
3    public int minPathSum(int[][] mm) {
4        int m = mm.length;
5        int n = mm[0].length;
6        int[] di = {1, 0};
7        int[] dj = {0, 1};
8        Integer[][] dp = new Integer[m][n];
9        return solve(0, 0, mm, di, dj, m, n, 0, dp);
10    }
11
12private int solve(int r, int c, int[][] a, int[] di, int[] dj, int m, int n, int curr, Integer[][] dp) {
13        if (r == m - 1 && c == n - 1) return a[r][c];
14        if (dp[r][c] != null) return dp[r][c];
15        int best = Integer.MAX_VALUE;
16        for (int i = 0; i < 2; i++) {
17            int nextR = r + di[i];
18            int nextC = c + dj[i];
19            if (nextR < m &&  nextC < n ) {
20                best = Math.min(best, solve(nextR, nextC, a, di, dj, m, n, curr + a[r][c], dp));
21            }
22        }
23        return dp[r][c] = a[r][c] + (best == Integer.MAX_VALUE ? 0 : best);
24    }
25}