1class Solution {
2    public int minCost(int n) {
3        int ans =0;
4        while(n>1){
5            ans+=(n-1);
6            n--;
7        }
8        return ans;
9    }
10}