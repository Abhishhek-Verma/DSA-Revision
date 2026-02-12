1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int ans =0;
5        for(int i =0;i<n;i++){
6            int[] cnt = new int[26]; 
7            for(int j = i;j<n;j++){
8                cnt[s.charAt(j)-'a']++;
9                int freq = 0;
10                boolean t = false;
11                for(int x: cnt){
12                    if(x>0){
13                        if(freq==0){
14                            freq=x;
15                        }
16                        else if(freq!=x){
17                            t = true;
18                            break;
19                        }
20                    }
21                }
22                if(!t){
23                    ans = Math.max(ans,j-i+1);
24                }
25            }
26        }
27        return ans;
28    }
29}