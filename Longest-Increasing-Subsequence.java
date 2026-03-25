1class Solution {
2    int[][] dp;
3
4    public int lengthOfLIS(int[] nums) {
5        int n = nums.length;
6        dp = new int[n][n + 1];
7        for (int[] a : dp)
8            Arrays.fill(a, -1);
9        return solve(nums, 0, -1);
10    }
11
12    private int solve(int[] nums, int idx, int prev) {
13        if (idx == nums.length)
14            return 0;
15        if (dp[idx][prev+1] != -1)
16            return dp[idx][prev+1];
17        int notTake = 0 + solve(nums, idx + 1, prev);
18        if (prev == -1 || nums[idx] > nums[prev])
19            notTake = Math.max(notTake, 1 + solve(nums, idx + 1, idx));
20        return dp[idx][prev+1] = notTake;
21    }
22}