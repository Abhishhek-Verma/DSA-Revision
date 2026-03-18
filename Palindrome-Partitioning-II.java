1class Solution {
2    static int[] dp;
3    static boolean[][] pal;
4
5    public int minCut(String s) {
6        int n = s.length();
7        dp = new int[n];
8        Arrays.fill(dp, -1);
9        pal = new boolean[n][n];
10        // Precompute palindrome table
11        for (int i = n - 1; i >= 0; i--) {
12            for (int j = i; j < n; j++) {
13                if (s.charAt(i) == s.charAt(j)) {
14                    if (j - i <= 2) pal[i][j] = true;
15                    else pal[i][j] = pal[i + 1][j - 1];
16                }
17            }
18        }
19        return solve(0, s) - 1;
20    }
21    private int solve(int idx, String s) {
22        if (idx == s.length()) return 0;
23        if (dp[idx] != -1) return dp[idx];
24
25        int min = Integer.MAX_VALUE;
26        for (int i = idx; i < s.length(); i++) {
27            if (pal[idx][i]) {   // O(1) check
28                int cuts = 1 + solve(i + 1, s);
29                min = Math.min(min, cuts);
30            }
31        }
32        return dp[idx] = min;
33    }
34}