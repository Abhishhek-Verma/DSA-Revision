1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length;
4        int[]pre = new int[n];
5        int max = nums[0];
6        for(int i =0;i<n;i++){
7            max = Math.max(max, nums[i]);
8            pre[i]= gcd(nums[i],max);
9        }
10        Arrays.sort(pre);
11        int i =0,j=n-1;
12        long sum=0;
13        
14        while(i<j){
15            int gcd2 = gcd(pre[i],pre[j]);
16            sum+=gcd2;
17            i++;
18            j--;
19        }
20        
21       return sum;
22    }
23    private int gcd(int a, int b){
24        if(b==0) return a;
25        return gcd(b,a%b);
26    }
27}