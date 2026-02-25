1class Solution {
2    //private int min = Integer.MAX_VALUE;
3    public int minimumTotal(List<List<Integer>> nums) {
4        int m = nums.size();
5        Integer[][]dp = new Integer[m][m];
6        return solve(nums,0,0,dp);
7    }
8    private int solve(List<List<Integer>>lst,int level, int idx, Integer[][]dp){
9         if(level == lst.size()-1){
10            return lst.get(level).get(idx);
11        }
12        if(dp[level][idx] != null)  return dp[level][idx];
13
14        int down = solve(lst, level+1, idx, dp);
15        int diag = solve(lst, level+1, idx+1, dp);
16
17        return dp[level][idx] = lst.get(level).get(idx) + Math.min(down, diag);
18    }
19}