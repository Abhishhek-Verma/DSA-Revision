1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length;
4        int n = mat[0].length;
5        k = k % n;
6        if (k == 0) return true;
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (i % 2 == 0) {
10                    if (mat[i][j] != mat[i][(j + k) % n])
11                        return false;
12                } else {
13                    if (mat[i][j] != mat[i][(j + n - k) % n])
14                        return false;
15                }
16            }
17        }
18        return true;
19    }
20}