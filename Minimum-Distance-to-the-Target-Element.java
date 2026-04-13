1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int res = nums.length;
4        for(int i = 0; i < nums.length; i++){
5            if(nums[i] == target){
6                res = Math.min(res, Math.abs(i - start));
7            }
8        }
9        return res;
10    }
11}