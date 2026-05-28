1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> res = new ArrayList<>();
4        int n = matrix.length;
5        int m = matrix[0].length;
6        int left = 0, right = m - 1;
7        int top = 0, bottom = n - 1;
8        while (top <= bottom && left <= right) {
9            for (int i = left; i <= right; i++) {
10                res.add(matrix[top][i]);
11            }
12            top++;
13            for (int i = top; i <= bottom; i++) {
14                res.add(matrix[i][right]);
15            }
16            right--;
17            if (top <= bottom) {
18                for (int i = right; i >= left; i--) {
19                    res.add(matrix[bottom][i]);
20                }
21                bottom--;
22            }
23            if (left <= right) {
24                for (int i = bottom; i >= top; i--) {
25                    res.add(matrix[i][left]);
26                }
27                left++;
28            }
29        }
30        return res;
31    }
32}
33