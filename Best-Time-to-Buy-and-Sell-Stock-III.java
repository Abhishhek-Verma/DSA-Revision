1class Solution {
2    Integer[][][]dp;
3    public int maxProfit(int[] nums) {
4          dp= new Integer[nums.length][2][3];
5        int k = 1;
6      return  solve(nums,0,nums.length,k,2);
7    }
8    private int solve(int[]nums, int idx, int n , int k, int cap){
9        if(cap==0) return 0;
10        if(idx==n) return 0;
11        if(dp[idx][k][cap]!=null) return dp[idx][k][cap];
12        int profit;
13        if(k==1){
14          profit = Math.max(-nums[idx]+ solve(nums,idx+1,n,0,cap),0+solve(nums,idx+1,n,1,cap));
15        }else{
16           profit = Math.max(nums[idx]+solve(nums,idx+1,n,1,cap-1),0+solve(nums, idx+1,n , 0,cap));
17        }
18        return dp[idx][k][cap]=profit;
19    }
20}