1class Solution {
2    public int rob(int[] nums) {
3        Integer[]dp = new Integer[nums.length];
4         return solve(nums, nums.length-1,dp);
5    }
6    private int solve(int[]nums, int n, Integer[]dp){
7        if(n==0) return nums[n];
8        if(n<0) return 0;
9        if(dp[n]!=null) return dp[n];
10        int pick = nums[n]+ solve(nums,n-2,dp);
11        int notPick =0+ solve(nums,n-1,dp);
12        return dp[n]=Math.max(pick, notPick);
13    }
14}