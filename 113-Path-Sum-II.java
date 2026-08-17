class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solve(root, targetSum, path, ans);
        return ans;
    }
    private void solve(TreeNode root, int targetSum,List<Integer> path,List<List<Integer>> ans) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        // Leaf node
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            solve(root.left, targetSum - root.val, path, ans);
            solve(root.right, targetSum - root.val, path, ans);
        }
        // Backtrack
        path.remove(path.size() - 1);
    }
}