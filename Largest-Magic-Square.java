1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[][] rowSum = new int[m][n + 1];
6        int[][] colSum = new int[m + 1][n];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
10                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
11            }
12        }
13
14        int maxSize = Math.min(m, n);
15        for (int k = maxSize; k >= 2; k--) {
16            for (int i = 0; i + k <= m; i++) {
17                for (int j = 0; j + k <= n; j++) {
18                    if (isMagic(grid, rowSum, colSum, i, j, k)) {
19                        return k;
20                    }
21                }
22            }
23        }
24        return 1;
25    }
26
27    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int r, int c, int k) {
28
29        int target = rowSum[r][c + k] - rowSum[r][c];
30        for (int i = r; i < r + k; i++) {
31            if (rowSum[i][c + k] - rowSum[i][c] != target) {
32                return false;
33            }
34        }
35        for (int j = c; j < c + k; j++) {
36            if (colSum[r + k][j] - colSum[r][j] != target) {
37                return false;
38            }
39        }
40        int diag1 = 0, diag2 = 0;
41        for (int i = 0; i < k; i++) {
42            diag1 += grid[r + i][c + i];
43            diag2 += grid[r + i][c + k - 1 - i];
44        }
45
46        return diag1 == target && diag2 == target;
47    }
48}