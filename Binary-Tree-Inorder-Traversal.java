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
17    List<Integer>lst;
18    public List<Integer> inorderTraversal(TreeNode root) {
19       lst= new ArrayList<>();
20        solve(root);
21        return lst;
22    }
23    void solve(TreeNode root){
24        if(root ==null){
25            return;
26        }
27        solve(root.left);
28        lst.add(root.val);
29        solve(root.right);
30    }
31}