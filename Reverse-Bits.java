1class Solution {
2    public String addzero(int len, String s){
3        String zero="";
4        for(int i =0;i<len;i++){
5            zero+="0";
6        }
7        return zero+s;
8    }
9    public int reverseBits(int n) {
10        String s = Integer.toBinaryString(n);
11        int len = s.length();
12       s= addzero(32-len,s);
13        StringBuilder sb = new StringBuilder();
14        sb.append(s);
15        sb.reverse();
16          return Integer.parseInt(sb.toString(),2);
17    }
18}