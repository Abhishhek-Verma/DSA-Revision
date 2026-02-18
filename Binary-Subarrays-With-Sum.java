1class Solution {
2    public int numSubarraysWithSum(int[] nums, int k) {
3         return solve(nums,k)-solve(nums,k-1);
4    }
5    private static int solve(int[]nums, int k){
6        if(k<0) return 0;
7        int left =0, right =0, cnt=0,sum=0;
8        while(right<nums.length){
9            sum=sum+nums[right];
10            while(sum>k){
11                sum=sum-nums[left];
12                left++;
13            }
14            cnt =cnt+ (right-left+1);
15            right++;
16        }
17        return cnt;
18    }
19}