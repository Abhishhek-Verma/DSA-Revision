class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            if (set1.contains(x)) {
                ans.add(x);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}