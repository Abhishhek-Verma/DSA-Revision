1class Solution {
2    private static final int MOD = 1000000007;
3    public int countGoodNumbers(long n) {
4        long even = (n+1) / 2;
5        long odd = n/2;
6        long temp1 = modPow(4, odd);
7        long temp2 = modPow(5, even);
8        long ans = (temp1 * temp2) % MOD;
9        return (int) ans;
10    }
11    private long modPow(long base, long exp){
12        long res = 1;
13        base %= MOD;
14        while(exp > 0){
15            if((exp & 1) == 1) res = (res * base) % MOD;
16            base = (base * base) % MOD;
17            exp >>= 1;
18        }
19        return res;
20    }
21}