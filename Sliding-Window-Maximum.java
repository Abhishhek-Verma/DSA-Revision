1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        Deque<Integer> dq = new ArrayDeque<>(); 
4        List<Integer> res = new ArrayList<>();
5        for (int i = 0; i < nums.length; i++) {
6            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
7                dq.removeLast();
8            }
9            dq.addLast(i);
10            if (dq.getFirst() == i - k) {
11                dq.removeFirst();
12            }
13            if (i >= k - 1) {
14                res.add(nums[dq.peek()]);
15            }
16        }
17        return res.stream().mapToInt(i->i).toArray();            
18    }
19}