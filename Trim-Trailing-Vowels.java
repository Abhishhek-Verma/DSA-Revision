1class Solution {
2    public String trimTrailingVowels(String s) {
3        int n = s.length()-1;
4        while(n>=0){
5            if((s.charAt(n)=='a') || s.charAt(n)=='e' || s.charAt(n)=='i' || s.charAt(n)=='o' || s.charAt(n)=='u' ){
6            n--;
7            }
8            else{
9                break;
10            }
11        }
12        return s.substring(0,n+1);
13    }
14}