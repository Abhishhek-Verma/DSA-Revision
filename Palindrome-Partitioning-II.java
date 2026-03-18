1class Solution {
2  static int[] dp;
3  public int minCut(String s) {
4    int n = s.length();
5    dp = new int[n];
6    Arrays.fill(dp, -1);
7    return solve(0, s) - 1;
8    }
9   private int solve(int idx, String s) {
10    if (idx == s.length()) return 0;
11    if (dp[idx] != -1) return dp[idx];
12
13    int min = Integer.MAX_VALUE;
14    for (int i = idx; i < s.length(); i++) {
15        if (isPalindrome(idx, i, s)) {
16            int cuts = 1 + solve(i + 1, s);
17            min = Math.min(min, cuts);
18        }
19    }
20
21    return dp[idx] = min;
22}
23    private static boolean isPalindrome(int i, int j, String s) {
24        while (i <= j) {
25            if (s.charAt(i++) != s.charAt(j--)) {
26                return false;
27            }
28        }
29        return true;
30    }
31}