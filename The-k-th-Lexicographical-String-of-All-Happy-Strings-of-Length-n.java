1class Solution {
2    static char[] arr = {'a','b','c'};
3    public String getHappyString(int n, int k) {
4        List<String> lst = new ArrayList<>();
5        solve("",n,k,lst);
6        Collections.sort(lst);
7        return lst.size()<k?"":lst.get(k-1);
8    }
9    private void solve(String s, int n ,int k , List<String>lst){
10         if(s.length()==n){
11            lst.add(s);
12            return;
13         }
14        for(char c : arr){
15            if(s.length() == 0 || s.charAt(s.length()-1) != c){
16                solve(s + c, n,k,lst);
17            }
18    }
19  }
20}
21