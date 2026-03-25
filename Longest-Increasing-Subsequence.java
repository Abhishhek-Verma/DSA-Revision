1class Solution {
2    public int lengthOfLIS(int[] nums) {
3       int n = nums.length;
4        int[][] dp = new int[n + 1][n + 1];
5        // all fill 0  base case ke liye  jo phle se java me hota h
6        for (int idx = n - 1; idx >= 0; idx--) {
7            for (int prev = idx - 1; prev >= -1; prev--) {
8                int notTake = 0+ dp[idx + 1][prev + 1];
9                int take = 0;
10                if (prev == -1 || nums[idx] > nums[prev]) {
11                    take = 1 + dp[idx + 1][idx + 1];
12                }
13                dp[idx][prev + 1] = Math.max(notTake, take);
14            }
15        }
16        return dp[0][0];
17    }
18}