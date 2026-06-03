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
17    public List<Integer> preorderTraversal(TreeNode root) {
18        List<Integer>ans = new ArrayList<>();
19        if(root == null) return ans;
20        Stack<TreeNode>st = new Stack<>();
21        st.push(root);
22        while(!st.isEmpty()){
23            root = st.pop();
24            ans.add(root.val);
25            if(root.right !=null) st.push(root.right);
26            if(root.left !=null) st.push(root.left);
27        }
28        return ans;
29    }
30}