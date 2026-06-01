1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int total = 0;
5
6        for (int i = cost.length - 1; i >= 0; i -= 3) {
7            total += cost[i];
8            if (i - 1 >= 0)
9                total += cost[i - 1];
10        }
11
12        return total;
13    }
14}