1class Solution {
2    public int smallestBalancedIndex(int[] nums) {
3        int n = nums.length;
4        long[]r = new long[n+1];
5        long l =0;
6        r[n]=1;
7        for(int i=n-1;i>=0;i--){
8            long temp = r[i+1]*nums[i];
9            if(temp<0) temp = Long.MAX_VALUE;
10            r[i]=temp;
11        }
12
13        for(int i =0;i<n;i++){
14            long pro = r[i+1];
15            if(l==pro) return i;
16            l+=nums[i];
17        }
18        return -1;
19    }
20}