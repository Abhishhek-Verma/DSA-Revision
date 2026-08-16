class Solution {
    static int s;
    public int findTargetSumWays(int[] nums, int k) { 
        for(int x:  nums) s+=x;
    Integer[][]dp = new Integer[nums.length][2*s+1]; 
    return solve(nums,k,0, nums.length-1,dp);
    }
    private int solve(int[]nums, int k , int sum , int n,Integer[][]dp){
        if(n==0) {
            int cnt =0;
            if(sum+nums[n]==k) cnt++;
            if(sum-nums[n]==k) cnt++;
            return cnt;
        }
        if(dp[n][sum+s]!=null) return dp[n][sum+s];
        int plus = solve(nums,k,sum +nums[n],n-1,dp);
        int mins = solve(nums,k,sum -nums[n],n-1,dp);
        return dp[n][sum+s]= plus+mins;
    }
}