1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if(n == 1) return nums[0];
5        Integer[] dp1 = new Integer[n];
6        Integer[] dp2 = new Integer[n];
7        int case1 = solve(nums, 0, n-2, dp1);
8        int case2 = solve(nums, 1, n-1, dp2);
9        return Math.max(case1, case2);
10    }
11    private int solve(int[] nums, int i, int end, Integer[] dp){
12        if(i > end) return 0;
13        if(dp[i] != null) return dp[i];
14        int pick = nums[i] + solve(nums, i+2, end, dp);
15        int notPick = solve(nums, i+1, end, dp);
16        return dp[i] = Math.max(pick, notPick);
17    }
18}