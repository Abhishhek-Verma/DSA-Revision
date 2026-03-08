1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        boolean done = true;
5        for(int i =0;i<n-1;i++){
6            if(s.charAt(i)>s.charAt(i+1)){
7                done = false;
8            break;
9        }
10    }
11        if(done) return 0;
12        char min =s.charAt(0);
13        char max =s.charAt(0);
14        for(int i =1;i<n;i++){
15            if(s.charAt(i)<min) min = s.charAt(i);
16            if(s.charAt(i)>max) max = s.charAt(i);
17        }
18        if(n==2) return -1;
19        if(s.charAt(0)==min || s.charAt(n-1)==max) return 1;
20        if(s.charAt(0)==max && s.charAt(n-1)==min){
21            int fmin = s.indexOf(min);
22            int lmax = s.lastIndexOf(max);
23            if(fmin==n-1  && lmax ==0){
24                return 3;
25            }
26        } 
27       return 2;
28    }
29}