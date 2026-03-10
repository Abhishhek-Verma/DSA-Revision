1class Solution {
2    public int maxProfit(int k, int[] nums) {
3         int n = nums.length;
4       int [][][] dp = new int[n+1][2][k+1];
5        int profit;
6        for (int i = n - 1; i >= 0; i--) {
7            for (int j = 0; j <=1; j++) {
8                for (int cap = 1; cap <= k; cap++) {
9                    if (j == 1) {
10                        profit = Math.max(-nums[i] + dp[i+1][0][cap],0+ dp[i+1][1][cap]);
11                    } else {
12                        profit = Math.max(nums[i] + dp[i+1][1][cap-1], 0+ dp[i+1][0][cap]);
13                    }
14                   dp[i][j][cap]= profit;
15                }
16            }
17        }
18        return dp[0][1][k];
19    }
20}