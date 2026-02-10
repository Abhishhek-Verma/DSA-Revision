1class Solution {
2    public int longestBalanced(int[] nums) {
3        int ans =0;
4        int n = nums.length;
5        for(int i =0;i<n;i++){
6            Set<Integer> e = new HashSet<>();
7            Set<Integer> o = new HashSet<>();
8            for(int j=i;j<n;j++){
9                int curr = nums[j];
10                if(curr%2==0){
11                    e.add(curr);
12                }
13                else{
14                    o.add(curr);
15                }
16            if(o.size()==e.size()){
17                int len = j-i+1;
18                ans = Math.max(ans, len);
19            }
20        }
21        }
22        return ans;
23    }
24}