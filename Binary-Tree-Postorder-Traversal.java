1class Solution {
2    public List<Integer> postorderTraversal(TreeNode root) {
3        List<Integer> ans = new ArrayList<>();
4        if(root == null) return ans;
5
6        Stack<TreeNode> st = new Stack<>();
7        st.push(root);
8
9        while(!st.isEmpty()){
10            TreeNode cur = st.pop();
11            ans.add(cur.val);
12
13            if(cur.left != null) st.push(cur.left);
14            if(cur.right != null) st.push(cur.right);
15        }
16
17        Collections.reverse(ans);
18        return ans;
19    }
20}