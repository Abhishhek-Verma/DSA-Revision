1class Solution {
2    public int numRescueBoats(int[] arr, int k) {
3        int n = arr.length;
4        Arrays.sort(arr);
5        int l=0,r=n-1,cnt=0;
6       while(l<=r){
7        if(arr[l]+arr[r]<=k){
8            l++;
9            r--;
10        }
11        else r--;
12       cnt++;
13    }
14    return cnt;
15    }
16}