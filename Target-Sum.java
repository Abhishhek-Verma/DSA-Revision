1class Solution {
2    static int s;
3    public int findTargetSumWays(int[] nums, int k) { 
4        for(int x:  nums) s+=x;
5    Integer[][]dp = new Integer[nums.length][2*s+1]; 
6    return solve(nums,k,0, nums.length-1,dp);
7    }
8    private int solve(int[]nums, int k , int sum , int n,Integer[][]dp){
9        if(n==0) {
10            int cnt =0;
11            if(sum+nums[n]==k) cnt++;
12            if(sum-nums[n]==k) cnt++;
13            return cnt;
14        }
15        if(dp[n][sum+s]!=null) return dp[n][sum+s];
16        int plus = solve(nums,k,sum +nums[n],n-1,dp);
17        int mins = solve(nums,k,sum -nums[n],n-1,dp);
18        return dp[n][sum+s]= plus+mins;
19    }
20}