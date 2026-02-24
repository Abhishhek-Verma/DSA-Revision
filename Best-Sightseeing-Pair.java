1class Solution {
2    public int maxScoreSightseeingPair(int[] arr) {
3         int best = arr[0];  
4        int res = Integer.MIN_VALUE;
5
6        for(int j=1;j<arr.length;j++){
7            res = Math.max(res, best + arr[j] - j);
8            best = Math.max(best, arr[j] + j);
9        }
10        return res;
11    }
12}