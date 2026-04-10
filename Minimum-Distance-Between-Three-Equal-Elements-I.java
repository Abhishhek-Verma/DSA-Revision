1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length;
4        HashMap<Integer, ArrayList<Integer>> mpp = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            mpp.putIfAbsent(nums[i], new ArrayList<>());
7            mpp.get(nums[i]).add(i);
8        }
9        int min = Integer.MAX_VALUE;
10        for (ArrayList<Integer> lst : mpp.values()) {
11            if (lst.size() < 3) continue;
12            for (int i = 0; i <= lst.size() - 3; i++) {
13                int first = lst.get(i);
14                int third = lst.get(i + 2);
15                min = Math.min(min, 2 * (third - first));
16            }
17        }
18        return min == Integer.MAX_VALUE ? -1 : min;
19    }
20}