1class Solution {
2    public String shortestCommonSupersequence(String s, String t) {
3        int n = s.length();
4        int m = t.length();
5        int[][] dp = new int[n + 1][m + 1];
6        for (int i = 1; i <= n; i++) {
7            for (int j = 1; j <= m; j++) {
8                if (s.charAt(i - 1) == t.charAt(j - 1))
9                    dp[i][j] = 1 + dp[i - 1][j - 1];
10                else
11                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
12            }
13        }
14        StringBuilder sb = new StringBuilder();
15        int i = n;
16        int j = m;
17        while (i > 0 && j > 0) {
18            if (s.charAt(i-1) == t.charAt(j-1)) {
19                sb.append(s.charAt(i-1));
20                i--;
21                j--;
22            } else if (dp[i - 1][j] > dp[i][j - 1]) {
23                sb.append(s.charAt(i - 1));
24                i--;
25            } else {
26                sb.append(t.charAt(j - 1));
27                j--;
28            }
29        }
30        while (i > 0) {
31            sb.append(s.charAt(i - 1));
32            i--;
33        }
34        while (j > 0) {
35            sb.append(t.charAt(j - 1));
36            j--;
37        }
38        return sb.reverse().toString();
39    }
40}