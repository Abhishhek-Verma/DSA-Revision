1class Solution {
2    public int findComplement(int n) {
3         String s = Integer.toBinaryString(n); 
4        int size = s.length(); 
5        int ones = (1 << size) - 1; 
6        int x = n ^ ones;
7        String xor= Integer.toBinaryString(x);
8       return Integer.parseInt(xor, 2);
9        
10    }
11}