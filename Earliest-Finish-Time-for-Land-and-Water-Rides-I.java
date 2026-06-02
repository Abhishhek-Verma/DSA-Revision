1class Solution {
2    private int calFinishTime(int[] ls, int[] ld,int[] ws, int[] wd) {
3
4        int mini = Integer.MAX_VALUE;
5
6        for (int i = 0; i < ls.length; i++) {
7            mini = Math.min(mini, ls[i] + ld[i]);
8        }
9
10        int ans = Integer.MAX_VALUE;
11
12        for (int i = 0; i < ws.length; i++) {
13            ans = Math.min(
14                ans,
15                Math.max(mini, ws[i]) + wd[i]
16            );
17        }
18
19        return ans;
20    }
21    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
22        return Math.min(
23            calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
24            calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
25        );
26    }
27}