1class Solution {
2    public int maxSatisfaction(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5       int ans=0;
6        for(int i =0;i<n;i++){
7              int max =Integer.MIN_VALUE;
8              int sum =0;
9              int cnt =1;
10              for(int j =i;j<n;j++){
11                sum+= nums[j]*cnt;
12                cnt++;
13                max = Math.max(max,sum);
14              }
15              ans = Math.max(max,ans);
16        }
17        return ans;
18    }
19}