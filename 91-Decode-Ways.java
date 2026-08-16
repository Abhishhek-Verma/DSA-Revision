class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new Integer[n];
        return solve(s, 0);
    }
    private int solve(String s, int idx) {
        // Successfully decoded the entire string
        if (idx == s.length())
            return 1;
        // Number starts with 0 -> invalid
        if (s.charAt(idx) == '0')
            return 0;
        // Already calculated
        if (dp[idx] != null)
            return dp[idx];
        // Take one digit
        int ways = solve(s, idx + 1);
        // Take two digits if valid
        if (idx + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) {
                ways += solve(s, idx + 2);
            }
        }
        return dp[idx] = ways;
    }
}