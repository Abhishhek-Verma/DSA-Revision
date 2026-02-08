1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        if (root == null) return true;
4        if (Height(root) == -1) return false;
5        return true;
6    }
7
8    public int Height(TreeNode root) {
9        if (root == null) return 0;
10        int leftHeight = Height(root.left);
11        int rightHeight = Height(root.right);
12        if (leftHeight == -1 || rightHeight == -1) return -1;
13        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
14        return Math.max(leftHeight, rightHeight) + 1;
15    }
16}
17