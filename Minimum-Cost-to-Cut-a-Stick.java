1class Solution {
2    int[][] dp;
3    public int minCost(int n, int[] cuts) {
4        List<Integer> lst = new ArrayList<>();
5        lst.add(0);
6        Arrays.sort(cuts);
7        for (int x : cuts)
8            lst.add(x);
9        lst.add(n);
10        dp = new int[cuts.length+2][cuts.length+2];
11        for (int[] a : dp)
12            Arrays.fill(a, -1);
13        return solve(lst, 1, lst.size()-2);
14    }
15    private int solve(List<Integer> lst, int i, int j) {
16        if (i > j) return 0;
17        int min = Integer.MAX_VALUE;
18        if (dp[i][j] != -1)
19            return dp[i][j];
20        for (int k = i; k <=j; k++) {
21            int ans = lst.get(j + 1) - lst.get(i - 1) + solve(lst, i, k - 1) + solve(lst, k+1, j);
22            min = Math.min(min, ans);
23        }
24        return dp[i][j] = min;
25    }
26}