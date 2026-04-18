1class Solution {
2    public int mirrorDistance(int n) {
3        int copy =n;
4        int rev =0;
5        while(n>0){
6            rev= rev*10+n%10;
7            n=n/10;
8        }
9        return Math.abs(copy-rev);
10    }
11}