1class Solution {
2    public int maxProfit(int[] nums) {
3        int ans =0;
4        for(int i =1;i<nums.length;i++){
5            if(nums[i]>nums[i-1]){
6                ans+=nums[i]- nums[i-1];
7            }
8        }
9        return ans;
10    }
11}