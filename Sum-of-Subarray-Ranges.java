1class Solution {
2    public long subArrayRanges(int[] nums) {
3         long res=0;
4        for(int i=0;i<nums.length;i++){
5            int max=Integer.MIN_VALUE;
6            int min=Integer.MAX_VALUE;
7            for(int j=i;j<nums.length;j++){
8                max=Math.max(max,nums[j]);
9                min=Math.min(min,nums[j]);
10                res+=max-min;
11            }
12        }
13        return res;
14    }
15}