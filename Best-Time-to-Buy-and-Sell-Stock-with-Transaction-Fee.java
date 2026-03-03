1class Solution {
2    public int maxProfit(int[] nums, int fee) {
3        int n = nums.length;
4        Integer[][] dp = new Integer[n + 1][2];
5        dp[n][0] = dp[n][1] = 0;
6        int profit;
7        for (int idx = n - 1; idx >= 0; idx--) {
8            for (int k = 0; k <= 1; k++) {
9                if (k == 1) {
10                    profit = Math.max(-nums[idx] - fee + dp[idx + 1][0], 0 + dp[idx + 1][1]);
11                } else {
12                    profit = Math.max(nums[idx] + dp[idx + 1][1], 0 + dp[idx + 1][0]);
13                }
14                dp[idx][k] = profit;
15            }
16        }
17        return dp[0][1];
18    }
19}