1class Solution {
2    public int totalFruit(int[] arr) {
3        int k =2;
4        HashMap<Integer, Integer> mpp = new HashMap<>();
5        int left = 0, right = 0, max = 0;
6        while (right < arr.length) {
7
8            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);
9            if (mpp.size() > k) {
10                while (mpp.size() > k) {
11                    mpp.put(arr[left], mpp.getOrDefault(arr[left], 0) - 1);
12                    if (mpp.get(arr[left]) == 0)
13                        mpp.remove(arr[left]);
14                    left++;
15                }
16            }
17            if (mpp.size() <= k) {
18                max = Math.max(max, right - left + 1);
19            }
20            right++;
21        }
22        return max;
23    }
24}