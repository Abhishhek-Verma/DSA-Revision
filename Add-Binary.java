1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder result = new StringBuilder();
4        int i= a.length()-1;
5        int j=b.length()-1;
6        int carry=0;
7
8        while(i>=0 || j>=0 || carry==1){
9            int total=carry;
10            if(i>=0){
11                total+=a.charAt(i--) -'0';
12            }
13            if(j>=0){
14                total+=b.charAt(j--) - '0';
15            }
16            result.append(total%2);
17            carry= total/2;
18        }
19        return result.reverse().toString();
20    }
21}