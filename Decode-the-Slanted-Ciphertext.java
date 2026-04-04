1class Solution {
2    public String decodeCiphertext(String s, int r) {
3        if (r == 1) return s; // single row — no transformation needed
4        int n = s.length();
5        
6        int c = (int)Math.ceil((double) n / r); // compute number of columns
7        char[][] mat = new char[r][c]; // allocate the r x c matrix
8        char[] arr = s.toCharArray(); // convert for fast indexing
9        int p = 0; // pointer into arr
10
11        for (int i = 0; i < r; i++) { // fill matrix row by row
12            for (int j = 0; j < c; j++) { // mirroring how encodedText was read
13                mat[i][j] = arr[p++];
14            }
15        }
16
17        StringBuilder res = new StringBuilder();
18        for (int k = 0; k < c; k++) { // for each diagonal starting column
19            int x = 0, y = k;
20            while (x < r && y < c) { // walk diagonal down-right
21                res.append(mat[x][y]); // collect characters in original order
22                x++; y++;
23            }
24        }
25        
26        return res.toString().stripTrailing(); // remove padding spaces at the end
27    }
28}