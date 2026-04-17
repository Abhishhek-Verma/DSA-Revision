1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        Map<Integer, Integer> map = new HashMap<>();
4        int ans = Integer.MAX_VALUE;
5        for(int i = 0; i < nums.length; i++) {
6            int rev = fun(nums[i]);
7            if(map.containsKey(nums[i])) ans = Math.min(ans, i - map.get(nums[i]));
8            map.put(rev, i);
9        }
10        if(ans == Integer.MAX_VALUE) return -1;
11        return ans;
12    }
13    int fun(int num) {
14        int temp = 0;
15        while(num > 0) {
16            int rem = num % 10;
17            temp = (temp * 10) + rem;
18            num /= 10;
19        }
20        return temp;
21    }
22}