1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder sb = new StringBuilder();
4        for(String x: words){
5            int ans =0;
6            for(char c: x.toCharArray()) ans+=weights[c-'a'];
7            int temp = ans%26;
8            sb.append((char)('z'-temp));
9        }
10        return sb.toString();
11    }
12}