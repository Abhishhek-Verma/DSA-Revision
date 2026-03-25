1class Solution {
2    public int minNumberOperations(int[] a) {
3        int op = a[0];
4        for (int i = 1; i < a.length; i++) {
5            if (a[i] > a[i - 1])
6                op += a[i] - a[i - 1];
7        }
8        return op;
9    }
10}