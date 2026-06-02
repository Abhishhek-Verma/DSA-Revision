1class Solution {
2    public void setZeroes(int[][] matrix) {
3         int n = matrix.length;
4        int m = matrix[0].length;
5        int col0 = 1;
6        for (int i = 0; i < n; i++) {
7            for (int j = 0; j < m; j++) {
8                if (matrix[i][j] == 0) {
9                    matrix[i][0] = 0;
10                    if (j != 0) {
11                        matrix[0][j] = 0;
12                    } else {
13                        col0 = 0;
14                    }
15                }
16            }
17        }
18            for (int i = 1; i < n; i++) {
19                for (int j = 1; j < m; j++) {
20                    if (matrix[i][j] != 0) {
21                        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
22                            matrix[i][j] = 0;
23                        }
24                    }
25                }
26            }
27                if(matrix[0][0]==0){
28                    for(int j=0;j<m;j++){
29                        matrix[0][j]=0;
30                    }
31                }
32                if(col0==0){
33                    for(int i=0;i<n;i++){
34                        matrix[i][0]=0;
35                    }
36                }
37    }
38}