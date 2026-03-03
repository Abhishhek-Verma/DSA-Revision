1class Solution {
2    public int minDistance(String s, String t) {
3           return s.length()+t.length()-2*lcs(s,t);
4    }
5
6    private int lcs(String s, String t) {
7        int n = s.length();
8        int m = t.length();
9        int[][] dp = new int[n + 1][m + 1];
10        for (int i = n - 1; i >= 0; i--) {
11            for (int j = m - 1; j >= 0; j--) {
12                if (s.charAt(i) == t.charAt(j))
13                    dp[i][j] = 1 + dp[i + 1][j + 1];
14                else
15                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
16            }
17        }
18        return dp[0][0];
19    }
20}