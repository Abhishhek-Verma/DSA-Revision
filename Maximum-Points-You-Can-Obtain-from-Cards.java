1class Solution {
2    public int maxScore(int[] nums, int k) {
3        int n  = nums.length;
4        int lsum =0, rsum=0,max=0;
5        for(int i=0;i<k;i++) lsum+=nums[i];
6        max = lsum;
7        int rem = n-1;
8        for(int i= k-1;i>=0;i--){
9            lsum -=nums[i];
10            rsum+=nums[rem];
11            rem--;
12            max = Math.max(max, lsum+rsum);
13        }
14        return max;
15    }
16}