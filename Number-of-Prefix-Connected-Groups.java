1class Solution {
2    public int prefixConnected(String[] words, int k) {
3        HashMap<String, Integer> mpp = new HashMap<>();
4        for(String ch: words){
5            if(ch.length()<k) continue;
6            String p = ch.substring(0,k);
7            mpp.put(p,mpp.getOrDefault(p,0)+1);
8        }
9        int ans =0;
10        for(int x: mpp.values()){
11            if(x>=2) ans++;
12        }
13        return ans;
14    }
15}