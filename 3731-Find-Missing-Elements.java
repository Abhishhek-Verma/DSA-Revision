class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int x : nums) {
            lst.add(x);
        }
        int min = Collections.min(lst);
        int max = Collections.max(lst);
        for (int i = min; i <= max; i++) {
            if (lst.contains(i)) {
                lst.remove(Integer.valueOf(i));
            }
            else{
                lst.add(i);
            }
        }
        return lst;
    }
}