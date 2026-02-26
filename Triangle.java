1class Solution {
2    //private int min = Integer.MAX_VALUE;
3    public int minimumTotal(List<List<Integer>> nums) {
4        int m = nums.size();
5        Integer[][]dp = new Integer[m][m];
6         return solve(nums,0,0,0, dp);
7
8    }
9    private int solve(List<List<Integer>>lst,int level, int idx, int curr, Integer[][]dp){
10        //curr+=lst.get(level).get(idx);
11         if(level == lst.size()-1){
12            return lst.get(level).get(idx);
13        }
14        if(dp[level][idx]!=null) return dp[level][idx];
15        int down = solve(lst, level+1, idx, curr,dp);
16        int dia = solve(lst, level+1, idx+1, curr,dp);
17        return dp[level][idx]= lst.get(level).get(idx)+ Math.min(down, dia);
18    }
19}