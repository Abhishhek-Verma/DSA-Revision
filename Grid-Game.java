1class Solution {
2    public long gridGame(int[][] grid) {
3        int n = grid[0].length;
4        long topSum = 0;
5        for(int j=0;j<n;j++) topSum += grid[0][j];
6        long bottomSum = 0;
7        long ans = Long.MAX_VALUE;
8        for(int j=0;j<n;j++){
9            topSum -= grid[0][j];
10            ans = Math.min(ans, Math.max(topSum, bottomSum));
11            bottomSum += grid[1][j];
12        }
13        return ans;
14    }
15}