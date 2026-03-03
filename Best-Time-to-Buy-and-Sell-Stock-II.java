1class Solution {
2    Integer[][]dp;
3    public int maxProfit(int[] nums) {
4        dp= new Integer[nums.length][2];
5        int k = 1;
6      return  solve(nums,0,nums.length,k);
7    }
8    private int solve(int[]nums, int idx, int n , int k){
9        if(idx==n) return 0;
10        if(dp[idx][k]!=null) return dp[idx][k];
11        int profit;
12        if(k==1){
13          profit = Math.max(-nums[idx]+ solve(nums,idx+1,n,0),0+solve(nums,idx+1,n,1));
14        }else{
15            profit = Math.max(nums[idx]+solve(nums,idx+1,n,1),0+solve(nums, idx+1,n , 0));
16        }
17        return dp[idx][k]=profit;
18    }
19}