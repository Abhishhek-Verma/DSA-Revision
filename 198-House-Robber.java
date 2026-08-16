class Solution {
    public int rob(int[] nums) {
        Integer[]dp = new Integer[nums.length];
         return solve(nums, nums.length-1,dp);
    }
    private int solve(int[]nums, int n, Integer[]dp){
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=null) return dp[n];
        int pick = nums[n]+ solve(nums,n-2,dp);
        int notPick =0+ solve(nums,n-1,dp);
        return dp[n]=Math.max(pick, notPick);
    }
}