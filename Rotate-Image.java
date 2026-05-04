1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                swap(matrix, i, j, j, i);
8            }
9        }
10
11        for (int i = 0; i < n; i++) {
12            reverseRow(matrix, i);
13        }
14    }
15
16    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
17        int temp = matrix[i1][j1];
18        matrix[i1][j1] = matrix[i2][j2];
19        matrix[i2][j2] = temp;
20    }
21
22    private void reverseRow(int[][] matrix, int row) {
23        int left = 0, right = matrix.length - 1;
24        while (left < right) {
25            swap(matrix, row, left, row, right);
26            left++;
27            right--;
28        }
29    }
30}