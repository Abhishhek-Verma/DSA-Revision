1class Solution {
2
3    private int calFinishTime(int[] ls, int[] ld,
4                              int[] ws, int[] wd) {
5
6        int mini = Integer.MAX_VALUE;
7        int ans = Integer.MAX_VALUE;
8
9        for (int i = 0; i < ls.length; i++) {
10            mini = Math.min(mini, ls[i] + ld[i]);
11        }
12
13        for (int i = 0; i < ws.length; i++) {
14            int finish = Math.max(mini, ws[i]) + wd[i];
15            ans = Math.min(ans, finish);
16        }
17
18        return ans;
19    }
20
21    public int earliestFinishTime(int[] landStartTime,
22                                  int[] landDuration,
23                                  int[] waterStartTime,
24                                  int[] waterDuration) {
25
26        int landFirst = calFinishTime(
27            landStartTime, landDuration,
28            waterStartTime, waterDuration
29        );
30
31        int waterFirst = calFinishTime(
32            waterStartTime, waterDuration,
33            landStartTime, landDuration
34        );
35
36        return Math.min(landFirst, waterFirst);
37    }
38}