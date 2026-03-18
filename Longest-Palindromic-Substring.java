1class Solution {
2    public String longestPalindrome(String s) {
3        String ans="";
4           //if(s.length()<=1) return "";
5           for(int i =0;i<s.length();i++){
6           String odd = solve(i,i,s);
7           String even= solve(i,i+1,s);
8             if(odd.length()>ans.length()) ans = odd;
9             if(even.length()>ans.length()) ans = even;
10           }
11           return ans;
12    }
13    private String solve(int i , int j , String s){
14      while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
15            i--;
16            j++;
17      }
18      return s.substring(i+1,j);
19    }
20}