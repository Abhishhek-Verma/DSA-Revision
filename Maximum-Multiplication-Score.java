1class Solution {
2    Long[][] dp;
3    public long maxScore(int[] a, int[] b) {
4        int m = b.length;
5        dp = new Long[4][m];
6        return solve(0, 0,m, a, b);
7    }
8
9    private long solve(int i, int j, int m, int[] a, int[] b) {
10
11        if (i == 4)  return 0;
12        if (j == m) return (long)-1e18;
13
14        if (dp[i][j] != null) return dp[i][j];
15        long take = a[i] * 1L * b[j] + solve(i + 1, j + 1, m, a, b) ;
16        long nottake = solve(i, j + 1, m, a, b);
17        return dp[i][j] = Math.max(take, nottake);
18
19    }
20}