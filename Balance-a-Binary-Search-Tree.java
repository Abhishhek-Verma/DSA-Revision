1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    private void inorder(TreeNode root, List<Integer> nodes) {
18        if (root == null) return;
19        inorder(root.left, nodes);
20        nodes.add(root.val);
21        inorder(root.right, nodes);
22    }
23    private TreeNode buildBST(int left, int right, List<Integer> nodes) {
24        if (left > right) return null;
25        int mid = (left + right) / 2; 
26        TreeNode root = new TreeNode(nodes.get(mid));
27        root.left = buildBST(left, mid - 1, nodes);
28        root.right = buildBST(mid + 1, right, nodes);
29
30        return root;
31    }
32    public TreeNode balanceBST(TreeNode root) {
33        List<Integer> nodes = new ArrayList<>();
34        inorder(root, nodes);
35        return buildBST(0, nodes.size() - 1, nodes);
36    }
37}