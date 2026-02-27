1class Solution {
2    public int primePalindrome(int n) {
3     if (n <= 11) {
4            int[] small = {2, 3, 5, 7, 11};
5            for (int x : small)
6                if (x >= n) return x;
7        }
8        for (int i = 1; i <= 100000; i++) {
9            int pal = buildPalindrome(i);
10            if (pal >= n && isPrime(pal))
11                return pal;
12        }
13        return -1;
14    }
15    private int buildPalindrome(int x) {
16        int res = x;
17        x /= 10;
18        while (x > 0) {
19            res = res * 10 + x % 10;
20            x /= 10;
21        }
22        return res;
23    }
24    private boolean isPrime(int n) {
25        if (n < 2) return false;
26        if (n % 2 == 0) return n == 2;
27
28        for (int i = 3; i * i <= n; i += 2)
29            if (n % i == 0)
30                return false;
31        return true;
32    }
33}