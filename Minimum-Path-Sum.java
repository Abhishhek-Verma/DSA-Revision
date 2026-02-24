1class Solution {
2    private int min = Integer.MAX_VALUE;
3    public int minPathSum(int[][] mm) {
4        int m = mm.length;
5        int n = mm[0].length;
6        // int[][] vis = new int[m][n];
7        int[] di = {1, 0};
8        int[] dj = {0, 1};
9        Integer[][] dp = new Integer[m][n];
10        return solve(0, 0, mm, di, dj, m, n, 0, dp);
11    }
12
13private int solve(int r, int c, int[][] a, int[] di, int[] dj, int m, int n, int curr, Integer[][] dp) {
14        if (r == m - 1 && c == n - 1) return a[r][c];
15        if (dp[r][c] != null) return dp[r][c];
16        int best = Integer.MAX_VALUE;
17        for (int i = 0; i < 2; i++) {
18            int nextR = r + di[i];
19            int nextC = c + dj[i];
20            if (nextR < m &&  nextC < n ) {
21                best = Math.min(best, solve(nextR, nextC, a, di, dj, m, n, curr + a[r][c], dp));
22            }
23        }
24        return dp[r][c] = a[r][c] + (best == Integer.MAX_VALUE ? 0 : best);
25    }
26}