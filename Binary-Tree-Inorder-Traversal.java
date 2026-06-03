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
19        List<Integer>ans = new ArrayList<>();
20        Stack<TreeNode>st = new Stack<>();
21       TreeNode node = root;
22       while(true){
23        if(node!=null){
24            st.push(node);
25            node = node.left;
26        }
27        else{
28            if(st.isEmpty()){
29                break;
30            }
31            node = st.pop();
32            ans.add(node.val);
33            node = node.right;
34        }
35       }
36       return ans;
37    }
38}