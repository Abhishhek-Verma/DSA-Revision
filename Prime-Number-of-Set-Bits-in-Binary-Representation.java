1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int cnt = 0;
4        for (int i = left; i <= right; i++) {
5            int bits = Integer.bitCount(i);
6            if (isPrime(bits)) {
7                cnt++;
8            }
9        }
10        return cnt;
11    }
12
13    private boolean isPrime(int n) {
14        if (n <= 1) {
15            return false;
16        }
17        for (int i = 2; i * i <= n; i++) {
18            if (n % i == 0) {
19                return false;
20            }
21        }
22        return true;
23    }
24}